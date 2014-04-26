package com.MichaelFAbbott.customView;

import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.content.Context;

import java.util.HashSet;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import com.MichaelFAbbott.myfirstapp.R;

public class Tile 
{
      // static --------------------------
   public static final double SQRT_3 = Math.sqrt( 3 );
   private static Path drawPath;
   private static Drawable allBackgrounds[][];
   private static int NUM_TYPES = 2,
                      NUM_GRAPHICS_PER_TYPE = 3;
   private static int FIELD = 0,
                      SAND  = 1;

   static
   {
      drawPath = new Path();
      drawPath.moveTo( 1, 0 );
      
      double d_rad = Math.PI / 3;
      
      for( double ang = 2 * Math.PI; ang > 0; ang -= d_rad )
         drawPath.lineTo( (float) Math.cos( ang ), 
                          (float) Math.sin( ang ) );

      drawPath.close();

      allBackgrounds = null;
   }

   private static void createBackgrounds( Context c )
   {
      if( allBackgrounds == null )
      {
         allBackgrounds = new Drawable[ NUM_TYPES ][ NUM_GRAPHICS_PER_TYPE ];

         allBackgrounds[ FIELD ][ 0 ] = c.getResources().getDrawable( R.drawable.field_1 );
         allBackgrounds[ FIELD ][ 1 ] = c.getResources().getDrawable( R.drawable.field_2 );
         allBackgrounds[ FIELD ][ 2 ] = c.getResources().getDrawable( R.drawable.field_3 );
         allBackgrounds[ SAND ][ 0 ] = c.getResources().getDrawable( R.drawable.sand_1 );
         allBackgrounds[ SAND ][ 1 ] = c.getResources().getDrawable( R.drawable.sand_2 );
         allBackgrounds[ SAND ][ 2 ] = c.getResources().getDrawable( R.drawable.sand_3 );
         for( Drawable[] list : allBackgrounds )
            for( Drawable d : list )
            {
               if( d != null )
                  d.setBounds( -1, -1, 1, 1 );
            }
      }
   }

      
   private final int row, col;
   private final float x, y;
   private Paint brush;

   private int fill_color = 0;
   private GameMap map;
   private int mostMovePoints;
   private int moveCost = 1;
   private Drawable background;


      // constructor using row and col index
   public Tile( GameMap m, int r, int c )
   {
      map = m;
      row = r;
      col = c;

      createBackgrounds( map.getContext() );

      brush = new Paint();
      brush.setDither( true );
      brush.setAntiAlias( true );
      brush.setStrokeJoin( Paint.Join.ROUND );
      brush.setStrokeCap( Paint.Cap.ROUND );

      if( col % 2 == 0 )
      {
         x = (float) (col * 3.0f / 2.0 + 1);
         y = (float) ((row + 1) * SQRT_3);
      }
      else
      {
         x = (float) (2.5 + 3 * (col - 1) / 2.0);
         y = (float) (( 0.5 + row ) * SQRT_3);
      }
      
      mostMovePoints = -1;

         // this stuff is just me playing, seeing how things work.
         // {
      Random rand = new Random();
      moveCost = rand.nextInt( NUM_TYPES ) + 1;
      int img = rand.nextInt( NUM_GRAPHICS_PER_TYPE );
      background = allBackgrounds[ moveCost - 1 ][ img ];
         // }

   }

   public void draw( Canvas canvas )
   {
      canvas.save();
      canvas.translate( (float) x, (float) y );

      if( background != null )
         background.draw( canvas );
   
      /*
      brush.setColor( 0xFF000000 );
      brush.setStyle( Paint.Style.STROKE );
      canvas.drawPath( drawPath, brush );
      */

      brush.setColor( fill_color );
      brush.setStyle( Paint.Style.FILL );

      canvas.drawPath( drawPath, brush );

      canvas.restore();
   }

   public double distance( float map_x, float map_y )
   {
      float[] point = { map_x - x, map_y - y };

      return PointF.length( point[0], point[1] );
   }

   public int getRow()
   {
      return row;
   }

   public int getCol()
   {
      return col;
   }

      // color is in the form that Brush.setColor() uses:
      //  > first byte is   opacity
      //  > second byte is  red
      //  > third byte is   green
      //  > fourth byte is  blue
   public void setFill( int color )
   {
      fill_color = color;
   }

   public HashSet<Tile> getPossibleMoves()
   {
      HashSet<Tile> set = new HashSet<Tile>();
         
         // we add moveCost because it costs points to 
         // move into a new tile. since we are already in
         // this tile, we do not want to subtract its cost
         // which getPossibleMoves( HashSet<Tile>, int ) does
      getPossibleMoves( set, 4 + moveCost );

      for( Tile t : set )
         t.clearMovePoints();

      return set;
   }

   private void getPossibleMoves( HashSet<Tile> set, int ptsBefore )
   {
      int ptsAfter = ptsBefore - moveCost;

      if( ptsAfter < 0 ) return; // unable to enter
      if( ptsAfter <= mostMovePoints ) return;

      mostMovePoints = ptsAfter;
      set.add( this );

      for( Tile t : map.getSurrounding( row, col ) )
      {
         if( t == null )
            continue;
         
            // I am going to have to redo the whole tree rooted
            // here anyway, so lets just quit now
         if( t.mostMovePoints > ptsBefore )
            return;
      }

      for( Tile t : map.getSurrounding( row, col ) )
      {
         if( t == null )
            continue;

         t.getPossibleMoves( set, ptsAfter );         
      }
   }

   public List<Tile> findPath( Tile dest )
   {
      return findPath( dest, 4 + moveCost );
   }

   boolean findVisitted;
   private List<Tile> findPath( Tile dest, int ptsBefore )
   {
      System.err.println( this );
      int ptsAfter = ptsBefore - moveCost;

      if( findVisitted ) return null;
      if( ptsAfter < 0 ) return null;
      if( ptsAfter == 0 && ! this.equals( dest ) ) return null;

      if( this.equals( dest ) )
         return new ArrayList<Tile>();

      findVisitted = true;

         // this is y - dest.y because 'y' is in screen coordinates,
         // and angle is the typical 0 along positive x-axis, increasing CCW
      double angle = Math.toDegrees( Math.atan2( y - dest.y, dest.x - x ) );
      if( angle < 0 ) angle += 360;
      int firstGuess = (int) angle / 60;
      boolean startCCW = Math.abs( (int) angle / 30 ) % 2 == 0;
     
      Tile[] surrounding = map.getSurrounding( row, col );
      List retList = surrounding[ firstGuess ].findPath( dest, ptsAfter );
      if( retList == null ) System.err.println( " fail." );
      for( int n = 0; retList == null && n < 5; ++n )
      {
         int guess;
         if( startCCW )
            guess = firstGuess + (n/2 + 1)*(int)Math.pow( -1, n+1 );
         else
            guess = firstGuess + (n/2 + 1)*(int)Math.pow( -1, n );
         
         if( guess < 0 )
            guess += 6;
         else if( guess >= 6 )
            guess -= 6;

         System.err.println( guess );
         
         retList = surrounding[ guess ].findPath( dest, ptsAfter ); 
         if( retList == null ) System.err.println( " fail." );
      }

      if( retList != null )
         retList.add( this );

      findVisitted = false;

      if( retList == null )
      System.err.println( "no path found" );

      return retList;
   }

   public int hashCode()
   {
      return row * 7 + col;
   }

   private void clearMovePoints()
   {
      mostMovePoints = -1;
   }

   public boolean equals( Tile t )
   {
      return row == t.row && col == t.col;
   } 

   public String toString()
   {
      return "Tile @ [" + row + ", " + col + "]";
   }
   
}
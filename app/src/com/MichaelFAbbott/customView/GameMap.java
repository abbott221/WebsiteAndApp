package com.MichaelFAbbott.customView;

import java.util.*;
import android.graphics.*;
import android.content.*;
import android.view.*;

public class GameMap extends View
{
   private Tile[][] board;
   private GameMap.TouchListener touch_listener;
   private GameMap.ScaleListener scale_listener;
   private GestureDetector gestures;
   private ScaleGestureDetector scale_gestures;

      // the xy map coordinate that is the top left of the screen
   private PointF translation = new PointF( 0, 0 );
   private float scale = 20;

   private Matrix transformation = new Matrix();
   
   private Context context;

   public GameMap( Context context, int num_row, int num_col )
   {
      super( context );
      this.context = context;
      board = new Tile[ num_row + 2 ][ num_col + 2 ];

         // since we have a row of 'nulls' on each edge
         // we use   ` <= '
      for( int row = 1; row <= num_row; ++row )
         for( int col = 1; col <= num_col; ++col )
            board[ row ][ col ] = new Tile( this, row, col );

      touch_listener = new GameMap.TouchListener();
      gestures = new GestureDetector( 
                              context, touch_listener );

      scale_listener = new GameMap.ScaleListener();
      scale_gestures = new ScaleGestureDetector( 
                              context, scale_listener );
   }

   @Override
   public void onDraw( Canvas canvas )
   {
      canvas.drawColor( 0xFFDDDDDD );
      canvas.translate( - translation.x, - translation.y );
      canvas.scale( scale, scale );

      for( Tile[] list : board )
         for( Tile t : list )
         {
            if( t == null )
               continue;
            t.draw( canvas );
         }

      canvas.getMatrix( transformation );
   }

   @Override
   public void onMeasure( int w_ms, int h_ms )
   {
      int w, h;
      w = View.MeasureSpec.getSize( w_ms );
      h = View.MeasureSpec.getSize( h_ms );
      h = (int) (h * 2.0/3.0);

      setMeasuredDimension( w, h );
   }

   @Override
   public boolean onTouchEvent( MotionEvent e )
   {
      scale_gestures.onTouchEvent( e );

      if( !scale_gestures.isInProgress() )
         gestures.onTouchEvent( e );

      invalidate();
      return true;
   }

   public Tile getTileByIndex( int r, int c )
   {
      if( r < 0 || c < 0 || r > board.length || c > board[0].length )
         return null;
      else
         return board[r][c];
   }

   public Tile getTileByPixel( float s_x, float s_y )
   {
      float m_x = (s_x + translation.x) / scale;
      float m_y = (s_y + translation.y) / scale;
      
      int rect_col = (int) ( (m_x - 0.25) / 1.5 );
      int rect_row = (int) ( 2 * m_y / Tile.SQRT_3 );

         // for each r,c in rect grid, the correct
         // could be one of 3 tiles
      Tile[] possible = new Tile[ 3 ];

      int row = rect_row / 2;
      if( rect_col % 2 == 0 && rect_row % 2 == 0 ) 
         --row;

      possible[0] = getTileByIndex( row, rect_col );
      possible[1] = getTileByIndex( row, rect_col - 1 );
      possible[2] = getTileByIndex( row, rect_col + 1 );

      double min_dist = Double.MAX_VALUE;
      Tile best = null;
      for( Tile t : possible )
      {
         if( t == null )
            continue;

         double dist = t.distance( m_x, m_y );

         if( dist < 1 && dist < min_dist )
         {
            min_dist = dist;
            best = t;
         }
      }
      return best;
   }

   public Tile[] getSurrounding( int row, int col )
   {
      Tile[] surrounding = new Tile[6]; // hexagons have 6 neighbors

      surrounding[1] = board[ row - 1 ][ col     ];
      surrounding[4] = board[ row + 1 ][ col     ];

      if( col % 2 == 0 )
      {
         surrounding[2] = board[ row     ][ col - 1 ];
         surrounding[0] = board[ row     ][ col + 1 ];
         surrounding[3] = board[ row + 1 ][ col - 1 ];
         surrounding[5] = board[ row + 1 ][ col + 1 ];
      }
      else
      {
         surrounding[3] = board[ row     ][ col - 1 ];
         surrounding[5] = board[ row     ][ col + 1 ];
         surrounding[2] = board[ row - 1 ][ col - 1 ];
         surrounding[0] = board[ row - 1 ][ col + 1 ];
      }

      return surrounding;
   }

   private class TouchListener extends 
                        GestureDetector.SimpleOnGestureListener
   {
      private Tile start, dest;
      private List<Tile> path = new ArrayList<Tile>(); // avoid the null pointer check
      private HashSet<Tile> moves;
      @Override
      public boolean onSingleTapConfirmed( MotionEvent e )
      {
         Tile clicked = getTileByPixel( e.getX(), e.getY() );
         if( clicked == null ) return true;

         if( start == null )
         {
            // clear old path
            for( Tile t : path )
               t.setFill( 0 ); 

            start = clicked;
            moves = start.getPossibleMoves();
            for( Tile t : moves )
               t.setFill( 0x77FFFFFF );
            start.setFill( 0x8811CCCC );
         }
         else
         {
            for( Tile t : moves )
               t.setFill( 0 );

            dest = clicked;
            dest.setFill( 0x88CC1111 );

            path = start.findPath( dest );
            for( Tile t : path )
               t.setFill( 0x88000011 );

            start = null;
         }
            

/*
         if( selected != null )
         {
            selected.setFill( 0x77000000 );
            //HashSet<Tile> moves = selected.getPossibleMoves( 4 );
            Tile[] moves = getSurrounding( selected.getRow(), selected.getCol() );
            moves[0].setFill( 0x88CC11CC );
            moves[2].setFill( 0x88CC11CC );
            moves[4].setFill( 0x88CC11CC );
         }
*/
         
         invalidate();
          
         return true;
      }

      @Override
      public boolean onDoubleTap( MotionEvent e )
      {
         System.err.println( "double tap" );
         return true;
      }

      @Override
      public boolean onScroll( MotionEvent e1, MotionEvent e2,
                               float dx, float dy )
      {
         translation.offset( dx, dy );
         return true;
      }
      
   }

   private class ScaleListener extends 
                        ScaleGestureDetector.SimpleOnScaleGestureListener
   {
      @Override
      public boolean onScale( ScaleGestureDetector sgd )
      {
         scale *= sgd.getScaleFactor();
         scale = Math.max( 5, Math.min( scale, 50 ) );

         return true;
      }
   }

}

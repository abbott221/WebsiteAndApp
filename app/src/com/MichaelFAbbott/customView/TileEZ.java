package com.MichaelFAbbott.customView;

import android.graphics.*;

public class TileEZ
{
      // static --------------------------
   public static int radius = 20;

   private static Path drawPath;

   static
   {
      drawPath = new Path();
      drawPath.moveTo( 1, 0 );
      
      double d_rad = Math.PI / 3;
      
      for( double ang = 2 * Math.PI; ang > 0; ang -= d_rad )
         drawPath.lineTo( (float) Math.cos( ang ), 
                          (float) Math.sin( ang ) );

      drawPath.close();
   }

      
   private final int row, col;
   private Paint brush;

      // constructor using row and col index
   public TileEZ( int r, int c )
   {
      row = r;
      col = c;

      brush = new Paint();
      brush.setDither( true );
      brush.setAntiAlias( true );
      brush.setStrokeJoin( Paint.Join.ROUND );
      brush.setStrokeCap( Paint.Cap.ROUND );
   }

   //CustomDrawableView's onDraw()
   public void gameDraw( Canvas canvas )
   {
      double x, y;
      
      if( col % 2 == 0 )
      {
         x = col * 3.0 / 2.0;
         y = row * Math.sqrt( 3 );
      }
      else
      {
         x = 1.5 + 3 * (col - 1) / 2.0;
         y = ( -0.5 + row ) * Math.sqrt( 3 );
      }

      canvas.save();
      canvas.scale( radius, radius );
      canvas.translate( (float) x, (float) y );
   
      brush.setColor( 0xFF000000 );
      brush.setStyle( Paint.Style.STROKE );

      canvas.drawPath( drawPath, brush );

      canvas.restore();
      

   }

}
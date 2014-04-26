package com.MichaelFAbbott.customView;

import java.util.*;
import android.graphics.*;
import android.content.*;
import android.view.*;

public class GameMapEZ extends View
{
   private ArrayList<ArrayList<TileEZ>> board;

   public GameMapEZ( Context context, int num_row, int num_col )
   {
      super( context );
      board = new ArrayList< ArrayList<TileEZ> >();

      for( int row = 0; row < num_row; ++row )
      {
         ArrayList<TileEZ> row_list = new ArrayList<TileEZ>();
         board.add( row_list );
         for( int col = 0; col < num_col; ++col )
            row_list.add( new TileEZ( row, col ) ); 
      }
   }

   @Override
   public void onDraw( Canvas canvas )
   {
      for( ArrayList<TileEZ> list : board )
         for( TileEZ t : list )
            t.gameDraw( canvas );
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

}

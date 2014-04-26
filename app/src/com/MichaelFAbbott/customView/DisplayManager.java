package com.MichaelFAbbott.customView;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;

public class DisplayManager extends RelativeLayout
{
   GameMap map;
   public DisplayManager( Context c )
   {
      super( c );
      map = new GameMap( c, 70, 40 );
      RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams( 
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT );

      lp.addRule( ALIGN_PARENT_TOP );


      addView( map, lp );
   }
}
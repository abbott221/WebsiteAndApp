package com.MichaelFAbbott.customView;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;

public class DisplayManagerEZ extends RelativeLayout
{
   GameMapEZ map;
   public DisplayManagerEZ( Context c )
   {
      super( c );
      map = new GameMapEZ( c, 10, 10 );
      RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams( 
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT );

      lp.addRule( ALIGN_PARENT_TOP );


      addView( map, lp );
   }
}
package com.MichaelFAbbott.myCustomView;

import android.content.*;
import android.graphics.*;
import android.os.Vibrator;
import android.view.*;
import android.widget.*;

public class Board_Layout extends RelativeLayout
{
   Board_CustomView map;
   
   //private Vibrator haptic;
   
   public Board_Layout( Context c, Vibrator v )
   {
      super( c );
      
      //haptic = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
      //haptic = v;
      
      map = new Board_CustomView( c, v );
      RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams( 
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT );

      lp.addRule( ALIGN_PARENT_TOP );


      addView( map, lp );
   }
}
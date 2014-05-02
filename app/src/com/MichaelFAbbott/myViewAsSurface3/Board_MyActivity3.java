package com.MichaelFAbbott.myViewAsSurface3;


import com.MichaelFAbbott.myViewAsSurface2.Board_MySurfaceView2;
import com.MichaelFAbbott.myfirstapp.AttemptController1;
import com.MichaelFAbbott.myfirstapp.AttemptModel1;
import com.MichaelFAbbott.myfirstapp.R;
import com.MichaelFAbbott.standards.AttemptController;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Displays information about this application.
 * 
 * @author Dan Ruscoe (ruscoe.org)
 * @version 1.0
 */
public class Board_MyActivity3 extends Activity
{
    
	private Board_MyView3 lolView;
	
	
	private LinearLayout lolContainer;
	
	
	
	/** Called when the activity is first created. */
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        
        
        /*
        <com.MichaelFAbbott.myViewAsSurface3.Board_MyView3
        android:id="@+id/xmlSurfaceRep"
        android:layout_width="match_parent"
        android:layout_height="308dp" />

    <SurfaceView
        android:id="@+id/guiSurfaceRep"
        android:layout_width="match_parent"
        android:layout_height="186dp"
        android:layout_weight="0.38" />
    
    <View
        android:id="@+id/view1"
        android:layout_width="wrap_content"
        android:layout_height="42dp" />

    <TextView
        android:id="@+id/textView1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="0.06"
        android:text="TextView" />
        /**/
        
        //lolView = new Board_MySurfaceView2(this);
        
        setContentView(R.layout.activity_experiment);
        
        //lolView = (Board_MySurfaceView2) findViewById(R.id.xmlSurfaceRep);
        //lolView = (Board_MyView3) findViewById(R.id.guiSurfaceRep);
        
        
        
        lolContainer = (LinearLayout) findViewById(R.id.layoutContainer);
        //lolContainer.addView(new Board_MyView3(this));
        lolView = new Board_MyView3(this);
        lolContainer.addView(lolView);
        
        
        
        //setContentView(R.layout.activity_experiment);
        
        //LinearLayout lolContainer = (LinearLayout) findViewById(R.id.layoutContainer);
        //lolContainer.addView(new Board_MyView3(this));
        
    }
    
    
    
}

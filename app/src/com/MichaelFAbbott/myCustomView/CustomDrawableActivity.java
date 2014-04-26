package com.MichaelFAbbott.myCustomView;

import android.app.Activity;
import android.os.Bundle;

public class CustomDrawableActivity extends Activity
{
    /** Called when the activity is first created. */
    //@Override
	//Strategy.java
    /*
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView( new DisplayManager( this ) );
    }
    */
    
    
    
    
    CustomDrawableView2 mCustomDrawableView;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	super.onCreate(savedInstanceState);
    	//CustomDravableView is the other class I created
    	mCustomDrawableView = new CustomDrawableView2(this);
    	
    	setContentView(mCustomDrawableView);
    }
    
    
}



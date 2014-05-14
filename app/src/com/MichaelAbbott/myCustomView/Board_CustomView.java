package com.MichaelFAbbott.myCustomView;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Vibrator;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class Board_CustomView extends View {
	
	
	
	private Board_Controller controller;
	
	private int rows, columns;
	
	private float touchRadius = 90;
	
	
	
	//private Board_CustomView.MyTouchGestureListener touch_listener;
	//private this.MyTouchGestureListener touch_listener;
	
	private GestureDetector gestures;
	
	
	
	
	
	//private Triangle debug;
	
	public Board_CustomView(Context context, Vibrator hap) {
		
		super(context);
		
		
		
		
		
		Board_Model mod = new Board_Model();
		
		
		
		
		Board_Controller cont = new Board_Controller(mod, this);
		this.registerObserver(cont);
		
		controller.setHaptic(hap);
		
		gestures = new GestureDetector( context, controller );
	}
	
	
	
	public void registerObserver(Board_Controller c) {

        
		this.controller = c;

    }
	
	
	//is the override necessary?
	@Override
	protected void onDraw(Canvas canvas) {
		
		this.controller.processDrawEvent(canvas);
	}
	
	
	
	
	@Override
	public boolean onTouchEvent( MotionEvent e )
	{
		//scale_gestures.onTouchEvent( e );
		//if( !scale_gestures.isInProgress() )
		
		gestures.onTouchEvent( e );
		
		//System.err.println("lol");
		
		invalidate();
		return true;
	}
	
	
	
}







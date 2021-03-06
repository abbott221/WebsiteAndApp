package com.MichaelAbbott.myViewAsSurface6;

import com.MichaelAbbott.myCustomView.Board_CustomView;
import com.MichaelAbbott.myCustomView.Board_Model;
import com.MichaelAbbott.myCustomView.Hexagon;
import com.MichaelAbbott.myCustomView.Hexagon.State;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.os.Vibrator;
import android.support.v4.view.ScaleGestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Board_ScaleListener6 extends ScaleGestureDetector.SimpleOnScaleGestureListener {
	
	
	private Board_Model6 model;
	private View_References6 mvcView;
	
	
	
	//private RectF mCurrentViewport = new RectF(AXIS_X_MIN, AXIS_Y_MIN, AXIS_X_MAX, AXIS_Y_MAX);
	//private Rect mContentRect;
	
	//private PointF viewportFocus = new PointF();
	
	//private float startSpanX;
	//private float startSpanY;
	private float startSpan;
	private float currentSpan;
	
	//private boolean changeProcessed = false;
	
	//private float currentSpanX;
	//private float currentSpanY;
	

	public Board_ScaleListener6(Board_Model6 m, View_References6 v) {
		
		this.model = m;
		this.mvcView = v;
	}
	
	
	
	public Board_Model6 getModel()
	{
		return this.model;
	}
	
	
	
	
	
	
	@Override
	public boolean onScale(ScaleGestureDetector sgd) {
		
		
		//System.err.println("I heard you! onScale");
		
		
		
		float tempScale = this.model.getUnclearedScale();
		
		
		
		currentSpan = sgd.getCurrentSpan();
		
		tempScale *= (currentSpan / startSpan);
		//tempScale = (currentSpan / startSpan);
        tempScale = Math.max( 0.1f, Math.min( tempScale, 5.0f ) );
        
        
        this.model.setScale(tempScale);
		
		
		return true;
	}



	@Override
	public boolean onScaleBegin(ScaleGestureDetector sgd) {
		//Hexagon5 temp = this.model.getClosestTile(eX, eY);
		
		this.model.getMyView5().setScaleInProgress(true);
		
		this.model.setScaleInProgress(true);
		
		//System.err.println("I heard you! onScaleBegin");
		
		
		
		
		//startSpanX = sgd.getCurrentSpanX();
		//startSpanY = sgd.getCurrentSpanY();
		startSpan = sgd.getCurrentSpan();
		
		
		
		
		return true;
	}



	@Override
	public void onScaleEnd(ScaleGestureDetector sgd) {
		
		//System.err.println("I heard you! onScaleEnd");
		
		this.model.setScaleInProgress(false);
		
		
		
		

		float tempScale = this.model.getUnclearedScale();
		
		currentSpan = sgd.getCurrentSpan();
		
		tempScale *= (currentSpan / startSpan);
		//tempScale = (currentSpan / startSpan);
        tempScale = Math.max( 0.1f, Math.min( tempScale, 5.0f ) );
        
        //this.model.setScale(tempScale);
        this.model.setUnclearedScale(tempScale);
	}
	
	
	
}







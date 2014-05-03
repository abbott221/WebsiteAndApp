package com.MichaelFAbbott.myViewAsSurface5;

import com.MichaelFAbbott.customView.GameMap;
import com.MichaelFAbbott.customView.Tile;
import com.MichaelFAbbott.myCustomView.Hexagon.State;

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

public class Board_Listener5 extends GestureDetector.SimpleOnGestureListener {
	
	
	
	
	
	@Override
	public boolean onSingleTapConfirmed( MotionEvent e )
	{
		float eX = e.getX();
		float eY = e.getY();
		
		System.err.println("I heard you!");
		
		return true;
	}
	
	
	
	
	
	
}







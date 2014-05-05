package com.MichaelFAbbott.myViewAsSurface5;

import com.MichaelFAbbott.customView.GameMap;
import com.MichaelFAbbott.customView.Tile;
import com.MichaelFAbbott.myCustomView.Board_CustomView;
import com.MichaelFAbbott.myCustomView.Board_Model;
import com.MichaelFAbbott.myCustomView.Hexagon;
import com.MichaelFAbbott.myCustomView.Hexagon.State;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Vibrator;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

public class Board_Listener5 implements GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener {
	
	
	private Board_Model5 model;
	private View_References mvcView;
	

	public Board_Listener5(Board_Model5 m, View_References v) {
		
		this.model = m;
		this.mvcView = v;
	}
	
	
	
	public Board_Model5 getModel()
	{
		return this.model;
	}
	
	
	
	public void processSelectionEvent(Hexagon5 temp)
    {
    	
    	for (int i = 0; i < this.model.getRows(); i++) {
			for (int j = 0; j < this.model.getColumns(); j++) {
				Hexagon5 current = this.model.getHexagon(i, j);
				
				current.setHighlighted(Hexagon5.SelectState.UNSELECTED);
				
			}
		}
    	
    	temp.setHighlighted(Hexagon5.SelectState.SELECTED);
    	
    	this.model.setSelected(temp);
    	
    	
    	
    	
    	Hexagon5.HeldState hold = temp.getHeldState();
    	switch ( hold ) {
		case HOLD_BLUE:
			this.mvcView.updateSpinner(0);
			break;
		case HOLD_PURPLE:
			this.mvcView.updateSpinner(1);
			break;
		case HOLD_GREEN:
			this.mvcView.updateSpinner(2);
			break;
		case HOLD_YELLOW:
			this.mvcView.updateSpinner(3);
			break;
		case HOLD_RED:
			this.mvcView.updateSpinner(4);
			break;
		default:
			//nothing
		}
    }
	
	
	
	
	
	
	
	
	

	@Override
	public boolean onDown(MotionEvent e) {
		float eX = e.getX();
		float eY = e.getY();
		
		//System.err.println("I heard you!");
		Hexagon5 temp = this.model.getClosestTile(eX, eY);
		
		if (temp != null)
		{
			
			processSelectionEvent(temp);
			//temp.setHighlighted(Hexagon.State.SELECTED);
			//highlighted = temp;
		}
		
		return true;
	}



	@Override
	public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		/*
		float eX = e.getX();
		float eY = e.getY();
		
		//System.err.println("I heard you!");
		Hexagon5 temp = this.model.getClosestTile(eX, eY);
		
		if (temp != null)
		{
			
			processSelectionEvent(temp);
			//temp.setHighlighted(Hexagon.State.SELECTED);
			//highlighted = temp;
		}
		
		return true;
		/**/
		
		
		return false;
	}



	@Override
	public boolean onScale(ScaleGestureDetector arg0) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean onScaleBegin(ScaleGestureDetector arg0) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public void onScaleEnd(ScaleGestureDetector arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}







package com.MichaelFAbbott.myViewAsSurface5;

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

public class Board_Listener5 implements GestureDetector.OnGestureListener /*, ScaleGestureDetector.OnScaleGestureListener*/ {
	
	
	private Board_Model5 model;
	private View_References mvcView;
	
	
	
	private float startScrollX;
	private float startScrollY;
	private float currentScrollX;
	private float currentScrollY;
	

	public Board_Listener5(Board_Model5 m, View_References v) {
		
		this.model = m;
		this.mvcView = v;
	}
	
	
	
	public Board_Model5 getModel()
	{
		return this.model;
	}
	
	public View_References getView()
	{
		return this.mvcView;
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
    	case NONE:
			this.mvcView.updateSpinner(0);
			break;
    	case HOLD_BLUE:
			this.mvcView.updateSpinner(1);
			break;
		case HOLD_PURPLE:
			this.mvcView.updateSpinner(2);
			break;
		case HOLD_GREEN:
			this.mvcView.updateSpinner(3);
			break;
		case HOLD_ORANGE:
			this.mvcView.updateSpinner(4);
			break;
		case HOLD_RED:
			this.mvcView.updateSpinner(5);
			break;
		default:
			//nothing
		}
    	
    	
    	Hexagon5.OccupantState occupy = temp.getOccupantState();
    	switch ( occupy ) {
		case NONE:
			this.mvcView.updateOccSpinner(0);
			break;
		case OCC_BEIGE:
			this.mvcView.updateOccSpinner(1);
			break;
		case OCC_BLUE:
			this.mvcView.updateOccSpinner(2);
			break;
		case OCC_GREEN:
			this.mvcView.updateOccSpinner(3);
			break;
		case OCC_PINK:
			this.mvcView.updateOccSpinner(4);
			break;
		case OCC_YELLOW:
			this.mvcView.updateOccSpinner(5);
			break;
		default:
			//nothing
		}
    }
	
	
	
	
	
	
	
	
	

	@Override
	public boolean onDown(MotionEvent e) {
		
		/*
		//System.err.println("I heard you! onDown");
		
		//if (!this.model.getScaleInProgress())
		//{
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
		//}
		/**/
		
		startScrollX = e.getX();
		startScrollY = e.getY();
		
		
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
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
		
		
		//System.err.println("I heard you! onScroll");
		
		this.model.getMyView5().setScrollInProgress(true);
		
		
		
		float tempDX = this.model.getUnclearedDX();
		float tempDY = this.model.getUnclearedDY();
		
		
		currentScrollX = e2.getX();
		currentScrollY = e2.getY();
		
		
		tempDX += currentScrollX - startScrollX;
		tempDY += currentScrollY - startScrollY;
		
		//RETURN IF FAIL
		//tempDX = currentScrollX - startScrollX;
		//tempDY = currentScrollY - startScrollY;
		
		
		//tempDX = Math.max( 0.0f, tempDX );
		//tempDX = Math.max( 0.0f, Math.min( tempDX, 200.0f ) );
		//tempDY = Math.max( 0.0f, Math.min( tempDY, 200.0f ) );
		
		
		//TEMP
        this.model.setDisplacementX(tempDX);
        this.model.setDisplacementY(tempDY);
        
        
        
        //this.model.updateDisplacementX(tempDX);
        //this.model.updateDisplacementY(tempDY);
		
		
		return true;
	}
	
	public void onScrollEnd() {
		//System.err.println("I heard you! onScrollEnd");
		

		//this.model.getMyView5().setScrollInProgress(true);
		
		
		
		float tempDX = this.model.getUnclearedDX();
		float tempDY = this.model.getUnclearedDY();
		
		
		//currentScrollX = e2.getX();
		//currentScrollY = e2.getY();
		
		
		tempDX += currentScrollX - startScrollX;
		tempDY += currentScrollY - startScrollY;
		
		//RETURN IF FAIL
		//tempDX = currentScrollX - startScrollX;
		//tempDY = currentScrollY - startScrollY;
		
		
		//tempDX = Math.max( 0.0f, tempDX );
		//tempDX = Math.max( 0.0f, Math.min( tempDX, 200.0f ) );
		//tempDY = Math.max( 0.0f, Math.min( tempDY, 200.0f ) );
		
		
		//TEMP
		//this.model.setDisplacementX(tempDX);
        //this.model.setDisplacementY(tempDY);
        this.model.setUnclearedDX(tempDX);
        this.model.setUnclearedDY(tempDY);
        
        
        
        //this.model.updateDisplacementX(tempDX);
        //this.model.updateDisplacementY(tempDY);
		
		
		//return true;
	}
	
	
	
	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		
		//System.err.println("I heard you! onDown");
		
		
		float eX = e.getX();
		float eY = e.getY();
		
		Hexagon5 temp = this.model.getClosestTile(eX, eY);
		
		if (temp != null)
		{
			processSelectionEvent(temp);
			//temp.setHighlighted(Hexagon.State.SELECTED);
			//highlighted = temp;
		}
		
		
		return true;
	}
	
	
	
	
	
}






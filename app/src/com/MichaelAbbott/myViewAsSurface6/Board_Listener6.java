package com.MichaelAbbott.myViewAsSurface6;

import java.util.ArrayList;

import com.MichaelAbbott.myViewAsSurface6.Hexagon6.BlockState;
import com.MichaelAbbott.myViewAsSurface6.Hexagon6.HeldState;

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

public class Board_Listener6 implements GestureDetector.OnGestureListener /*, ScaleGestureDetector.OnScaleGestureListener*/ {
	
	
	private Board_Model6 model;
	private View_References6 mvcView;
	
	
	
	private float startScrollX;
	private float startScrollY;
	private float currentScrollX;
	private float currentScrollY;
	

	public Board_Listener6(Board_Model6 m, View_References6 v) {
		
		this.model = m;
		this.mvcView = v;
	}
	
	
	
	public Board_Model6 getModel()
	{
		return this.model;
	}
	
	public View_References6 getView()
	{
		return this.mvcView;
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
		
		
		
		Hexagon6 previousSelection = null;
		try {
			previousSelection = this.model.getSelected();
		} catch (Exception e1) {
			//error caused by nothing being selected
			previousSelection = null;
		}
		
		
		
		Hexagon6 temp = this.model.getClosestTile(eX, eY);
		
		Hexagon6 active = null;
		try {
			active = this.model.getActiveTile();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		
		//Actor occupant = model.getOccupant( temp.getRow(), temp.getColumn() );
		
		
		
		//if the user hit a legitimate tile
		if (temp != null)
		{
			
			
			
			Actor occupant = model.getOccupant( temp.getRow(), temp.getColumn() );
			
			
			
			if ( this.model.getDeveloperMode() ) {
				processDevSelectionEvent(temp);
			} else {
				
				//removed for the following if-else involving selecting "active" tile
				//processPlayerSelectionEvent(temp);
				
				
				//if user "selected" the active tile, then unselection event
				/**/
				if (temp == active) {
					processPlayerUnselectionEvent();
				}
				//otherwise, legitimate selection event
				else {
					
					//user can only select their own players
					//if ( occupant.getPlayer() == model.getCurrentPlayer() )
					processPlayerSelectionEvent(temp);
					
					
				}
				/**/
				
				
			}
			
			//temp.setHighlighted(Hexagon5.SelectState.SELECTED);
			//this.model.setSelected(temp);
			
			
			//check if it's the same tile as before
			// -> unselection
			if (temp == previousSelection)
			{
				//assert temp != null : "Michael; Violation of: Hexagon is not null";
				
				if ( this.model.getDeveloperMode() ) {
					processDevUnselectionEvent();
				} else {
					
					//only unselect if not attack event (red tile)
					if ( temp.getHeldState() != HeldState.HOLD_RED ) {
						processPlayerUnselectionEvent();
					}
					
				}
			}
			//if block is empty and player mode
			//players can't select empty blocks
			if (temp.getBlockState() == BlockState.NONE && !this.model.getDeveloperMode() )
			{
				if ( this.model.getDeveloperMode() ) {
					processDevUnselectionEvent();
				} else {
					processPlayerUnselectionEvent();
				}
			}
			
		}
		
		
		
		//if the user did not hit a tile (hit somewhere off the grid)
		// -> unselection
		if (temp == null)
		{
			if ( this.model.getDeveloperMode() ) {
				processDevUnselectionEvent();
			} else {
				processPlayerUnselectionEvent();
			}
		}
		
		
		
		return true;
	}
	
	
	
	
	
	
	
	public void processDevSelectionEvent(Hexagon6 temp)
    {
    	
    	for (int i = 0; i < this.model.getRows(); i++) {
			for (int j = 0; j < this.model.getColumns(); j++) {
				Hexagon6 current = this.model.getHexagon(i, j);
				
				current.setHighlighted(Hexagon6.SelectState.UNSELECTED);
				
			}
		}
    	
    	temp.setHighlighted(Hexagon6.SelectState.SELECTED);
    	
    	this.model.setSelected(temp);
    	
    	
    	
    	
    	Hexagon6.HeldState hold = temp.getHeldState();
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
    	
    	
    	Hexagon6.OccupantState occupy = temp.getOccupantState();
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
		case P_BLUE:
			this.mvcView.updateOccSpinner(6);
			break;
		case P_GREEN:
			this.mvcView.updateOccSpinner(7);
			break;
		case P_RED:
			this.mvcView.updateOccSpinner(8);
			break;
		case P_WHITE:
			this.mvcView.updateOccSpinner(9);
			break;
		case P_YELLOW:
			this.mvcView.updateOccSpinner(10);
			break;
		default:
			//nothing
		}
    }
	
	
	
	
	public void processDevUnselectionEvent()
    {
    	
    	for (int i = 0; i < this.model.getRows(); i++) {
			for (int j = 0; j < this.model.getColumns(); j++) {
				Hexagon6 current = this.model.getHexagon(i, j);
				
				current.setHighlighted(Hexagon6.SelectState.UNSELECTED);
				
			}
		}
    	
    	//temp.setHighlighted(Hexagon5.SelectState.SELECTED);
    	
    	this.model.setSelected(null);
    	
    	
    	
    	this.mvcView.updateSpinner(0);
    	
    	this.mvcView.updateOccSpinner(0);
    }
	
	
	
	
	
	
	
	
	
	public void processPlayerSelectionEvent(Hexagon6 temp)
    {
    	/*
    	for (int i = 0; i < this.model.getRows(); i++) {
			for (int j = 0; j < this.model.getColumns(); j++) {
				Hexagon5 current = this.model.getHexagon(i, j);
				
				//current.setHighlighted(Hexagon5.SelectState.UNSELECTED);
				current.setHeldState(HeldState.NONE);
			}
		}
    	/**/
    	this.model.setSelected(temp);
    	
    	//****************************************************************
    	
    	//organize by occupant or HeldState first?
    	
    	
    	AI_PlayerInteraction6.playerSelectionEntry(temp, this.model);
    	
    	
    }
	
	
	
	
	
	public void processPlayerUnselectionEvent()
    {
    	
    	for (int i = 0; i < this.model.getRows(); i++) {
			for (int j = 0; j < this.model.getColumns(); j++) {
				Hexagon6 current = this.model.getHexagon(i, j);
				
				//current.setHighlighted(Hexagon5.SelectState.UNSELECTED);
				current.setHeldState(HeldState.NONE);
			}
		}
    	
    	this.model.setSelected(null);
    	
    	this.model.setActiveTile(null);
    	
    	
    	this.mvcView.updateBothVisibility(0);
    	
    	//****************************************************************
    	
    	//wait was that all this will ever need?
    	
    }
	
	
	
}







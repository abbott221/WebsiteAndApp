package com.MichaelFAbbott.myCustomView;

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

public class Board_Controller extends GestureDetector.SimpleOnGestureListener {
	
	
	private Board_Model model;
	
	private Board_CustomView view;
	
	
	public Board_Controller(Board_Model m, Board_CustomView v) {
		
		this.model = m;
		
		this.view = v;
	}
	
	
	
	@Override
	public boolean onSingleTapConfirmed( MotionEvent e )
	{
		float eX = e.getX();
		float eY = e.getY();
		
		
		
		
		Hexagon temp = this.model.getClosestTile(eX, eY);
		
		if (temp != null)
		{
			//vibrate here
			if (this.model.getHapticOn())
			{
				this.model.getHaptic().vibrate(50);
			}
			
			
			processSelectionEvent(temp);
			//temp.setHighlighted(Hexagon.State.SELECTED);
			//highlighted = temp;
		}
		
		
		this.view.invalidate();
		return true;
	}
	
	public void setHaptic(Vibrator vib)
	{
		this.model.setHaptic(vib);
	}
	public Vibrator getHaptic()
	{
		return this.model.getHaptic();
	}
	
	public boolean getHapticOn() {
    	return this.model.getHapticOn();
    }
    public void setHapticOn(boolean newValue) {
    	this.model.setHapticOn(newValue);
    }
	
    
    public void processSelectionEvent(Hexagon temp)
    {
    	
    	for (int i = 0; i < this.model.getRows(); i++) {
			for (int j = 0; j < this.model.getColumns(); j++) {
				Hexagon current = this.model.getHexagon(i, j);
				
				current.setHighlighted(State.UNSELECTED);
				
			}
		}
    	
    	temp.setHighlighted(Hexagon.State.SELECTED);
    }
    
    
    public void processDrawEvent(Canvas canvas)
    {
    	
    	for (int i = 0; i < this.model.getRows(); i++) {
			for (int j = 0; j < this.model.getColumns(); j++) {
				Hexagon current = this.model.getHexagon(i, j);
				
				current.drawSelf(canvas);
				
			}
		}
    	
    	
    	
    	
    }
    
    
    
    
}







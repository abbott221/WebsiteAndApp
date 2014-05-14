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

public class Board_Model {
	
	
	private Vibrator haptic;
	private boolean hapticOn;
	
	private Hexagon[][] board;
	private int rows, columns;
	
	private float touchRadius;
	
	
	
	public Board_Model() {
		this.hapticOn = true;
		
		this.rows = 7;
		this.columns = 4;
		
		this.touchRadius = 90;
		
		
		
		

		this.board = new Hexagon[ this.rows ][ this.columns ];
		
		for (int i = 0; i < this.rows; i++)
		{
			for (int j = 0; j < this.columns; j++)
			{
				this.board[i][j] = new Hexagon(i, j);
			}
		}
		
		
		
		
	}
	
	public void setHaptic(Vibrator v)
	{
		haptic = v;
	}
	public Vibrator getHaptic()
	{
		return this.haptic;
	}
	
	
	public boolean getHapticOn() {
    	return this.hapticOn;
    }
    public void setHapticOn(boolean newValue) {
    	this.hapticOn = newValue;
    }
    
    
    
    public int getRows()
	{
		return this.rows;
	}
    public int getColumns()
	{
		return this.columns;
	}
    
    
    public Hexagon getHexagon(int r, int c)
	{
		return this.board[r][c];
	}
    
    
    
    
    
    
    
    /**
	 * THIS COULD RETURN NULL!!!
	 * if the user didn't tap within the range of a hexagon
	 * (or possibly tapped waaaayyy away from the hexagons), then
	 * nothing will be set to selected
	 */
	public Hexagon getClosestTile(float x, float y)
	{
		float tempX = 0;
		float tempY = 0;
		
		float diffX = 0;
		float diffY = 0;
		
		Hexagon selected = null;
		
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				tempX = board[i][j].getCenterX();
				tempY = board[i][j].getCenterY();
				
				
				diffX = tempX - x;
				diffY = tempY - y;
				
				if ( (diffX*diffX) + (diffY*diffY) < (touchRadius*touchRadius) )
				{
					selected = board[i][j];
				}
				
				
			}
		}
		
		//THIS COULD RETURN NULL!!!
		return selected;
	}
    
	
}







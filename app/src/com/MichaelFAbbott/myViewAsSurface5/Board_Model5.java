package com.MichaelFAbbott.myViewAsSurface5;

import com.MichaelFAbbott.customView.GameMap;
import com.MichaelFAbbott.customView.Tile;

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

public class Board_Model5 {
	
	
	private Hexagon5[][] board;
	private int rows, columns;
	
	private float touchRadius;
	
	Hexagon5 lolSelected;
	
	
	
	public Board_Model5() {
		this.rows = 7;
		this.columns = 4;
		
		this.touchRadius = 90;
		
		
		
		

		this.board = new Hexagon5[ this.rows ][ this.columns ];
		
		for (int i = 0; i < this.rows; i++)
		{
			for (int j = 0; j < this.columns; j++)
			{
				this.board[i][j] = new Hexagon5(i, j);
			}
		}
		
		
		this.lolSelected = null;
		
	}
	
    
    
    
    public int getRows()
	{
		return this.rows;
	}
    public int getColumns()
	{
		return this.columns;
	}
    
    
    public void setRadius(int newValue)
	{
		this.touchRadius = newValue;
	}
    
    
    public Hexagon5 getHexagon(int r, int c)
	{
		return this.board[r][c];
	}
    
    
    public Hexagon5 getSelected() throws Exception
	{
		Hexagon5 result = this.lolSelected;
		if (result == null)
		{
			//
			throw new NullPointerException();
		}
    	
    	return this.lolSelected;
	}
    public void setSelected(Hexagon5 newSelect)
	{
		this.lolSelected = newSelect;
	}
    
    
    
    
    /**
	 * THIS COULD RETURN NULL!!!
	 * if the user didn't tap within the range of a hexagon
	 * (or possibly tapped waaaayyy away from the hexagons), then
	 * nothing will be set to selected
	 */
	public Hexagon5 getClosestTile(float x, float y)
	{
		float tempX = 0;
		float tempY = 0;
		
		float diffX = 0;
		float diffY = 0;
		
		Hexagon5 selected = null;
		
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







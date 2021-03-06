package com.MichaelAbbott.myViewAsSurface5;


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
	
	Hexagon5 previousSelected;
	
	//Context lolContext;
	
	private Board_Listener5 controller;
	
	private Board_MyView5 myView5;
	
	
	
	private boolean scaleInProgress;
	private float scaleSize;
	
	private float unclearedScaleSize;
	
	
	private float displacementX;
	private float displacementY;
	
	private float unclearedDX;
	private float unclearedDY;
	
	//private float startSpanX;
	//private float startSpanY;
	
	
	private float canvasHalfHeight;
	private float canvasHalfWidth;
	
	
	private boolean developerMode;
	
	
	
	public Board_Model5() {
		
		this.touchRadius = 90;
		
		
		Board_Maps5.map2(this);
		//Board_Maps5.map1(this);
		
		
		
		
		
		
		
		
		
		this.lolSelected = null;
		this.previousSelected = null;
		
		
		
		this.scaleInProgress = false;
		this.scaleSize = 1;
		
		this.unclearedScaleSize = 1;
		
		
		
		this.displacementX = 0;
		this.displacementY = 0;
		this.unclearedDX = 0;
		this.unclearedDY = 0;
		
		
		this.developerMode = true;
		//should I initialize it???
		//this.canvasHalfHeight = 100.0f;
		
	}
	
	public void registerObserver(Board_Listener5 newController)
	{
		controller = newController;
	}
	
	public void registerMyView5(Board_MyView5 newView)
	{
		myView5 = newView;
	}
	public Board_MyView5 getMyView5()
	{
		return this.myView5;
	}
    
    
	
	
	public void setBoard(Hexagon5[][] newBoard, int r, int c)
	{
		this.board = newBoard;
		
		this.rows = r;
		this.columns = c;
		
		
	}
	
	
	
	
    public int getRows()
	{
		return this.rows;
	}
    public int getColumns()
	{
		return this.columns;
	}
    
    public void setRows(int newValue)
	{
		this.rows = newValue;
	}
    public void setColumns(int newValue)
	{
		this.columns = newValue;
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
			throw new NullPointerException();
		}
    	
    	return this.lolSelected;
	}
    public void setSelected(Hexagon5 newSelect)
	{
		
    	if (newSelect != this.lolSelected)
    	{
    		this.previousSelected = this.lolSelected;
    	}
    	//this.previousSelected = this.lolSelected;
		
		
    	this.lolSelected = newSelect;
	}
    public Hexagon5 getPreviousSelected() throws Exception
	{
		Hexagon5 result = this.previousSelected;
		if (result == null)
		{
			throw new NullPointerException();
		}
    	
    	return this.previousSelected;
	}
    
    
    
    /**
	 * THIS COULD RETURN NULL!!!
	 * if the user didn't tap within the range of a hexagon
	 * (or possibly tapped waaaayyy away from the hexagons), then
	 * nothing will be set to selected
	 * 
	 * called by onSingleTapUp() in Board_Listener5
	 */
	public Hexagon5 getClosestTile(float x, float y)
	{
		float tempX = 0;
		float tempY = 0;
		
		float diffX = 0;
		float diffY = 0;
		
		float inputX = x;
		float inputY = y;
		
		Hexagon5 selected = null;
		
		
		
		//System.err.println("input X: " + inputX);
		//System.err.println("input Y: " + inputY);
		//System.err.println("Canvas 0,0 X: " + board[0][0].getCanvasX() );
		//System.err.println("Canvas 0,0 Y: " + board[0][0].getCanvasY() );
		
		
		
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				/**/
				//tempX = board[i][j].getCenterX();
				//tempY = board[i][j].getCenterY();
				
				float tempRadius = touchRadius;
				tempRadius *= scaleSize;
				
				
				
				
				tempX = board[i][j].getCanvasX();
				tempY = board[i][j].getCanvasY();
				
				
				diffX = tempX - inputX;
				diffY = tempY - inputY;
				
				if ( (diffX*diffX) + (diffY*diffY) < (tempRadius*tempRadius) )
				{
					selected = board[i][j];
				}
				
				
			}
		}
		
		//THIS COULD RETURN NULL!!!
		return selected;
	}
	
	
	
	
	
	public float getScale()
	{
		return this.scaleSize;
	}
    public void setScale(float newValue)
	{
		this.scaleSize = newValue;
	}
    
    public float getUnclearedScale()
	{
		return this.unclearedScaleSize;
	}
    public void setUnclearedScale(float newValue)
	{
		this.unclearedScaleSize = newValue;
	}
    
    
    
    
    
    public float getDisplacementX()
	{
		return this.displacementX;
	}
    public void setDisplacementX(float newValue)
	{
		this.displacementX = newValue;
	}
    
    public float getDisplacementY()
	{
		return this.displacementY;
	}
    public void setDisplacementY(float newValue)
	{
		this.displacementY = newValue;
	}
    
    
    public float getUnclearedDX()
	{
		return this.unclearedDX;
	}
    public void setUnclearedDX(float newValue)
	{
		this.unclearedDX = newValue;
	}
    
    public float getUnclearedDY()
	{
		return this.unclearedDY;
	}
    public void setUnclearedDY(float newValue)
	{
		this.unclearedDY = newValue;
	}
    
    /*
    public void updateDisplacementX(float newValue)
	{
		this.displacementX += newValue;
	}
    public void updateDisplacementY(float newValue)
	{
		this.displacementY += newValue;
	}
    /**/
    
    
    
    public boolean getScaleInProgress()
	{
		return this.scaleInProgress;
	}
    public void setScaleInProgress(boolean newValue)
	{
		this.scaleInProgress = newValue;
	}
	/**/
    
    
    
    public float getCanvasHalfHeight()
	{
		return this.canvasHalfHeight;
	}
    public void setCanvasHalfHeight(float newValue)
	{
		this.canvasHalfHeight = newValue;
	}
    
    
    public float getCanvasHalfWidth()
	{
		return this.canvasHalfWidth;
	}
    public void setCanvasHalfWidth(float newValue)
	{
		this.canvasHalfWidth = newValue;
	}
	
    
    
    public boolean getDeveloperMode()
	{
		return this.developerMode;
	}
    public void setDeveloperMode(boolean newValue)
	{
		this.developerMode = newValue;
	}
    
    
}







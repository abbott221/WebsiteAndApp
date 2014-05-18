package com.MichaelAbbott.myViewAsSurface6;


import java.util.ArrayList;

import com.MichaelAbbott.myViewAsSurface6.Hexagon6.OccupantState;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class Board_Model6 {
	
	
	private Hexagon6[][] board;
	private Actor[][] occupantArray;
	private ArrayList<Player> players;
	
	private Player currentPlayer;
	
	private int rows, columns;
	
	private float touchRadius;
	
	
	
	
	Hexagon6 lolSelected;
	
	Hexagon6 previousSelected;
	
	Hexagon6 activeTile;
	
	
	
	
	//Context lolContext;
	
	private Board_Listener6 controller;
	
	private Board_MyView6 myView5;
	
	private View_References6 myViewReferences;
	
	
	
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
	
	
	private float xDensity;
	private float yDensity;
	
	
	private boolean developerMode;
	
	
	Context myContext;
	
	
	public Board_Model6(Context context) {
		
		this.myContext = context;
		
		
		
		
		this.touchRadius = 90;
		
		
		
		this.currentPlayer = null;
		
		
		Board_Maps6.map2(this);
		//Board_Maps5.map1(this);
		
		
		
		/*
		int r = this.getRows();
		int c = this.getColumns();
		
		occupantArray = new Actor[r][c];
		
		occupantArray[6][4] = new Actor_BeigeAlien(context);
		/**/
		
		//Set to 0 in the ArrayList returned from map2???
		//this.currentPlayer = null;
		
		
		
		
		
		this.lolSelected = null;
		this.previousSelected = null;
		this.activeTile = null;
		
		
		
		
		
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
		
		
		this.xDensity = 100;
		this.yDensity = 100;
		
	}
	
	public void registerObserver(Board_Listener6 newController)
	{
		this.controller = newController;
		
		this.registerView_References(newController.getView());
	}
	public Board_Listener6 getBoard_Listener6()
	{
		return this.controller;
	}
	
	
	public void registerMyView5(Board_MyView6 newView)
	{
		this.myView5 = newView;
	}
	public Board_MyView6 getMyView5()
	{
		return this.myView5;
	}
    
	
	public void registerView_References(View_References6 newReferences)
	{
		this.myViewReferences = newReferences;
	}
	public View_References6 getView_References()
	{
		return this.myViewReferences;
	}
	
	
	
	
	
    
	
	
	public void setBoard(Hexagon6[][] newBoard, int r, int c)
	{
		this.board = newBoard;
		
		this.rows = r;
		this.columns = c;
		
		
	}
	
	public void setOccupantArray(Actor[][] newBoard)
	{
		this.occupantArray = newBoard;
		
		//this.rows = r;
		//this.columns = c;
	}
	
	public void setPlayers(ArrayList<Player> newList)
	{
		this.players = newList;
		
		//this.rows = r;
		//this.columns = c;
	}
	
	public void setPlayers(int listSize)
	{
		ArrayList<Player> newList = new ArrayList<Player>();
		
		
		Player temp;
		
		for (int i = 0; i < listSize; i++) {
			temp = new Player();
			newList.add(temp);
		}
		
		
		this.players = newList;
		
		//this.rows = r;
		//this.columns = c;
	}
	
	
	public Context getContext()
	{
		return this.myContext;
	}
	//won't be used
    public void setContext(Context newValue)
	{
		this.myContext = newValue;
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
    
    
    public Hexagon6 getHexagon(int r, int c)
	{
		return this.board[r][c];
	}
    
    
    public Actor getOccupant(int r, int c)
	{
		return this.occupantArray[r][c];
	}
    public void setOccupant(int r, int c, Actor newActor)
	{
		this.occupantArray[r][c] = newActor;
	}
    //using the returned actor is optional
    public Actor removeOccupant(int r, int c)
	{
		Actor removed = this.occupantArray[r][c];
		this.occupantArray[r][c] = null;
    	return removed;
	}
    
    
    public Player getCurrentPlayer()
	{
		return this.currentPlayer;
	}
    public void setCurrentPlayer(Player newPlayer)
	{
		this.currentPlayer = newPlayer;
	}
    public void setCurrentPlayer(int newPlayer)
	{
		this.currentPlayer = this.players.get(newPlayer);
	}
    public void endTurn()
    {
    	//recharge energy of all occupants
    	//not working yet
    	/**/
    	ArrayList<Actor> occs = this.currentPlayer.getOccupants();
    	Actor current;
    	for (int i = 0; i < occs.size(); i++) {
    		current = occs.get(i);
    		current.setCurrentEnergy( current.getMaxEnergy() );
    		//this.currentPlayer
    		current.setCanAttack(true);
    	}
    	this.currentPlayer.setOccupants(occs);
    	/**/
    	//System.err.println( this.currentPlayer.getOccupants().size() );
    	
    	
    	//find position of current player
    	//if not max, get next
    	//if max, reset to 0
    	int currentIndex = this.players.indexOf(this.currentPlayer);
    	int maxIndex = this.players.size() - 1;
    	
    	int newIndex = 0;
    	
    	/*
    	if (currentIndex == maxIndex) {
    		newIndex = 0;
    	} else {
    		newIndex = currentIndex + 1;
    	}
    	/**/
    	if (currentIndex != maxIndex) {
    		newIndex = currentIndex + 1;
    	}
    	
    	this.currentPlayer = this.players.get(newIndex);
    }
    
    
    
    
    
    public Hexagon6 getSelected() throws Exception
	{
		Hexagon6 result = this.lolSelected;
		if (result == null)
		{
			throw new NullPointerException();
		}
    	
    	return this.lolSelected;
	}
    public void setSelected(Hexagon6 newSelect)
	{
		
    	if (newSelect != this.lolSelected)
    	{
    		this.previousSelected = this.lolSelected;
    	}
    	//this.previousSelected = this.lolSelected;
		
		
    	this.lolSelected = newSelect;
	}
    public Hexagon6 getPreviousSelected() throws Exception
	{
		Hexagon6 result = this.previousSelected;
		if (result == null)
		{
			throw new NullPointerException();
		}
    	
    	return this.previousSelected;
	}
    
    public Hexagon6 getActiveTile() throws Exception
	{
		Hexagon6 result = this.activeTile;
		if (result == null)
		{
			throw new NullPointerException();
		}
    	
    	return this.activeTile;
	}
    public void setActiveTile(Hexagon6 newSelect)
	{
		this.activeTile = newSelect;
	}
    
    
    
    /**
	 * THIS COULD RETURN NULL!!!
	 * if the user didn't tap within the range of a hexagon
	 * (or possibly tapped waaaayyy away from the hexagons), then
	 * nothing will be set to selected
	 * 
	 * called by onSingleTapUp() in Board_Listener5
	 */
	public Hexagon6 getClosestTile(float x, float y)
	{
		float tempX = 0;
		float tempY = 0;
		
		float diffX = 0;
		float diffY = 0;
		
		float inputX = x;
		float inputY = y;
		
		Hexagon6 selected = null;
		
		
		
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
    
    
    
    public float getDensityX()
	{
		return this.xDensity;
	}
    public void setDensityX(float newValue)
	{
		this.xDensity = newValue;
	}
    
    public float getDensityY()
	{
		return this.yDensity;
	}
    public void setDensityY(float newValue)
	{
		this.yDensity = newValue;
	}
    
    
    
    
    
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







package com.MichaelFAbbott.myViewAsSurface5;

import com.MichaelFAbbott.standards.AttemptController;

import android.graphics.*;
import android.util.Log;

public class Hexagon5
{
	//public static int hSize = 20;
	
	private Paint paintFill;
	private static Path shapePath;
	
	
	private int row, column;
	
	private float centerX, centerY;
	
	private float canvasX;
	private float canvasY;
	
	int myColor;
	
	
	
	
	public static enum SelectState {
		SELECTED, UNSELECTED
	}
	public static enum HeldState {
		NONE, HOLD_BLUE, HOLD_PURPLE, HOLD_GREEN, HOLD_ORANGE, HOLD_RED
	}
	public static enum OccupantState {
		NONE, OCC_BEIGE, OCC_BLUE, OCC_GREEN, OCC_PINK, OCC_YELLOW
	}
	private SelectState currentState; //selectState
	private HeldState myHeldState;
	private OccupantState myOccupantState;
	
	
	
	
	// constructor using row and col index
	public Hexagon5( int r, int c )
	{
		this.currentState = SelectState.UNSELECTED;
		this.myHeldState = HeldState.HOLD_RED;
		this.myOccupantState = OccupantState.NONE;
		
		
		row = r;
		column = c;
		
		
		myColor = android.graphics.Color.RED;
		
		
		
		
		
		//HEXAGON START
		
		paintFill = new Paint();
		paintFill.setColor(0xff74AC23);
		paintFill.setStyle( Paint.Style.FILL );
		
		
		
		shapePath = new Path();
		
		
		
		//float centerX = 200;
		//float centerY = 200;
		
		//centerX = c * 200 + 150;
		centerX = c * 192 + 150;
		if (r % 2 != 0)
		{
			//centerX += 100;
			centerX += 96;
		}
		
		//centerY = r * 200 + 150;
		centerY = r * 145 + 150;
		
		
		
		canvasX = centerX;
		canvasY = centerY;
		
		
		
		
		float tempX = 0;
		float tempY = 0;
		double angle = 0;
		
		
		angle = (1.0 / 12.0) * 2.0 * Math.PI; //position to 1/12
		
		//tempX = (float) (Math.cos(angle) * 90.0);
		//tempY = (float) (Math.sin(angle) * 90.0);
		tempX = (float) (Math.cos(angle) * 80.0);
		tempY = (float) (Math.sin(angle) * 70.0);
		
		shapePath.moveTo( tempX, tempY );
		
		
		for( float i = 11; i > 0; i -= 2 )
	    {
	    	angle = (i / 12.0) * 2.0 * Math.PI; //initial position to 11/12, final position to 1/12
			
			tempX = (float) (Math.cos(angle) * 80.0);
			tempY = (float) (Math.sin(angle) * 70.0);
			
			shapePath.lineTo( tempX, tempY );
	    }
		
	    
	    
	    shapePath.close();
		
		//HEXAGON END
	}
	
	
	public float getCenterX()
	{
		return centerX;
	}
	public float getCenterY()
	{
		return centerY;
	}
	
	
	public float getCanvasX()
	{
		return canvasX;
	}
	public float getCanvasY()
	{
		return canvasY;
	}
	
	
	public void setCanvasX(float newValue)
	{
		this.canvasX = newValue;
	}
	public void setCanvasY(float newValue)
	{
		this.canvasY = newValue;
	}
	
	
	public float getRow()
	{
		return row;
	}
	public float getColumn()
	{
		return column;
	}
	
	
	
	
	
	
	public SelectState getHighlighted()
	{
		return this.currentState;
	}
	//make a processHighlighted event???
	public void setHighlighted(SelectState newState)
	{
		this.currentState = newState;
	}
	
	
	
	public HeldState getHeldState()
	{
		return this.myHeldState;
	}
	public void setHeldState(HeldState newState)
	{
		this.myHeldState = newState;
	}
	
	
	
	public OccupantState getOccupantState()
	{
		return this.myOccupantState;
	}
	public void setOccupantState(OccupantState newState)
	{
		this.myOccupantState = newState;
	}
	
	
	
	
	
	
	
	
	
	public String toString()
	{
		StringBuilder returnMe = new StringBuilder();
		returnMe.append("row: ");
		returnMe.append(this.row);
		returnMe.append(" column: ");
		returnMe.append(this.column);
		
		return returnMe.toString();
	}
	
	
	public void setColor(int newColor)
	{
		myColor = newColor;
	}
	
	public boolean equals( Hexagon5 other )
	{
		boolean returnMe = false;
		
		if (other.getRow() == row && other.getColumn() == column)
		{
			returnMe = true;
		}
		
		return returnMe;
	}
	
	
	
	public void updateSelfColor()
	{
		//update the color
		
		//HOLD_BLUE, HOLD_PURPLE, HOLD_GREEN, HOLD_YELLOW, HOLD_RED
		
		
		if (this.currentState == SelectState.SELECTED) //HIGHLIGHTED
		{
			switch ( myHeldState ) {
			case NONE:
				//setColor( Color.parseColor("#6DCAEC") );
				break;
			case HOLD_BLUE:
				setColor( Color.parseColor("#6DCAEC") );
				break;
			case HOLD_PURPLE:
				setColor( Color.parseColor("#C58BE2") );
				break;
			case HOLD_GREEN:
				setColor( Color.parseColor("#99CC00") );
				break;
			case HOLD_ORANGE:
				setColor( Color.parseColor("#FFBD21") );
				break;
			case HOLD_RED:
				setColor( Color.parseColor("#FF5F5F") );
				break;
			default:
				//nothing
			}
		}
		else //NOT HIGHLIGHTED
		{
			switch ( myHeldState ) {
			case NONE:
				//setColor( Color.parseColor("#6DCAEC") );
				break;
			case HOLD_BLUE:
				//setColor( Color.parseColor("#0099CC") );
				setColor( Color.parseColor("#079DD0") );
				break;
			case HOLD_PURPLE:
				//setColor( Color.parseColor("#9933CC") );
				setColor( Color.parseColor("#A041D0") );
				break;
			case HOLD_GREEN:
				//setColor( Color.parseColor("#669900") );
				setColor( Color.parseColor("#69A000") );
				break;
			case HOLD_ORANGE:
				//setColor( Color.parseColor("#FF8800") );
				setColor( Color.parseColor("#FF9105") );
				break;
			case HOLD_RED:
				//setColor( Color.parseColor("#CC0000") );
				setColor( Color.parseColor("#D30A0A") );
				break;
			default:
				//nothing
			}
		}
		
		
	}
	
	
	
	
	public void drawSelf( Canvas canvas, Bitmap drawBlock,
			float myScale, float scrollX, float scrollY )
	{
		canvas.save();
		
		//canvas.scale( myScale, myScale );
		
		float canvasHeight = canvas.getHeight() / 2;
		float canvasWidth = canvas.getWidth() / 2;
		
		canvas.translate( canvasWidth, canvasHeight );
		
		
		canvas.scale( myScale, myScale );
		
		
		canvas.translate( scrollX, scrollY );
		
		
		//LAST USED
		//canvas.scale( myScale, myScale );
		
		
		
		float YfromCenter = centerY - canvasHeight;
		float XfromCenter = centerX - canvasWidth;
		
		canvas.translate( XfromCenter, YfromCenter );
		
		
		
		
		int wHalf = drawBlock.getWidth() / 2;
		int hHalf = drawBlock.getHeight() / 2;
		
		canvas.drawBitmap(drawBlock, -wHalf, (-hHalf + 32), paintFill);
		
		
		
		paintFill.setColor( myColor );
		paintFill.setStyle( Paint.Style.FILL );
		
		//only affects tile size (they shrink in place)
		//canvas.scale( myScale, myScale );
		
		if (myHeldState != HeldState.NONE)
		{
			canvas.drawPath( shapePath, paintFill );
		}
		
		//ineffective here
		//canvas.scale( myScale, myScale );
		
		
		canvas.restore();
	}
	
	public void drawSelfOccupied( Canvas canvas, Bitmap drawBlock, Bitmap drawOccupant,
			float myScale, float scrollX, float scrollY )
	{
		canvas.save();
		
		//canvas.scale( myScale, myScale );
		
		float canvasHeight = canvas.getHeight() / 2;
		float canvasWidth = canvas.getWidth() / 2;
		
		canvas.translate( canvasWidth, canvasHeight );
		
		
		canvas.scale( myScale, myScale );
		
		
		canvas.translate( scrollX, scrollY );
		
		
		//LAST USED
		//canvas.scale( myScale, myScale );
		
		
		
		float YfromCenter = centerY - canvasHeight;
		float XfromCenter = centerX - canvasWidth;
		
		canvas.translate( XfromCenter, YfromCenter );
		
		
		
		
		int wHalf = drawBlock.getWidth() / 2;
		int hHalf = drawBlock.getHeight() / 2;
		
		canvas.drawBitmap(drawBlock, -wHalf, (-hHalf + 30), paintFill);
		
		
		
		paintFill.setColor( myColor );
		paintFill.setStyle( Paint.Style.FILL );
		
		//only affects tile size (they shrink in place)
		//canvas.scale( myScale, myScale );
		
		if (myHeldState != HeldState.NONE)
		{
			canvas.drawPath( shapePath, paintFill );
		}
		
		//ineffective here
		//canvas.scale( myScale, myScale );
		
		
		
		/**************************************/
		
		wHalf = drawOccupant.getWidth() / 2;
		hHalf = drawOccupant.getHeight() / 2;
		
		canvas.drawBitmap(drawOccupant, -wHalf, (-hHalf - 30), paintFill);
		
		/**************************************/
		
		
		
		canvas.restore();
	}
	
	
}




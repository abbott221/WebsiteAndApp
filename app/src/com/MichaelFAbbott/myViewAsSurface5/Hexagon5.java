package com.MichaelFAbbott.myViewAsSurface5;

import com.MichaelFAbbott.standards.AttemptController;

import android.graphics.*;
import android.util.Log;

public class Hexagon5
{
	public static int hSize = 20;
	
	private Paint paintFill;
	private static Path shapePath;
	
	
	private int row, column;
	
	private float centerX, centerY;
	
	int myColor;
	
	
	
	
	public static enum SelectState {
		SELECTED, UNSELECTED
	}
	public static enum HeldState {
		HOLD_BLUE, HOLD_PURPLE, HOLD_GREEN, HOLD_YELLOW, HOLD_RED
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
		
		centerX = c * 200 + 150;
		if (r % 2 != 0)
		{
			centerX += 100;
		}
		
		centerY = r * 200 + 150;
		
		
		
		float tempX = 0;
		float tempY = 0;
		double angle = 0;
		
		
		angle = (1.0 / 12.0) * 2.0 * Math.PI; //position to 1/12
		
		tempX = (float) (Math.cos(angle) * 90.0);
		tempY = (float) (Math.sin(angle) * 90.0);
		
		shapePath.moveTo( tempX, tempY );
		
		
		for( float i = 11; i > 0; i -= 2 )
	    {
	    	angle = (i / 12.0) * 2.0 * Math.PI; //initial position to 11/12, final position to 1/12
			
			tempX = (float) (Math.cos(angle) * 90.0);
			tempY = (float) (Math.sin(angle) * 90.0);
			
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
	
	
	
	public void updateSelf()
	{
		//update the color
		
		//HOLD_BLUE, HOLD_PURPLE, HOLD_GREEN, HOLD_YELLOW, HOLD_RED
		
		
		if (this.currentState == SelectState.SELECTED)
		{
			switch ( myHeldState ) {
			case HOLD_BLUE:
				setColor( Color.parseColor("#33B5E5") );
				break;
			case HOLD_PURPLE:
				setColor( Color.parseColor("#AA66CC") );
				break;
			case HOLD_GREEN:
				setColor( Color.parseColor("#99CC00") );
				break;
			case HOLD_YELLOW:
				setColor( Color.parseColor("#FFBB33") );
				break;
			case HOLD_RED:
				setColor( Color.parseColor("#FF4444") );
				break;
			default:
				//nothing
			}
		}
		else
		{
			switch ( myHeldState ) {
			case HOLD_BLUE:
				setColor( Color.parseColor("#0099CC") );
				break;
			case HOLD_PURPLE:
				setColor( Color.parseColor("#9933CC") );
				break;
			case HOLD_GREEN:
				setColor( Color.parseColor("#669900") );
				break;
			case HOLD_YELLOW:
				setColor( Color.parseColor("#FF8800") );
				break;
			case HOLD_RED:
				setColor( Color.parseColor("#CC0000") );
				break;
			default:
				//nothing
			}
		}
		
		
	}
	
	
	/*
	public void drawSelf2( Canvas canvas, Bitmap drawMe )
	{
		
		//debug.drawSelf(canvas);
		

		canvas.save();
		
		//canvas.scale( 2, 2 );
		canvas.translate( centerX, centerY );
		
		paintFill.setColor( myColor );
		
		
		
		//paintFill.setColor( myColor );
		paintFill.setStyle( Paint.Style.FILL );
		
		canvas.drawPath( shapePath, paintFill );
		
		
		//canvas.scale( 2, 2 );
		//canvas.translate( centerX, centerY );
		//canvas.drawBitmap(drawMe, 0, 0, new Paint());
		
		int w = drawMe.getWidth();
		int h = drawMe.getHeight();
		
		canvas.translate( -(w/2), -(h/2) );
		
		canvas.drawBitmap(drawMe, 0, 0, paintFill);
		
		
		
		canvas.restore();
	}
	/**/
	
	public void drawSelf( Canvas canvas, Bitmap drawBlock )
	{
		canvas.save();
		
		//canvas.scale( 2, 2 );
		
		canvas.translate( centerX, centerY );
		
		
		
		int wHalf = drawBlock.getWidth() / 2;
		int hHalf = drawBlock.getHeight() / 2;
		
		canvas.drawBitmap(drawBlock, -wHalf, (-hHalf + 30), paintFill);
		
		
		
		paintFill.setColor( myColor );
		paintFill.setStyle( Paint.Style.FILL );
		
		canvas.drawPath( shapePath, paintFill );
		
		
		
		canvas.restore();
	}
	
	public void drawSelfOccupied( Canvas canvas, Bitmap drawBlock, Bitmap drawOccupant )
	{
		canvas.save();
		
		//canvas.scale( 2, 2 );
		
		canvas.translate( centerX, centerY );
		
		
		
		int wHalf = drawBlock.getWidth() / 2;
		int hHalf = drawBlock.getHeight() / 2;
		
		canvas.drawBitmap(drawBlock, -wHalf, (-hHalf + 30), paintFill);
		
		
		
		paintFill.setColor( myColor );
		paintFill.setStyle( Paint.Style.FILL );
		
		canvas.drawPath( shapePath, paintFill );
		
		
		
		wHalf = drawOccupant.getWidth() / 2;
		hHalf = drawOccupant.getHeight() / 2;
		
		canvas.drawBitmap(drawOccupant, -wHalf, (-hHalf - 30), paintFill);
		
		
		
		canvas.restore();
	}
	
	
}




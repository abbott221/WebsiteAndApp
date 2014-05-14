package com.MichaelAbbott.myCustomView;

import com.MichaelAbbott.standards.AttemptController;

import android.graphics.*;
import android.util.Log;

public class Hexagon
{
	public static int hSize = 20;
	
	private Paint paintFill;
	private static Path shapePath;
	
	
	private int row, column;
	
	private float centerX, centerY;
	
	int myColor;
	
	
	
	public static enum State {
		SELECTED, UNSELECTED
	}
	private State currentState;
	
	
	
	
	
	// constructor using row and col index
	public Hexagon( int r, int c )
	{
		this.currentState = State.UNSELECTED;
		
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
	
	
	public State getHighlighted()
	{
		return this.currentState;
	}
	//make a processHighlighted event???
	public void setHighlighted(State newState)
	{
		this.currentState = newState;
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
	
	public boolean equals( Hexagon other )
	{
		boolean returnMe = false;
		
		if (other.getRow() == row && other.getColumn() == column)
		{
			returnMe = true;
		}
		
		return returnMe;
	}
	
	
	public void drawSelf( Canvas canvas )
	{
		
		//debug.drawSelf(canvas);
		

		canvas.save();
		
		//canvas.scale( 2, 2 );
		canvas.translate( centerX, centerY );
		
		if (currentState == State.SELECTED)
		{
			paintFill.setColor( android.graphics.Color.BLUE );
		}
		else if (currentState == State.UNSELECTED)
		{
			paintFill.setColor( android.graphics.Color.RED );
		}
		
		
		//paintFill.setColor( myColor );
		paintFill.setStyle( Paint.Style.FILL );
		
		canvas.drawPath( shapePath, paintFill );
		
		
		
		canvas.restore();
		
		
		
		
	}
}




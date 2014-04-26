package com.MichaelFAbbott.myCustomView;

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
	
	
	
	
	
	
	
	// constructor using row and col index
	public Hexagon( int r, int c )
	{
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
		
		centerX = c * 200 + 200;
		if (r % 2 != 0)
		{
			centerX += 100;
		}
		
		centerY = r * 200 + 200;
		
		
		
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
	
	
	public String toString()
	{
		StringBuilder returnMe = new StringBuilder();
		returnMe.append("row: ");
		returnMe.append(row);
		returnMe.append(" column: ");
		returnMe.append(column);
		
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
		/*
		double x, y;
		
		if( column % 2 == 0 )
		{
			x = column * 3.0 / 2.0;
			y = row * Math.sqrt( 3 );
		}
		else
		{
			x = 1.5 + 3 * (column - 1) / 2.0;
			y = ( -0.5 + row ) * Math.sqrt( 3 );
		}
		/**/
		//debug.drawSelf(canvas);
		

		canvas.save();
		
		//canvas.scale( 2, 2 );
		canvas.translate( centerX, centerY );
		
		paintFill.setColor( myColor );
		//int something = android.graphics.Color.RED;
		
		//if (row == 1 && column == 1)
		//{
		//	paintFill.setColor( android.graphics.Color.BLUE );
		//}
		
		//paintFill.setColor( 0xff74AC23 );
		//paintFill.setColor( 0xFF000000 );
		//paintFill.setStyle( Paint.Style.STROKE );
		paintFill.setStyle( Paint.Style.FILL );
		
		//paintFill.setStrokeWidth(50);
		
		canvas.drawPath( shapePath, paintFill );
		
		canvas.restore();
		
		
		
		
	}
}




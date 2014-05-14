package com.MichaelAbbott.myCustomView;

import android.graphics.*;

public class Triangle
{
	public static int hSize = 20;
	
	private Paint paintFill;
	private static Path shapePath;
	
	
	//private final int row, column;
	
	private final float endX, endY;
	
	// constructor using row and col index
	public Triangle( float x, float y )
	{
		endX = x;
		endY = y;
		
		
		//HEXAGON START
		
		paintFill = new Paint();
		paintFill.setColor(0xff74AC23);
		paintFill.setStyle( Paint.Style.FILL );
		
		
		
		shapePath = new Path();
		
		//float centerX = 200;
		//float centerY = 200;
		
		//centerX = r * 200 + 200;
		shapePath.lineTo(endX, endY);
		shapePath.lineTo(0, endY);
		shapePath.lineTo(0,0);
		shapePath.close();
		
		//HEXAGON END
	}
	
	
	
	public void drawSelf( Canvas canvas )
	{
		
		paintFill.setColor( 0xff74AC23 );
		
		paintFill.setStyle( Paint.Style.FILL );
		//paintFill.setStrokeWidth(50);
		
		canvas.drawPath( shapePath, paintFill );
		
	}
}




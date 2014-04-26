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
	
	private boolean printed;
	
	
	
	
	
	private Triangle debug;
	
	
	
	
	// constructor using row and col index
	public Hexagon( int r, int c )
	{
		row = r;
		column = c;
		
		
		printed = false;
		
		
		//HEXAGON START
		
		paintFill = new Paint();
		paintFill.setColor(0xff74AC23);
		paintFill.setStyle( Paint.Style.FILL );
		
		
		
		shapePath = new Path();
		
		//float centerX = 200;
		//float centerY = 200;
		
		centerX = r * 200 + 200;
		if (r % 2 != 0)
		{
			centerX += 100;
		}
		
		centerY = c * 200 + 200;
		
		
		
		float tempX = 0;
		float tempY = 0;
		double angle = 0;
		
		
		angle = (1.0 / 12.0) * 2.0 * Math.PI; //position to 1/12
		
		//tempX = (float) (Math.cos(angle) * 90.0) + centerX;
		//tempY = (float) (Math.sin(angle) * 90.0) + centerY;
		tempX = (float) (Math.cos(angle) * 90.0);
		tempY = (float) (Math.sin(angle) * 90.0);
		
		shapePath.moveTo( tempX, tempY );
		
		
		for( float i = 11; i > 0; i -= 2 )
	    {
	    	angle = (i / 12.0) * 2.0 * Math.PI; //initial position to 11/12, final position to 1/12
			
			//tempX = (float) (Math.cos(angle) * 90.0) + centerX;
			//tempY = (float) (Math.sin(angle) * 90.0) + centerY;
			tempX = (float) (Math.cos(angle) * 90.0);
			tempY = (float) (Math.sin(angle) * 90.0);
			
			shapePath.lineTo( tempX, tempY );
	    }
		
	    
	    
	    shapePath.close();
		
		//HEXAGON END
	    
	    
	    
	    debug = new Triangle(centerX, centerY);
	    
	    
	}
	
	
	
	public void drawHexagon( Canvas canvas )
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
		debug.drawSelf(canvas);
		

		canvas.save();
		
		//canvas.scale( 2, 2 );
		canvas.translate( centerX, centerY );
		
		paintFill.setColor( android.graphics.Color.RED );
		
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
		
		
		if (!printed)
		{
			printed = true;
			System.err.println(row + "x: " + centerX);
			System.err.println(column + "y: " + centerY);
			//Log.e("log_tag", row + "x: " + centerX);
			//Log.e("log_tag", column + "y: " + centerY);
		}
		
		
	}
}




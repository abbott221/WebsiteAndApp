package com.MichaelFAbbott.myCustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

public class CustomDrawableView3 extends View {
	
	
	private ShapeDrawable mDrawable;
	
	private Paint brush;
	private static Path drawPath;
	
	
	
	public CustomDrawableView3(Context context) {
		super(context);
		
		int x = 10;
		int y = 10;
		int width = 300;
		int height = 50;
		
		
		
		
		//New Content Starts
		brush = new Paint();
		brush.setColor(0xff74AC23);
		
		
		
		
		drawPath = new Path();
	    drawPath.moveTo( 1, 0 );
	    
	    double d_rad = Math.PI / 3;
	      
	    for( double ang = 2 * Math.PI; ang > 0; ang -= d_rad )
	    {
	    	drawPath.lineTo( (float) Math.cos( ang ), (float) Math.sin( ang ) );
	    }

	      drawPath.close();
		//New Content Ends
		
		
		
		
		//try PathShape
		mDrawable = new ShapeDrawable(new OvalShape());
		
		mDrawable.getPaint().setColor(0xff74AC23);
		mDrawable.setBounds(x, y, x + width, y + height);
	}
	
	
	
	//Tile's onDraw()
	protected void onDraw(Canvas canvas) {
		mDrawable.draw(canvas);
		
		
		//***this is important***
	    //drawPath(Path, Paint)
	    //canvas.drawPath( drawPath, brush );
		
	}
	
	
}
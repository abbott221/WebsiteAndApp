package com.MichaelFAbbott.myCustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

public class Board_CustomView extends View {
	private ShapeDrawable mDrawable;
	
	private Paint paintFill;
	private static Path shapePath;
	
	public Board_CustomView(Context context) {
		super(context);
		
		//OVAL START
		
		int x = 10;
		int y = 10;
		int width = 300;
		int height = 50;
		
		mDrawable = new ShapeDrawable(new OvalShape());
		mDrawable.getPaint().setColor(0xff74AC23);
		mDrawable.setBounds(x, y, x + width, y + height);
		
		//OVAL END
		
		//HEXAGON START
		
		paintFill = new Paint();
		paintFill.setColor(0xff74AC23);
		paintFill.setStyle( Paint.Style.FILL );
		
		
		
		shapePath = new Path();
		
		
		/*
	    shapePath.moveTo( 1, 0 );
	    
	    double d_rad = Math.PI / 3;
	      
	    for( double ang = 2 * Math.PI; ang > 0; ang -= d_rad )
	    {
	    	shapePath.lineTo( (float) Math.cos( ang ), (float) Math.sin( ang ) );
	    }
	    */
	    
		shapePath.moveTo( 100, 100 );
		shapePath.lineTo( 300, 300 );
		shapePath.lineTo( 100, 300 );
		shapePath.lineTo( 100, 100 );
		
		
	    
	    
	    shapePath.close();
		
		//HEXAGON END
		
	}
	
	
	//is the override necessary?
	@Override
	protected void onDraw(Canvas canvas) {
		mDrawable.draw(canvas);
		
		//(border of the object, color to fill it with)
		//canvas.drawPath(shapePath, paintFill);
		
		canvas.save();
		
		canvas.scale( 2, 2 );
		canvas.translate( 100, 100 );
		
		paintFill.setColor( android.graphics.Color.RED );
		//paintFill.setColor( 0xff74AC23 );
		//paintFill.setColor( 0xFF000000 );
		paintFill.setStyle( Paint.Style.STROKE );
		//paintFill.setStyle( Paint.Style.FILL );
		
		paintFill.setStrokeWidth(50);
		
		canvas.drawPath( shapePath, paintFill );
		
		canvas.restore();
		
	}
}







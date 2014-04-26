package com.MichaelFAbbott.myCustomView;

import com.MichaelFAbbott.customView.GameMap;
import com.MichaelFAbbott.customView.Tile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class Board_CustomView extends View {
	
	//private Paint paintFill;
	//private static Path shapePath;
	
	private Hexagon[][] board;
	
	private Hexagon highlighted;
	
	private int rows, columns;
	
	private float touchRadius = 90;
	
	
	
	private Board_CustomView.MyTouchGestureListener touch_listener;
	//private this.MyTouchGestureListener touch_listener;
	
	private GestureDetector gestures;
	
	
	
	//private Triangle debug;
	
	public Board_CustomView(Context context) {
		
		super(context);
		
		rows = 4;
		columns = 4;
		
		board = new Hexagon[ rows ][ columns ];
		
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				board[i][j] = new Hexagon(i, j);
			}
		}
		
		
		
		//debug = new Triangle(300, 600);
		
		
		
		
		touch_listener = new Board_CustomView.MyTouchGestureListener();
		gestures = new GestureDetector( context, touch_listener );
		
	}
	
	
	//is the override necessary?
	@Override
	protected void onDraw(Canvas canvas) {
		
		//debug.drawSelf(canvas);
		
		
		/**/
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				Hexagon current = board[i][j];
				
				if (highlighted != null)
				{
					//System.err.println("lol3");
					
					if (current.equals(highlighted))
					{
						//somehow change the color
						current.setColor(android.graphics.Color.BLUE);
						current.drawSelf(canvas);
						
						System.err.println("lol4");
					}
					else
					{
						current.setColor(android.graphics.Color.RED);
						current.drawSelf(canvas);
					}
				}
				else
				{
					current.setColor(android.graphics.Color.RED);
					current.drawSelf(canvas);
				}
				
				
				
				
			}
		}
		
		
	}
	
	
	
	
	@Override
	public boolean onTouchEvent( MotionEvent e )
	{
		//scale_gestures.onTouchEvent( e );
		//if( !scale_gestures.isInProgress() )
		
		gestures.onTouchEvent( e );
		
		System.err.println("lol");
		
		invalidate();
		return true;
	}
	
	
	
	
	/**
	 * THIS COULD RETURN NULL!!!
	 * if the user didn't tap within the range of a hexagon
	 * (or possibly tapped waaaayyy away from the hexagons), then
	 * nothing will be set to selected
	 */
	public Hexagon getClosestTile(float x, float y)
	{
		float tempX = 0;
		float tempY = 0;
		
		float diffX = 0;
		float diffY = 0;
		
		Hexagon selected = null;
		
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				tempX = board[i][j].getCenterX();
				tempY = board[i][j].getCenterY();
				
				
				diffX = tempX - x;
				diffY = tempY - y;
				
				if ( (diffX*diffX) + (diffY*diffY) < (touchRadius*touchRadius) )
				{
					selected = board[i][j];
				}
				
				
			}
		}
		
		//THIS COULD RETURN NULL!!!
		return selected;
	}
	
	
	private class MyTouchGestureListener extends GestureDetector.SimpleOnGestureListener
	{
		@Override
		public boolean onSingleTapConfirmed( MotionEvent e )
		{
			float eX = e.getX();
			float eY = e.getY();
			
			
			
			
			Hexagon temp = getClosestTile(eX, eY);
			
			if (temp != null)
			{
				highlighted = temp;
			}
			
			
			if (temp != null)
			{
				System.err.println("lol2: " + temp.toString() );
			}
			else
			{
				//if null, what was the x and y?
				
				System.err.println("lol2: null");
				System.err.println("lol2: x: " + eX + " y: " + eY);
			}
			
			
			invalidate();
			return true;
		}
	}
	
}







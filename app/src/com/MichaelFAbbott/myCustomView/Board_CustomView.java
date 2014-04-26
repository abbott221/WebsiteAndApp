package com.MichaelFAbbott.myCustomView;

import com.MichaelFAbbott.customView.Tile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

public class Board_CustomView extends View {
	
	//private Paint paintFill;
	//private static Path shapePath;
	
	private Hexagon[][] board;
	
	private int rows, columns;
	
	private Triangle debug;
	
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
		
		
		
		debug = new Triangle(300, 600);
		
	}
	
	
	//is the override necessary?
	@Override
	protected void onDraw(Canvas canvas) {
		
		debug.drawSelf(canvas);
		
		
		/**/
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				board[i][j].drawSelf(canvas);
			}
		}
		/**/
		
		//board[2][2].drawHexagon(canvas);
		//board[2][3].drawHexagon(canvas);
		//board[3][3].drawHexagon(canvas);
		
		
		/*
		for( Hexagon[] list : board )
		{
			for( Hexagon t : list )
			{
				if( t == null )
				{
					continue;
				}
				t.drawHexagon( canvas );
			}
		}
		/**/
		
	}
}







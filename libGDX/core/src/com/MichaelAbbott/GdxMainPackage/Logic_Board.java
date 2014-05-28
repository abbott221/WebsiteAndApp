package com.MichaelAbbott.GdxMainPackage;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Logic_Board {
	
	
	
	
	public static Hexagon getClosestTile(TileModel model, float x, float y) {
		
		float tempX = 0;
		float tempY = 0;
		
		float diffX = 0;
		float diffY = 0;
		
		float inputX = x;
		float inputY = y;
		
		Hexagon pressed = null;
		
		for (int i = 0; i < model.getRows(); i++) {
			for (int j = 0; j < model.getColumns(); j++) {
				
				float tempRadius = model.getTouchRadius();
				//tempRadius *= scaleSize;
				
				tempX = model.board[i][j].getCenterX();
				tempY = model.board[i][j].getCenterY();
				
				diffX = tempX - inputX;
				diffY = tempY - inputY;
				
				if ( (diffX*diffX) + (diffY*diffY) < (tempRadius*tempRadius) )
				{
					pressed = model.board[i][j];
				}
				
			}
		}
		
		
		
		return pressed;
	}
	
	
	
	
}

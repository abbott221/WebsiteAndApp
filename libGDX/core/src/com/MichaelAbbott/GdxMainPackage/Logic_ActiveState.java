package com.MichaelAbbott.GdxMainPackage;

import com.MichaelAbbott.GdxMainPackage.Hexagon.ActiveState;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Logic_ActiveState {
	
	
	
	
	public static void tilePressed(Mediator mediator, Hexagon pressed) {
		clearTiles(mediator, pressed);
		
		mediator.model.getPressedTile().setActiveState(ActiveState.YELLOW);
	}
	
	
	public static void clearTiles(Mediator mediator, Hexagon pressed) {
		
		TileModel model = mediator.model;
		
		for (int i = 0; i < model.getRows(); i++) {
			for (int j = 0; j < model.getColumns(); j++) {
				
				model.board[i][j].setActiveState(ActiveState.NONE);
				
			}
		}
		
		
	}
	
	
	
	
}

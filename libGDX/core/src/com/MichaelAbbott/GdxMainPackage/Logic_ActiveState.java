package com.MichaelAbbott.GdxMainPackage;

import java.util.ArrayList;

import com.MichaelAbbott.GdxMainPackage.Hexagon.ActiveState;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Logic_ActiveState {
	
	
	
	
	public static void tilePressed(Mediator mediator, Hexagon pressed) {
		
		Hexagon.ActiveState hold = pressed.getActiveState();
		Actor occupant = mediator.model.getOccupant(pressed.getRow(), pressed.getColumn());
		
		clearTiles(mediator, pressed);
		
		
		if (hold == ActiveState.PURPLE) {
			//
		}
		else if (hold == ActiveState.YELLOW) {
			//
		}
		else if (hold == ActiveState.RED) {
			//
		}
		
		
		else if ( Logic_Tile.occupantIsAlien(mediator.model, pressed) ) {
			selectedCreatureTile(mediator, pressed);
		}
		
		
		
		mediator.model.getPressedTile().setActiveState(ActiveState.BLUE);
	}
	
	
	
	public static void selectedYellowTile(Mediator med, Hexagon active) {
		
		
		
		clearTiles(med, active);
		
		
		ArrayList<Hexagon> openTiles = Logic_Tile.getBlockNeighbors(active, med.model);
		setHolds(openTiles, ActiveState.YELLOW);
	}
	
	
	
	
	public static void clearTiles(Mediator mediator, Hexagon pressed) {
		
		Model_General model = mediator.model;
		
		for (int i = 0; i < model.getRows(); i++) {
			for (int j = 0; j < model.getColumns(); j++) {
				
				model.board[i][j].setActiveState(ActiveState.NONE);
				
			}
		}
		
		
	}
	
	public static void selectedCreatureTile(Mediator med, Hexagon active) {
		
		
		
		clearTiles(med, active);
		
		
		ArrayList<Hexagon> openTiles = Logic_Tile.getBlockNeighbors(active, med.model);
		setHolds(openTiles, ActiveState.YELLOW);
	}
	
	
	
	
	public static void setHold(Hexagon target, Model_General model, ActiveState setting) {
		
		target.setActiveState(setting);
		
		
		model.setActiveTile(target);
		
	}
	
	
	
	public static void setHolds(ArrayList<Hexagon> targets, ActiveState setting) {
		
		for (Hexagon colorMe : targets)
		{
			colorMe.setActiveState( setting );
		}
		
	}
	
	
	
}

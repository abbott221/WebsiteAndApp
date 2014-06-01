package com.MichaelAbbott.GdxMainPackage;

import java.util.ArrayList;

import com.MichaelAbbott.GdxMainPackage.Actor.ActorType;
import com.MichaelAbbott.GdxMainPackage.Hexagon.ActiveState;
import com.MichaelAbbott.GdxMainPackage.Hexagon.CubeState;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Logic_Selection {
	
	
	
	
	public static void pressOccurred(Model_General model, Hexagon pressed) {
		
		Hexagon oldPressed = model.getMForSelection().getNewPressed();
		Hexagon oldActive = model.getMForSelection().getNewActive();
		
		Hexagon newPressed = pressed;
		Hexagon newActive = pressed;
		
		Actor occupant = null;
		
		if (newPressed != null) {
			occupant = model.getOccupant(newPressed.getRow(), newPressed.getColumn());
		}
		
		
		/**/
		model.getMForSelection().setNewActive(newActive);
		model.getMForSelection().setNewPressed(newPressed);
		
		model.getMForSelection().setOldActive(oldActive);
		model.getMForSelection().setOldPressed(oldPressed);
		/**/
		
		
		
		//CHECK FOR NULL VARIABLES!
		
		
		
		//if a tile within the grid was selected
		if (newPressed != null) {
			
			//if there is a block there
			if (newPressed.getCubeState() != CubeState.NONE) {
				
				//if the user didn't press the active tile
				if (newPressed != oldActive) {
					//Logic_ActiveState.tilePressed(model.getMediator(), newPressed);
					selectionEvent(model);
				}
				//~pressed the same tile twice
				else {
					unselectionEvent(model, pressed);
				}
				
			}
			//there is no block there
			else {
				unselectionEvent(model, pressed);
			}
			
		}
		//player pressed off the grid
		else {
			unselectionEvent(model, pressed);
		}
		
		
		
		
		
		//model.setPressedTile(newPressed);
		//model.setActiveTile(newActive);
		//model.setPreviousTile(newPrevious);
		
		
		/*
		model.getMForSelection().setNewActive(newActive);
		model.getMForSelection().setNewPressed(newPressed);
		
		model.getMForSelection().setOldActive(oldActive);
		model.getMForSelection().setOldPressed(oldPressed);
		/**/
	}
	
	
	public static void selectionEvent(Model_General model) {
		
		
		//model.setPressedTile(touched);
		
		
		//is this the best place to call this?
		Logic_ActiveState.tilePressed( model.getMediator(), model.getMForSelection().getNewPressed() );
		
		
		
	}
	
	public static void unselectionEvent(Model_General model, Hexagon touched) {
		
		Hexagon current = null;
		
		for (int i = 0; i < model.getRows(); i++) {
			for (int j = 0; j < model.getColumns(); j++) {
				current = model.getHexagon(i, j);
				
				//current.setHighlighted(Hexagon5.SelectState.UNSELECTED);
				current.setActiveState(ActiveState.NONE);
			}
		}
		
		//model.setPressedTile(null);
		//model.setActiveTile(null);
		
		
		model.getMForSelection().setNewActive(null);
		model.getMForSelection().setNewPressed(null);
		
		model.getMForSelection().setOldActive(null);
		model.getMForSelection().setOldPressed(null);
	}
	
	
	
	
}





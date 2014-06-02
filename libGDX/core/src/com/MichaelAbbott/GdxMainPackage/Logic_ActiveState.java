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
			selectedYellowTile(mediator);
		}
		else if (hold == ActiveState.RED) {
			selectedRedTile(mediator);
		}
		
		
		else if ( Logic_Tile.occupantIsAlien(mediator.model, pressed) ) {
			selectedCreatureTile(mediator, pressed);
		}
		
		//selected empty tile
		else {
			selectedEmptyTile(mediator, pressed);
		}
		
		//mediator.model.getPressedTile().setActiveState(ActiveState.BLUE);
		//setHold()
	}
	
	
	
	
	
	
	public static void selectedYellowTile(Mediator med) {
		
		//med.model.getMForSelection();
		
		Hexagon newActive = med.model.getMForSelection().getNewActive();
		Hexagon oldPressed = med.model.getMForSelection().getOldPressed();
		Hexagon newPressed = med.model.getMForSelection().getNewPressed();
		
		
		Actor occupant = null;
		
		
		if (oldPressed != null) {
			occupant = med.model.getOccupant(oldPressed.getRow(), oldPressed.getColumn());
		}
		
		
		//if (newActive != null) {
		if (newActive != newPressed) {
			occupant = med.model.getOccupant( newActive.getRow(), newActive.getColumn() );
		}
		else {
			med.model.getMForSelection().setNewActive(oldPressed);
			
			newActive = med.model.getMForSelection().getNewActive();
			
			occupant = med.model.getOccupant( newActive.getRow(), newActive.getColumn() );
		}
		
		
		
		
		occupant.setLocation(newPressed);
		
		
		
		
		clearTiles(med, newPressed);
		
		
		ArrayList<Hexagon> openTiles = Logic_Tile.getOpenNeighbors(newPressed, med.model);
		ArrayList<Hexagon> neutralTiles = Logic_Tile.getNeutralNeighbors(newPressed, med.model);
		setHolds(openTiles, ActiveState.YELLOW);
		setHolds(neutralTiles, ActiveState.RED);
		
		setHold(newPressed, med.model, ActiveState.BLUE);
		med.model.getMForSelection().setNewActive(newPressed);
	}
	
	
	
	
	
	public static void selectedRedTile(Mediator med) {
		
		//med.model.getMForSelection();
		
		Hexagon newActive = med.model.getMForSelection().getNewActive();
		Hexagon oldPressed = med.model.getMForSelection().getOldPressed();
		Hexagon newPressed = med.model.getMForSelection().getNewPressed();
		
		
		Actor attacker = null;
		//Actor occupant = null;
		
		
		if (oldPressed != null) {
			attacker = med.model.getOccupant(oldPressed.getRow(), oldPressed.getColumn());
		}
		
		
		
		//if oldPressed is wrong, get the data from newActive
		if (oldPressed == newPressed) {
			if (newActive != null) {
				attacker = med.model.getOccupant( newActive.getRow(), newActive.getColumn() );
			}
		}
		else {
			med.model.getMForSelection().setNewActive(oldPressed);
			
			newActive = med.model.getMForSelection().getNewActive();
			
			if (newActive != null) {
				attacker = med.model.getOccupant( newActive.getRow(), newActive.getColumn() );
			}
		}
		
		
		
		/*
		//if (newActive != null) {
		if (newActive != newPressed) {
			attacker = med.model.getOccupant( newActive.getRow(), newActive.getColumn() );
		}
		else {
			med.model.getMForSelection().setNewActive(oldPressed);
			
			newActive = med.model.getMForSelection().getNewActive();
			
			attacker = med.model.getOccupant( newActive.getRow(), newActive.getColumn() );
		}
		/**/
		
		
		Actor defender = med.model.getOccupant(newPressed.getRow(), newPressed.getColumn());
		
		
		
		//assume health has been reduced to 0
		med.model.setOccupant(newPressed.getRow(), newPressed.getColumn(), null);
		
		
		
		
		//attacker.setLocation(newPressed);
		
		
		
		/*
		clearTiles(med, newPressed);
		
		
		ArrayList<Hexagon> openTiles = Logic_Tile.getOpenNeighbors(newPressed, med.model);
		ArrayList<Hexagon> neutralTiles = Logic_Tile.getNeutralNeighbors(newPressed, med.model);
		setHolds(openTiles, ActiveState.YELLOW);
		setHolds(neutralTiles, ActiveState.RED);
		
		setHold(newPressed, med.model, ActiveState.BLUE);
		med.model.getMForSelection().setNewActive(newPressed);
		/**/
		
		clearTiles(med, newActive);
		
		
		ArrayList<Hexagon> openTiles = Logic_Tile.getOpenNeighbors(newActive, med.model);
		ArrayList<Hexagon> neutralTiles = Logic_Tile.getNeutralNeighbors(newActive, med.model);
		setHolds(openTiles, ActiveState.YELLOW);
		setHolds(neutralTiles, ActiveState.RED);
		
		setHold(newActive, med.model, ActiveState.BLUE);
		med.model.getMForSelection().setNewActive(newActive);
	}
	
	
	
	
	
	
	public static void selectedEmptyTile(Mediator med, Hexagon active) {
		
		clearTiles(med, active);
		
		setHold(active, med.model, ActiveState.BLUE);
		med.model.getMForSelection().setNewActive(active);
	}
	
	public static void selectedCreatureTile(Mediator med, Hexagon active) {
		
		
		
		clearTiles(med, active);
		
		
		ArrayList<Hexagon> openTiles = Logic_Tile.getOpenNeighbors(active, med.model);
		ArrayList<Hexagon> neutralTiles = Logic_Tile.getNeutralNeighbors(active, med.model);
		setHolds(openTiles, ActiveState.YELLOW);
		setHolds(neutralTiles, ActiveState.RED);
		
		setHold(active, med.model, ActiveState.BLUE);
		med.model.getMForSelection().setNewActive(active);
	}
	
	
	
	
	
	
	public static void clearTiles(Mediator mediator, Hexagon pressed) {
		
		Model_General model = mediator.model;
		
		for (int i = 0; i < model.getRows(); i++) {
			for (int j = 0; j < model.getColumns(); j++) {
				
				model.board[i][j].setActiveState(ActiveState.NONE);
			}
		}
		
	}
	
	public static void setHold(Hexagon target, Model_General model, ActiveState setting) {
		
		target.setActiveState(setting);
		
		//model.setActiveTile(target);
		
		//model.getMForSelection().setNewActive(target);
		
	}
	
	public static void setHolds(ArrayList<Hexagon> targets, ActiveState setting) {
		
		for (Hexagon colorMe : targets)
		{
			colorMe.setActiveState( setting );
		}
		
	}
	
	
	
}

package com.MichaelAbbott.myViewAsSurface6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.MichaelAbbott.myViewAsSurface6.Actor.ActorType;
import com.MichaelAbbott.myViewAsSurface6.Hexagon6.BlockState;
import com.MichaelAbbott.myViewAsSurface6.Hexagon6.HeldState;
import com.MichaelAbbott.myViewAsSurface6.Hexagon6.OccupantState;

import android.util.Log;



public class AI_PlayerInteraction6 {
	
	
	
	//all held states have been cleared (set to none)
	public static void playerSelectionEntry(Hexagon6 target, Board_Model6 model) {
		
		
		Hexagon6.HeldState hold = target.getHeldState();
    	//Hexagon6.OccupantState occupy = target.getOccupantState();
		
    	
    	

		//IMPLEMENTATION 2
		
		Actor occupant = target.getGrid().getOccupant( target.getRow(), target.getColumn() );
		
		//IT MAY REGISTER AS "ACTOR" WHEN SUPPOSE TO BE NULL
		/*
		if (occupant == null)
		{
			selectedEmptyTile(target, model);
		}
		else if (occupant.getActorType() == ActorType.NONE) {
    		selectedEmptyTile(target, model);
    	}
		else if ( AI_Hexagon6.occupantIsPortal(target) ) {
    		selectedPortalTile(target, model);
    	}
		else if ( AI_Hexagon6.occupantIsCreature(target) ) {
    		selectedCreatureTile(target, model);
    	}
    	
		
    	
    	if (hold == HeldState.HOLD_PURPLE) {
    		selectedPurpleTile(target, model);
    	}
    	if (hold == HeldState.HOLD_ORANGE) {
    		selectedYellowTile(target, model);
    	}
    	if (hold == HeldState.HOLD_RED) {
    		selectedRedTile(target, model);
    	}
    	/**/
    	
    	
    	
    	if (hold == HeldState.HOLD_PURPLE) {
    		selectedPurpleTile(target, model);
    	}
    	else if (hold == HeldState.HOLD_ORANGE) {
    		selectedYellowTile(target, model);
    	}
    	else if (hold == HeldState.HOLD_RED) {
    		selectedRedTile(target, model);
    	}
    	
    	
    	
    	else if (occupant == null)
		{
			selectedEmptyTile(target, model);
		}
		else if (occupant.getActorType() == ActorType.NONE) {
    		selectedEmptyTile(target, model);
    	}
		else if ( AI_Hexagon6.occupantIsPortal(target) ) {
    		selectedPortalTile(target, model);
    	}
		else if ( AI_Hexagon6.occupantIsCreature(target) ) {
    		selectedCreatureTile(target, model);
    	}
    	
		
		//IMPLEMENTATION 2 END
		
	}
	
	
	
	
	
	/**/
	public static void selectedEmptyTile(Hexagon6 target, Board_Model6 model) {
		
		
		clearTiles(model);
		
		setHold(target, HeldState.HOLD_BLUE);
		
		model.getView_References().updateBothVisibility(0);
	}
	/**/
	
	
	
	
	public static void selectedPurpleTile(Hexagon6 target, Board_Model6 model) {
		
		//ArrayList<Hexagon6> possibleMoves = AI_Hexagon6.getOpenNeighbors(target, model);
		
		
		Actor newOccupant = new Actor_BeigeAlien( model, target );
		
		model.setOccupant(target.getRow(), target.getColumn(), newOccupant);
		
		
		
		
		/*
		 * 
		 * POSITION AND REFERENCE CHANGES END
		 * 
		 */
		
		
		ArrayList<Hexagon6> possibleMoves = AI_Hexagon6.getOpenNeighbors(target, model);
		//ArrayList<Hexagon6> possibleEnemies = AI_Hexagon6.getNeutralNeighbors(target, model);
		ArrayList<Hexagon6> possibleEnemies = AI_Hexagon6.getNonplayerNeighbors(target, model);
		
		clearTiles(model);
		
		setHolds(possibleMoves, HeldState.HOLD_ORANGE);
		setHolds(possibleEnemies, HeldState.HOLD_RED);
		
		setHold(target, HeldState.HOLD_BLUE);
		
		View_References6 progBars = model.getView_References();
		progBars.updateBothVisibility(2);
		progBars.updateTopBar( 1, 1 );
		progBars.updateBottomBar( 1, 1 );
	}
	
	
	
	
	
	
	public static void selectedYellowTile(Hexagon6 target, Board_Model6 model) {
		
		Actor occupant = null;
		
		
		Hexagon6 previous = null;
		
		try {
			previous = model.getPreviousSelected();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (previous != null) {
			//previous.setOccupantState(OccupantState.NONE);
			
			occupant = model.getOccupant( previous.getRow(), previous.getColumn() );
		}
		
		occupant.setLocation(target);
		
		
		/*
		 * 
		 * POSITION AND REFERENCE CHANGES END
		 * 
		 */
		
		
		ArrayList<Hexagon6> possibleMoves = AI_Hexagon6.getOpenNeighbors(target, model);
		//ArrayList<Hexagon6> possibleEnemies = AI_Hexagon6.getNeutralNeighbors(target, model);
		ArrayList<Hexagon6> possibleEnemies = AI_Hexagon6.getNonplayerNeighbors(target, model);
		
		clearTiles(model);
		
		setHolds(possibleMoves, HeldState.HOLD_ORANGE);
		setHolds(possibleEnemies, HeldState.HOLD_RED);
		
		setHold(target, HeldState.HOLD_BLUE);
		
		
		View_References6 progBars = model.getView_References();
		progBars.updateBothVisibility(2);
		//might want to surround with try-catch in case null pointer error
		progBars.updateTopBar( occupant.getCurrentHealth(), occupant.getMaxHealth() );
		progBars.updateBottomBar( occupant.getCurrentEnergy(), occupant.getMaxEnergy() );
	}
	
	
	
	
	
	
	//base it off of YellowTile for energy decreases of previous
	public static void selectedRedTile(Hexagon6 target, Board_Model6 model) {
		
		Actor attacker = null;
		
		
		
		
		Hexagon6 previous = null;
		
		try {
			previous = model.getPreviousSelected();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (previous != null) {
			//previous.setOccupantState(OccupantState.NONE);
			
			attacker = model.getOccupant( previous.getRow(), previous.getColumn() );
		}
		
		
		
		
		Hexagon6 active = null;
		
		try {
			active = model.getActiveTile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//if previous is wrong
		if (previous == target) {
			
			System.err.println("Previous is wrong");
			
			if (active != null) {
				attacker = model.getOccupant( active.getRow(), active.getColumn() );
			}
		}
		//if previous isn't wrong, model.setActiveTile
		else {
			model.setActiveTile(previous);
			
			System.err.println("Previous is right");
			
			/**/
			//this is what I forgot: active wasn't updated!
			try {
				active = model.getActiveTile();
			} catch (Exception e) {
				e.printStackTrace();
			}
			/**/
			
			if (active != null) {
				attacker = model.getOccupant( active.getRow(), active.getColumn() );
			}
		}
		
		
		
		
		//Attacker has been initialized by here
		//Now initialize defender
		
		Actor defender = model.getOccupant( target.getRow(), target.getColumn() );
		
		
		//Now, change current values
		
		int damage = attacker.getPower();
		
		int health = defender.getCurrentHealth();
		int energy = attacker.getCurrentEnergy();
		
		health -= damage;
		energy -= damage;
		
		if (health <= 0)
		{
			//defender has been defeated
			model.setOccupant(target.getRow(), target.getColumn(), null);
		}
		else
		{
			//defender lives
			defender.setCurrentHealth(health);
		}
		
		attacker.setCurrentEnergy(energy);
		
		
		
		/*
		 * 
		 * POSITION AND REFERENCE CHANGES END
		 * 
		 */
		
		
		ArrayList<Hexagon6> possibleMoves = AI_Hexagon6.getOpenNeighbors(active, model);
		//ArrayList<Hexagon6> possibleEnemies = AI_Hexagon6.getNeutralNeighbors(active, model);
		ArrayList<Hexagon6> possibleEnemies = AI_Hexagon6.getNonplayerNeighbors(active, model);
		//ArrayList<Hexagon6> possibleMoves = AI_Hexagon6.getOpenNeighbors(previous, model);
		//ArrayList<Hexagon6> possibleEnemies = AI_Hexagon6.getNeutralNeighbors(previous, model);
		//ArrayList<Hexagon6> possibleMoves = AI_Hexagon6.getOpenNeighbors(target, model);
		//ArrayList<Hexagon6> possibleEnemies = AI_Hexagon6.getNeutralNeighbors(target, model);
		
		clearTiles(model);
		
		setHolds(possibleMoves, HeldState.HOLD_ORANGE);
		setHolds(possibleEnemies, HeldState.HOLD_RED);
		
		setHold(active, HeldState.HOLD_BLUE);
		//setHold(previous, HeldState.HOLD_BLUE);
		//setHold(target, HeldState.HOLD_BLUE);
		
		
		View_References6 progBars = model.getView_References();
		progBars.updateBothVisibility(2);
		//might want to surround with try-catch in case null pointer error
		progBars.updateTopBar( attacker.getCurrentHealth(), attacker.getMaxHealth() );
		progBars.updateBottomBar( attacker.getCurrentEnergy(), attacker.getMaxEnergy() );
	}
	
	
	
	
	
	public static void selectedPortalTile(Hexagon6 target, Board_Model6 model) {
		
		Actor occupant = model.getOccupant( target.getRow(), target.getColumn() );
		
		
		//get neighbors to be set
		ArrayList<Hexagon6> blocksByPortal = AI_Hexagon6.getOpenNeighbors(target, model);
		
		
		
		clearTiles(model);
		
		setHolds(blocksByPortal, HeldState.HOLD_PURPLE);
		setHold(target, HeldState.HOLD_BLUE);
		
		
		View_References6 progBars = model.getView_References();
		progBars.updateBothVisibility(2);
		progBars.updateTopBar( occupant.getCurrentHealth(), occupant.getMaxHealth() );
		progBars.updateBottomBar( occupant.getCurrentEnergy(), occupant.getMaxEnergy() );
	}
	
	
	
	
	public static void selectedCreatureTile(Hexagon6 target, Board_Model6 model) {
		
		Actor occupant = model.getOccupant( target.getRow(), target.getColumn() );
		
		//ArrayList<Hexagon6> possibleMoves = AI_Hexagon6.getOpenNeighbors(target, model);
		
		//this is already set
		//target.setOccupantState(OccupantState.OCC_BEIGE);
		
		
		
		
		/*
		 * 
		 * POSITION AND REFERENCE CHANGES END
		 * 
		 */
		
		
		ArrayList<Hexagon6> possibleMoves = AI_Hexagon6.getOpenNeighbors(target, model);
		//ArrayList<Hexagon6> possibleEnemies = AI_Hexagon6.getNeutralNeighbors(target, model);
		ArrayList<Hexagon6> possibleEnemies = AI_Hexagon6.getNonplayerNeighbors(target, model);
		
		clearTiles(model);
		
		setHolds(possibleMoves, HeldState.HOLD_ORANGE);
		setHolds(possibleEnemies, HeldState.HOLD_RED);
		
		setHold(target, HeldState.HOLD_BLUE);
		
		
		View_References6 progBars = model.getView_References();
		progBars.updateBothVisibility(2);
		progBars.updateTopBar( occupant.getCurrentHealth(), occupant.getMaxHealth() );
		progBars.updateBottomBar( occupant.getCurrentEnergy(), occupant.getMaxEnergy() );
	}
	
	
	
	
	public static void clearTiles( Board_Model6 model ) {
		
		for (int i = 0; i < model.getRows(); i++) {
			for (int j = 0; j < model.getColumns(); j++) {
				Hexagon6 current = model.getHexagon(i, j);
				
				//current.setHighlighted(Hexagon5.SelectState.UNSELECTED);
				current.setHeldState(HeldState.NONE);
			}
		}
		
		//target.setHeldState(HeldState.HOLD_BLUE);
		
	}
	
	
	
	
	public static void setHold(Hexagon6 target, HeldState setting) {
		
		target.setHeldState(setting);
		
	}
	
	
	
	public static void setHolds(ArrayList<Hexagon6> targets, HeldState setting) {
		
		for (Hexagon6 colorMe : targets)
		{
			colorMe.setHeldState( setting );
		}
		
	}
	
	
	
	
	
	
}




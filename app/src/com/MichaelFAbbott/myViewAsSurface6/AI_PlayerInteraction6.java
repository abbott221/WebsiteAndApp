package com.MichaelFAbbott.myViewAsSurface6;

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

import com.MichaelFAbbott.myViewAsSurface6.Actor.ActorType;
import com.MichaelFAbbott.myViewAsSurface6.Hexagon6.BlockState;
import com.MichaelFAbbott.myViewAsSurface6.Hexagon6.HeldState;
import com.MichaelFAbbott.myViewAsSurface6.Hexagon6.OccupantState;

import android.util.Log;



public class AI_PlayerInteraction6 {
	
	
	
	//all held states have been cleared (set to none)
	public static void playerSelectionEntry(Hexagon6 target, Board_Model6 model) {
		
		
		Hexagon6.HeldState hold = target.getHeldState();
    	Hexagon6.OccupantState occupy = target.getOccupantState();
		
    	
    	//target.setHeldState(HeldState.HOLD_BLUE);
    	
    	//IMPLEMENTATION 1
    	
    	/*
    	if (hold == HeldState.NONE && occupy == OccupantState.NONE) {
    		selectedEmptyTile(target, model);
    	}
    	
    	
    	if (hold == HeldState.HOLD_PURPLE) {
    		selectedPurpleTile(target, model);
    	}
    	if (hold == HeldState.HOLD_ORANGE) {
    		selectedYellowTile(target, model);
    	}
    	if ( AI_Hexagon6.occupantIsPortal(target) ) {
    		selectedPortalTile(target, model);
    	}
    	if ( AI_Hexagon6.occupantIsCreature(target) ) {
    		selectedCreatureTile(target, model);
    	}
    	/**/
    	
    	//END IMPLEMENTATION 1
    	
    	//clearTiles(target, model);
    	
    	

		//IMPLEMENTATION 2
		
		Actor occupant = target.getGrid().getOccupant( target.getRow(), target.getColumn() );
		
		//if (hold == HeldState.NONE && occupy == OccupantState.NONE) {
		
		/*
		if (occupant == null)
		{
			System.err.println("occupant is null");
		}
		else if (occupant != null)
		{
			System.err.println("occupant is not null");
		}
		/**/
		
		//IT MAY REGISTER AS "ACTOR" WHEN SUPPOSE TO BE NULL
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
    	/*
    	if ( AI_Hexagon6.occupantIsPortal(target) ) {
    		selectedPortalTile(target, model);
    	}
    	if ( AI_Hexagon6.occupantIsCreature(target) ) {
    		selectedCreatureTile(target, model);
    	}
    	/**/
    	
		
		//IMPLEMENTATION 2 END
		
	}
	
	
	
	
	
	/**/
	public static void selectedEmptyTile(Hexagon6 target, Board_Model6 model) {
		
		
		clearTiles(model);
		
		setHold(target, HeldState.HOLD_BLUE);
	}
	/**/
	
	
	
	
	public static void selectedPurpleTile(Hexagon6 target, Board_Model6 model) {
		
		ArrayList<Hexagon6> possibleMoves = AI_Hexagon6.getBlockNeighbors(target, model);
		
		
		//IMPLEMENTATION 1
		
		//target.setOccupantState(OccupantState.OCC_BEIGE);
		
		//END IMPLEMENTATION 1
		
		//IMPLEMENTATION 2
		
		//Actor newOccupant = new Actor_BeigeAlien( model.getContext() );
		//Actor newOccupant = null;
		Actor newOccupant = new Actor_BeigeAlien( model, target );
		
		model.setOccupant(target.getRow(), target.getColumn(), newOccupant);
		//END IMPLEMENTATION 2
		
		
		clearTiles(model);
		
		setHolds(possibleMoves, HeldState.HOLD_ORANGE);
		setHold(target, HeldState.HOLD_BLUE);
	}
	
	
	
	
	
	
	public static void selectedYellowTile(Hexagon6 target, Board_Model6 model) {
		
		ArrayList<Hexagon6> possibleMoves = AI_Hexagon6.getBlockNeighbors(target, model);
		
		
		
		
		
		//IMPLEMENTATION 2
		
		//Actor occupant = target.getGrid().getOccupant( target.getRow(), target.getColumn() );
		//Actor occupant = new Actor_BeigeAlien( model.getContext() );
		Actor occupant = null;
		
		
		Hexagon6 previous = null;
		
		try {
			previous = model.getPreviousSelected();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (previous != null) {
			//previous.setOccupantState(OccupantState.NONE);
			
			occupant = model.getOccupant( previous.getRow(), previous.getColumn() );
		}
		
		//target.setOccupantState(OccupantState.OCC_BEIGE);
		
		occupant.setLocation(target);
		
		//END IMPLEMENTATION 2
		
		
		clearTiles(model);
		
		setHolds(possibleMoves, HeldState.HOLD_ORANGE);
		setHold(target, HeldState.HOLD_BLUE);
	}
	
	
	
	
	
	public static void selectedPortalTile(Hexagon6 target, Board_Model6 model) {
		
		//get neighbors to be set
		ArrayList<Hexagon6> blocksByPortal = AI_Hexagon6.getBlockNeighbors(target, model);
		
		
		
		clearTiles(model);
		
		setHolds(blocksByPortal, HeldState.HOLD_PURPLE);
		setHold(target, HeldState.HOLD_BLUE);
	}
	
	
	
	
	public static void selectedCreatureTile(Hexagon6 target, Board_Model6 model) {
		
		ArrayList<Hexagon6> possibleMoves = AI_Hexagon6.getBlockNeighbors(target, model);
		
		//this is already set
		//target.setOccupantState(OccupantState.OCC_BEIGE);
		
		
		
		clearTiles(model);
		
		setHolds(possibleMoves, HeldState.HOLD_ORANGE);
		setHold(target, HeldState.HOLD_BLUE);
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




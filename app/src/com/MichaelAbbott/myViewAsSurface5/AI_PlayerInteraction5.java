package com.MichaelAbbott.myViewAsSurface5;

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

import com.MichaelAbbott.myViewAsSurface5.Hexagon5.BlockState;
import com.MichaelAbbott.myViewAsSurface5.Hexagon5.HeldState;
import com.MichaelAbbott.myViewAsSurface5.Hexagon5.OccupantState;

import android.util.Log;



public class AI_PlayerInteraction5 {
	
	
	
	//all held states have been cleared (set to none)
	public static void playerSelectionEntry(Hexagon5 target, Board_Model5 model) {
		
		
		Hexagon5.HeldState hold = target.getHeldState();
    	Hexagon5.OccupantState occupy = target.getOccupantState();
		
    	
    	//target.setHeldState(HeldState.HOLD_BLUE);
    	
    	
    	if (hold == HeldState.NONE && occupy == OccupantState.NONE) {
    		selectedEmptyTile(target, model);
    	}
    	
    	
    	if (hold == HeldState.HOLD_PURPLE) {
    		selectedPurpleTile(target, model);
    	}
    	if (hold == HeldState.HOLD_ORANGE) {
    		selectedYellowTile(target, model);
    	}
    	if ( AI_Hexagon5.occupantIsPortal(target) ) {
    		selectedPortalTile(target, model);
    	}
    	if ( AI_Hexagon5.occupantIsCreature(target) ) {
    		selectedCreatureTile(target, model);
    	}
    	
    	
    	//clearTiles(target, model);
		
	}
	
	
	
	
	
	/**/
	public static void selectedEmptyTile(Hexagon5 target, Board_Model5 model) {
		
		
		clearTiles(model);
		
		setHold(target, HeldState.HOLD_BLUE);
	}
	/**/
	
	
	
	
	public static void selectedPurpleTile(Hexagon5 target, Board_Model5 model) {
		
		ArrayList<Hexagon5> possibleMoves = AI_Hexagon5.getBlockNeighbors(target, model);
		
		target.setOccupantState(OccupantState.OCC_BEIGE);
		
		
		
		clearTiles(model);
		
		setHolds(possibleMoves, HeldState.HOLD_ORANGE);
		setHold(target, HeldState.HOLD_BLUE);
	}
	
	
	
	
	
	
	public static void selectedYellowTile(Hexagon5 target, Board_Model5 model) {
		
		ArrayList<Hexagon5> possibleMoves = AI_Hexagon5.getBlockNeighbors(target, model);
		
		target.setOccupantState(OccupantState.OCC_BEIGE);
		
		
		
		Hexagon5 previous = null;
		
		try {
			previous = model.getPreviousSelected();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (previous != null) {
			previous.setOccupantState(OccupantState.NONE);
		}
		
		
		
		clearTiles(model);
		
		setHolds(possibleMoves, HeldState.HOLD_ORANGE);
		setHold(target, HeldState.HOLD_BLUE);
	}
	
	
	
	
	
	public static void selectedPortalTile(Hexagon5 target, Board_Model5 model) {
		
		//get neighbors to be set
		ArrayList<Hexagon5> blocksByPortal = AI_Hexagon5.getBlockNeighbors(target, model);
		
		
		
		clearTiles(model);
		
		setHolds(blocksByPortal, HeldState.HOLD_PURPLE);
		setHold(target, HeldState.HOLD_BLUE);
	}
	
	
	
	
	public static void selectedCreatureTile(Hexagon5 target, Board_Model5 model) {
		
		ArrayList<Hexagon5> possibleMoves = AI_Hexagon5.getBlockNeighbors(target, model);
		
		//this is already set
		//target.setOccupantState(OccupantState.OCC_BEIGE);
		
		
		
		clearTiles(model);
		
		setHolds(possibleMoves, HeldState.HOLD_ORANGE);
		setHold(target, HeldState.HOLD_BLUE);
	}
	
	
	
	
	public static void clearTiles( Board_Model5 model ) {
		
		for (int i = 0; i < model.getRows(); i++) {
			for (int j = 0; j < model.getColumns(); j++) {
				Hexagon5 current = model.getHexagon(i, j);
				
				//current.setHighlighted(Hexagon5.SelectState.UNSELECTED);
				current.setHeldState(HeldState.NONE);
			}
		}
		
		//target.setHeldState(HeldState.HOLD_BLUE);
		
	}
	
	
	
	
	public static void setHold(Hexagon5 target, HeldState setting) {
		
		target.setHeldState(setting);
		
	}
	
	
	
	public static void setHolds(ArrayList<Hexagon5> targets, HeldState setting) {
		
		for (Hexagon5 colorMe : targets)
		{
			colorMe.setHeldState( setting );
		}
		
	}
	
	
	
	
	
	
}




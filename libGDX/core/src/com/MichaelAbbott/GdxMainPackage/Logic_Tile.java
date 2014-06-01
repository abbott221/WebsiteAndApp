package com.MichaelAbbott.GdxMainPackage;

import java.util.ArrayList;

import com.MichaelAbbott.GdxMainPackage.Actor.ActorType;
import com.MichaelAbbott.GdxMainPackage.Hexagon.CubeState;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Logic_Tile {
	
	
	
	
	public static Hexagon getClosestTile(Model_General model, float x, float y) {
		
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
	
	
	
	/**
	 * returns all valid neighbor hexagons
	 */
	public static ArrayList<Hexagon> getNeighbors(Hexagon test, Model_General model) {
		
		ArrayList<Hexagon> result = new ArrayList<Hexagon>();
		
		
		int myRow = test.getRow();
		int myColumn = test.getColumn();
		
		int maxR = model.getRows() - 1;
		int maxC = model.getColumns() - 1;
		
		//****************************************
		
		
		if ( myRow != 0 ) {
			
			//TopRight or TopLeft
			result.add( model.getHexagon(myRow - 1, myColumn) );
			
			//EVEN
			if (myRow % 2 == 0) {
				
				if ( myColumn != 0 ) {
					//TopLeft
					result.add( model.getHexagon(myRow - 1, myColumn - 1) );
				}
				
			}
			//ODD
			else {
				
				if ( myColumn != maxC ) {
					//TopRight
					result.add( model.getHexagon(myRow - 1, myColumn + 1) );
				}
				
			}
		}
		
		
		
		if ( myRow != maxR ) {
			
			//BottomRight or BottomLeft
			result.add( model.getHexagon(myRow + 1, myColumn) );
			
			//EVEN
			if (myRow % 2 == 0) {
				
				if ( myColumn != 0 ) {
					//BottomLeft
					result.add( model.getHexagon(myRow + 1, myColumn - 1) );
				}
				
			}
			//ODD
			else {
				
				if ( myColumn != maxC ) {
					//BottomRight
					result.add( model.getHexagon(myRow + 1, myColumn + 1) );
				}
			}
		}
		
		
		
		if ( myColumn != 0 ) {
			//Left
			result.add( model.getHexagon(myRow, myColumn - 1) );
		}
		if ( myColumn != maxC ) {
			//Right
			result.add( model.getHexagon(myRow, myColumn + 1) );
		}
		
		
		return result;
	}
	
	
	/**
	 * returns all neighbor hexagons that have a block
	 */
	public static ArrayList<Hexagon> getBlockNeighbors(Hexagon test, Model_General model) {
		
		ArrayList<Hexagon> result = getNeighbors(test, model);
		
		Hexagon temp;
		
		
		
		for (int i = result.size() - 1; i >= 0; i--) {
			temp = result.get(i);
			
			if (temp.getCubeState() == CubeState.NONE) {
				result.remove(temp);
			}
		}
		
		
		
		return result;
	}
	
	
	
	
	
	
	public static boolean occupantIsAlien(Model_General model, Hexagon tile) {
		boolean isAlien = false;
		
		//Actor occupant = test.getGrid().getOccupant( test.getRow(), test.getColumn() );
		Actor occupant = model.getOccupant(tile.getRow(), tile.getColumn());
		
		if (occupant != null) {
			if (occupant.getActorType() == ActorType.ALIEN) {
				isAlien = true;
			}
		}
		
		/*
		if (occupant.getActorType() == ActorType.ALIEN) {
			isAlien = true;
		}
		/**/
		
		return isAlien;
	}
	
	
	
}

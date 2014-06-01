package com.MichaelAbbott.GdxMainPackage;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Model_General {
	
	Mediator mediator;
	
	Model_Selection mod_select;
	
	
	
	public Hexagon[][] board;
	
	private Actor[][] occupantArray;
	private ArrayList<Player> players;
	
	
	
	//public Hexagon[][] board;
	private int boardR;
	private int boardC;
	
	private Hexagon previousTile;
	private Hexagon activeTile;
	private Hexagon pressedTile;
	
	private int touchRadius;
	
	
	
	
	
	public Model_General(Mediator med) {
		
		this.mediator = med;
		
		this.mod_select = new Model_Selection(med);
		
		
		this.board = new Hexagon[1][1];
		//Maps.map1(med, this);
		Maps.map2(med, this);
		
		
		
		this.previousTile = null;
		this.activeTile = null;
		this.pressedTile = null;
		
		this.touchRadius = 30;
		
	}
	
	public void registerMediator(Mediator caller) {
		mediator = caller;
		
		for (int i = 0; i < boardR; i++) {
			for (int j = 0; j < boardC; j++) {
				board[i][j].registerMediator(caller);
			}
		}
	}
	
	
	public Mediator getMediator() {
		return this.mediator;
	}
	
	
	
	
	public Model_Selection getMForSelection() {
		return this.mod_select;
	}
	
	
	
	
	public int getRows() {
		return this.boardR;
	}
	public void setRows(int newValue) {
		this.boardR = newValue;
	}
	public int getColumns() {
		return this.boardC;
	}
	public void setColumns(int newValue) {
		this.boardC = newValue;
	}
	
	
	
	public int getTouchRadius() {
		return this.touchRadius;
	}
	
	
	
	public Hexagon[][] getBoard() {
		return this.board;
	}
	public void setBoard(Hexagon[][] newValue) {
		this.board = newValue;
	}
	
	
	
	
	public Actor[][] getOccupantArray() {
		return this.occupantArray;
	}
	
	//called by maps
	public void setOccupantArray(Actor[][] newValue) {
		this.occupantArray = newValue;
	}
	
	
	public Actor getOccupant(int r, int c) {
		return this.occupantArray[r][c];
	}
	public void setOccupant(int r, int c, Actor newActor) {
		this.occupantArray[r][c] = newActor;
	}
	//using returned occupant is optional
	public Actor removeOccupant(int r, int c) {
		Actor removed = this.occupantArray[r][c];
		this.occupantArray[r][c] = null;
		return removed;
	}
	
	
	
	public Hexagon getHexagon(int r, int c) {
		return this.board[r][c];
	}
	
	
	
	
	public Hexagon getPressedTile() {
		return this.pressedTile;
	}
	public void setPressedTile(Hexagon newValue) {
		this.pressedTile = newValue;
	}
	
	public Hexagon getActiveTile() {
		return this.activeTile;
	}
	public void setActiveTile(Hexagon newValue) {
		this.activeTile = newValue;
	}
	
	public Hexagon getPreviousTile() {
		return this.pressedTile;
	}
	public void setPreviousTile(Hexagon newValue) {
		this.previousTile = newValue;
	}
	
	
}




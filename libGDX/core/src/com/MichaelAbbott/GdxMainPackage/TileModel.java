package com.MichaelAbbott.GdxMainPackage;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TileModel {
	
	Mediator mediator;
	
	
	
	public Hexagon[][] board;
	private int boardR;
	private int boardC;
	
	private Hexagon previousTile;
	private Hexagon activeTile;
	private Hexagon pressedTile;
	
	private int touchRadius;
	
	
	
	
	
	public TileModel(Mediator med) {
		
		this.mediator = med;
		
		
		this.board = new Hexagon[1][1];
		//Maps.map1(med, this);
		Maps.map2(med, this);
		
		
		
		this.previousTile = null;
		this.activeTile = null;
		this.pressedTile = null;
		
		this.touchRadius = 25;
		
	}
	
	public void registerMediator(Mediator caller) {
		mediator = caller;
		
		for (int i = 0; i < boardR; i++) {
			for (int j = 0; j < boardC; j++) {
				board[i][j].registerMediator(caller);
			}
		}
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




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
	
	
	
	
	
	public TileModel() {
		
		this.boardR = 4;
		this.boardC = 4;
		
		board = new Hexagon[boardR][boardC];
		
		for (int i = 0; i < boardR; i++) {
			for (int j = 0; j < boardC; j++) {
				board[i][j] = new Hexagon(mediator, i, j);
			}
		}
		
		
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
	public int getColumns() {
		return this.boardC;
	}
	
	public int getTouchRadius() {
		return this.touchRadius;
	}
	
	public Hexagon[][] getBoard() {
		return this.board;
	}
	
	
}




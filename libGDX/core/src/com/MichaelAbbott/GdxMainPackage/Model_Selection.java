package com.MichaelAbbott.GdxMainPackage;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Model_Selection {
	
	Mediator mediator;
	
	
	//private Hexagon previousTile;
	
	
	private Hexagon newActive;
	private Hexagon newPressed;
	
	private Hexagon oldActive;
	private Hexagon oldPressed;
	
	
	
	
	public Model_Selection(Mediator med) {
		
		this.mediator = med;
		
		this.newActive = null;
		this.newPressed = null;
		
		this.oldActive = null;
		this.oldPressed = null;
		
	}
	
	
	
	public Hexagon getNewActive() {
		return this.newActive;
	}
	public void setNewActive(Hexagon newValue) {
		this.newActive = newValue;
	}
	
	public Hexagon getNewPressed() {
		return this.newPressed;
	}
	public void setNewPressed(Hexagon newValue) {
		this.newPressed = newValue;
	}
	
	public Hexagon getOldActive() {
		return this.oldActive;
	}
	public void setOldActive(Hexagon newValue) {
		this.oldActive = newValue;
	}
	
	public Hexagon getOldPressed() {
		return this.oldPressed;
	}
	public void setOldPressed(Hexagon newValue) {
		this.oldPressed = newValue;
	}
	
	
	
}




package com.MichaelAbbott.GdxMainPackage;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
	
	public static enum PlayerColor {
		NONE, BLUE, GREEN, RED, WHITE, YELLOW
	}
	
	
	Mediator mediator;
	
	private PlayerColor myColor;
	
	
	private ArrayList<Actor> ownedOccupants;
	
	
	
	
	public Player(Mediator med) {
		
		this.mediator = med;
		
		this.myColor = PlayerColor.NONE;
		
		this.ownedOccupants = new ArrayList<Actor>();
	}
	
	public void registerMediator(Mediator med) {
		mediator = med;
		
	}
	
	
	
	
	
	public PlayerColor getColor() {
		return this.myColor;
	}
	public void setColor(PlayerColor newValue) {
		this.myColor = newValue;
	}
	
	
	public ArrayList<Actor> getOccupants() {
		return this.ownedOccupants;
	}
	public void setOccupants(ArrayList<Actor> input) {
		this.ownedOccupants = input;
	}
	
	
	public void addActor(Actor newActor) {
		this.ownedOccupants.add(newActor);
	}
	public void removeActor(Actor newActor) {
		this.ownedOccupants.remove(newActor);
	}
	/*
	public void setActor(Actor newActor) {
		this.ownedOccupants.remove(newActor);
	}
	/**/
	public boolean hasActor(Actor check) {
		return this.ownedOccupants.contains(check);
	}
	
	
}




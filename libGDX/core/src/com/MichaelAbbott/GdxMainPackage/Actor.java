package com.MichaelAbbott.GdxMainPackage;

import java.util.ArrayList;

import com.MichaelAbbott.GdxMainPackage.Hexagon.CubeState;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Actor {
	
	public static enum ActorType {
		NONE, PORTAL, ALIEN
	}
	
	
	Mediator mediator;
	
	private ActorType myActorType;
	
	private Hexagon location;
	
	private Player player;
	
	private Texture appearance;
	
	
	
	private float drawScale;
	private float drawX;
	private float drawY;
	
	private float drawWidth;
	private float drawHeight;
	
	
	
	private int maxHealth;
	private int currentHealth;
	
	private int maxEnergy;
	private int currentEnergy;
	
	private int range;
	private int power;
	
	private boolean canAttack;
	
	
	/*
	public Actor(Mediator med) {
		
		this.mediator = med;
		
		this.myActorType = ActorType.NONE;
		
		this.location = null;
		
		this.player = null;
		
		this.appearance = null;
		
		
		this.drawScale = 1.0f;
		this.drawX = 0;
		this.drawY = 0;
		this.drawWidth = 0;
		this.drawHeight = 0;
	}
	/**/
	
	
	public Actor() {
		
		//this.mediator = med;
		
		this.myActorType = ActorType.NONE;
		
		this.location = null;
		
		this.player = null;
		
		this.appearance = null;
		
		
		this.drawScale = 1.0f;
		this.drawX = 0;
		this.drawY = 0;
		this.drawWidth = 0;
		this.drawHeight = 0;
	}
	
	
	
	
	public void registerMediator(Mediator med) {
		mediator = med;
		
	}
	
	
	
	
	
	public ActorType getActorType() {
		return this.myActorType;
	}
	
	public void setActorType(ActorType newValue) {
		this.myActorType = newValue;
	}
	
	
	
	
	
	public Hexagon getLocation() {
		return this.location;
	}
	public void setLocation(Hexagon newValue) {
		this.location = newValue;
	}
	
	
	
	
	public void setAppearance(Texture newValue) {
		this.appearance = newValue;
	}
	
	
	
	public float getDrawScale() {
		return this.drawScale;
	}
	public void setDrawScale(float newValue) {
		this.drawScale = newValue;
	}
	public float getDrawX() {
		return this.drawX;
	}
	public void setDrawX(float newValue) {
		this.drawX = newValue;
	}
	public float getDrawY() {
		return this.drawY;
	}
	public void setDrawY(float newValue) {
		this.drawY = newValue;
	}
	
	/**/
	public float getDrawWidth() {
		return this.drawWidth;
	}
	public void setDrawWidth(float newValue) {
		this.drawWidth = newValue;
	}
	public float getDrawHeight() {
		return this.drawHeight;
	}
	public void setDrawHeight(float newValue) {
		this.drawHeight = newValue;
	}
	/**/
	
	
	/**/
	public void drawSelf()
	{
		
		SpriteBatch batch = mediator.view.batch;
		
		
		float left = this.getDrawX();
		float bottom = this.getDrawY();
		
		if (this.location != null) {
			left += this.getLocation().getCenterX();
			bottom += this.getLocation().getCenterY();
		}
		
		//float left = this.g;
		//float right;
		
		batch.draw(this.appearance, left, bottom, this.getDrawWidth(), this.getDrawHeight());
	}
	
	
	
}




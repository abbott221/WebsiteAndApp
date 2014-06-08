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
	
	private boolean canMove;
	
	
	
	
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
		
		//this.maxHealth = 0;
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
	public void setLocation(Hexagon newLocation) {
		
		Hexagon oldLocation = this.getLocation();
		if (oldLocation != null) {
			int oldRow = oldLocation.getRow();
			int oldColumn = oldLocation.getColumn();
			
			//this.getGrid().setOccupant(oldRow, oldColumn, null);
			this.mediator.model.setOccupant(oldRow, oldColumn, null);
			
			
			
			int newRow = newLocation.getRow();
			int newColumn = newLocation.getColumn();
			
			this.mediator.model.setOccupant(newRow, newColumn, this);
		}
		
		//int newRow = newLocation.getRow();
		//int newColumn = newLocation.getColumn();
		
		//this.getGrid().setOccupant(newRow, newColumn, this);
		//this.mediator.model.setOccupant(newRow, newColumn, this);
		
		this.location = newLocation;
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
		
		
		float translateX = left + mediator.listener.displacementX;
		float translateY = bottom + mediator.listener.displacementY;
		
		
		//batch.draw(this.appearance, left, bottom, this.getDrawWidth(), this.getDrawHeight());
		batch.draw(this.appearance, translateX, translateY, this.getDrawWidth(), this.getDrawHeight());
	}
	
	
	
	
	public int getMaxHealth() {
		return this.maxHealth;
	}
	public void setMaxHealth(int newValue) {
		this.maxHealth = newValue;
	}
	
	public int getCurrentHealth() {
		return this.currentHealth;
	}
	public void setCurrentHealth(int newValue) {
		this.currentHealth = newValue;
	}
	
	
	
	
	public int getMaxEnergy() {
		return this.maxEnergy;
	}
	public void setMaxEnergy(int newValue) {
		this.maxEnergy = newValue;
	}
	
	public int getCurrentEnergy() {
		return this.currentEnergy;
	}
	public void setCurrentEnergy(int newValue) {
		this.currentEnergy = newValue;
	}
	
	
	
	
	public int getRange() {
		return this.range;
	}
	public void setRange(int newValue) {
		this.range = newValue;
	}
	
	public int getPower() {
		return this.power;
	}
	public void setPower(int newValue) {
		this.power = newValue;
	}
	
	
	
	
	public boolean getCanAttack() {
		return this.canAttack;
	}
	public void setCanAttack(boolean newValue) {
		this.canAttack = newValue;
	}
	
	
}



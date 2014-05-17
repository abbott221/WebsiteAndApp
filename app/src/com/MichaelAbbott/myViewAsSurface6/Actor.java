package com.MichaelAbbott.myViewAsSurface6;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;


public class Actor {
    
	
	public static enum ActorType {
		NONE, PORTAL, ALIEN
	}
	
	
	private Board_Model6 grid;
	//private Grid<Actor> grid;
    private Hexagon6 location;
    
    private Player player;
    
    //similar to color
    private Bitmap appearance;
    
    
    private float drawScale;
    private float drawX;
    private float drawY;
    
    private float translateX;
    private float translateY;
    
    
    private ActorType myActorType;
    
    
    private int maxHealth;
    private int currentHealth;
    
    private int maxEnergy;
    private int currentEnergy;
    
    private int range;
    private int power;
    

    public Actor() {
        this.grid = null;
        this.location = null;
        
        this.player = null;
        
        this.appearance = null;
        
        this.drawScale = 1.0f;
        this.drawX = 0;
        this.drawY = 0;
        this.translateX = 0;
        this.translateY = 0;
        
        this.myActorType = ActorType.NONE;
    }
    
    
    
    
    public Bitmap getAppearance() {
        return this.appearance;
    }
    public void setAppearance(Bitmap newBitmap) {
        this.appearance = newBitmap;
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
    public float getTranslateX() {
        return this.translateX;
    }
    public void setTranslateX(float newValue) {
        this.translateX = newValue;
    }
    public float getTranslateY() {
        return this.translateY;
    }
    public void setTranslateY(float newValue) {
        this.translateY = newValue;
    }
    /**/
    
    public ActorType getActorType() {
        return this.myActorType;
    }
    public void setActorType(ActorType newValue) {
        this.myActorType = newValue;
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
    
    
    
    
    
    /**
     * Gets the grid in which this actor is located.
     * 
     * @return the grid of this actor, or <code>null</code> if this actor is not
     *         contained in a grid
     */
    public Board_Model6 getGrid() {
        return this.grid;
    }
    
    public void setGrid(Board_Model6 newGrid) {
        this.grid = newGrid;
    }

    /**
     * Gets the location of this actor.
     * 
     * @return the location of this actor, or <code>null</code> if this actor is
     *         not contained in a grid
     */
    public Hexagon6 getLocation() {
        return this.location;
    }
    
    // or moveTo
    public void setLocation(Hexagon6 newLocation) {
        
    	Hexagon6 oldLocation = this.getLocation();
    	if (oldLocation != null)
    	{
    		int oldRow = oldLocation.getRow();
        	int oldColumn = oldLocation.getColumn();
        	
        	this.getGrid().setOccupant(oldRow, oldColumn, null);
    	}
    	
    	
    	int newRow = newLocation.getRow();
    	int newColumn = newLocation.getColumn();
    	
    	
    	//this.getGrid().setOccupant(oldRow, oldColumn, null);
    	this.getGrid().setOccupant(newRow, newColumn, this);
    	
    	
    	this.location = newLocation;
    }
    
    
    
    
    
    
    
    
    //based on getLocation
    public Player getPlayer() {
        return this.player;
    }
    
    //based on setLocation - but it doesn't have related null handling?
    public void setPlayer(Player newPlayer) {
    	
    	/*
    	//perhaps this.player was still null, causing the error
    	if (newPlayer == null) {
    		this.player.removeActor(this);
    	}
    	/**/
    	
        this.player = newPlayer;
    }
    
    
    
    
    
    
    
    
    
    public void drawSelf_Occupant( Canvas canvas, Paint paintFill )
	{
		//canvas.save();
		
		

		//boolean isAPortal = false;
		
		
		//translateAndScale(canvas, myScale, scrollX, scrollY);
		
		
		//ASSUME METHOD CALL IS AFTER TRANSLATE AND SCALE
		
		
		
		
		canvas.translate( this.getTranslateX(), this.getTranslateY() );
		
		/*
		if (isAPortal) {
			canvas.scale(2, 2);
		}
		/**/
		canvas.scale(this.getDrawScale(), this.getDrawScale());
		
		
		
		canvas.drawBitmap(this.getAppearance(), this.getDrawX(), this.getDrawY(), paintFill);
		
		
		
	}
    
    
    
    
    
    
    
    
    /**
     * Puts this actor into a grid. If there is another actor at the given
     * location, it is removed. <br />
     * Precondition: (1) This actor is not contained in a grid (2)
     * <code>loc</code> is valid in <code>gr</code>
     * 
     * @param gr
     *            the grid into which this actor should be placed
     * @param loc
     *            the location into which the actor should be placed
     */
    public void putSelfInGrid(Board_Model6 gr, Hexagon6 loc) {
        if (this.grid != null) {
            throw new IllegalStateException(
                    "This actor is already contained in a grid.");
        }

        //Actor actor = gr.get(loc);
        //Actor actor = gr.getHexagon(loc.getRow(), loc.getColumn()).getOccupantState();
        Actor actor = gr.getOccupant(loc.getRow(), loc.getColumn());
        
        //if (actor != null) {
        //    actor.removeSelfFromGrid();
        //}
        
        //gr.put(loc, this);
        gr.setOccupant(loc.getRow(), loc.getColumn(), this);
        this.grid = gr;
        this.location = loc;
    }

    /**
     * Removes this actor from its grid. <br />
     * Precondition: This actor is contained in a grid
     */
    public void removeSelfFromGrid() {
        if (this.grid == null) {
            throw new IllegalStateException(
                    "This actor is not contained in a grid.");
        }
        /*
        if (this.grid.get(this.location) != this) {
            throw new IllegalStateException(
                    "The grid contains a different actor at location "
                            + this.location + ".");
        }
        /**/
        if (this.grid.getOccupant(this.location.getRow(), this.location.getColumn()) != this) {
            throw new IllegalStateException(
                    "The grid contains a different actor at location "
                            + this.location + ".");
        }

        //this.grid.remove(this.location);
        this.grid.removeOccupant(this.location.getRow(), this.location.getColumn());
        this.grid = null;
        this.location = null;
    }

    /**
     * Moves this actor to a new location. If there is another actor at the
     * given location, it is removed. <br />
     * Precondition: (1) This actor is contained in a grid (2)
     * <code>newLocation</code> is valid in the grid of this actor
     * 
     * @param newLocation
     *            the new location
     */
    public void moveTo(Hexagon6 newLocation) {
        if (this.grid == null) {
            throw new IllegalStateException("This actor is not in a grid.");
        }
        /*
        if (this.grid.get(this.location) != this) {
            throw new IllegalStateException(
                    "The grid contains a different actor at location "
                            + this.location + ".");
        }
        if (!this.grid.isValid(newLocation)) {
            throw new IllegalArgumentException("Location " + newLocation
                    + " is not valid.");
        }
        /**/

        if (newLocation.equals(this.location)) {
            return;
        }
        //this.grid.remove(this.location);
        this.grid.removeOccupant(this.location.getRow(), this.location.getColumn());
        //Actor other = this.grid.get(newLocation);
        Actor other = this.grid.getOccupant(newLocation.getRow(), newLocation.getColumn());
        if (other != null) {
            other.removeSelfFromGrid();
        }
        this.location = newLocation;
        //this.grid.put(this.location, this);
        this.grid.setOccupant(this.location.getRow(), this.location.getColumn(), this);
    }

    /**
     * Reverses the direction of this actor. Override this method in subclasses
     * of <code>Actor</code> to define types of actors with different behavior
     * 
     */
    public void act() {
        //this.setDirection(this.getDirection() + Location.HALF_CIRCLE);
    }
    
    
    
    
}
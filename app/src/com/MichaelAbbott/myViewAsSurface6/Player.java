package com.MichaelAbbott.myViewAsSurface6;




import java.util.ArrayList;


public class Player {
    
	
	public static enum PlayerColor {
		BLUE, GREEN, RED, WHITE, YELLOW
	}
	
	private PlayerColor myColor;
	
	
	private Board_Model6 grid;
    
    private ArrayList<Actor> ownedOccupants;
    
    
    

    public Player(PlayerColor color) {
        this.myColor = color;
    	
    	this.grid = null;
        
        //should it be initialized empty or just be null?
        this.ownedOccupants = new ArrayList<Actor>();
    }
    
    
    
    
    
    public Board_Model6 getGrid() {
        return this.grid;
    }
    
    public void setGrid(Board_Model6 newGrid) {
        this.grid = newGrid;
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
    
    
    
    //also have an endTurn()?
    //should this be in model?
    //add energy and stuffs
    public void beginTurn() {
    	//
    }
    
    
    
}
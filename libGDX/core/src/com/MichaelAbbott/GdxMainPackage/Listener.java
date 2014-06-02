package com.MichaelAbbott.GdxMainPackage;

import com.MichaelAbbott.GdxMainPackage.Hexagon.ActiveState;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Listener implements InputProcessor {
	
	Mediator mediator;
	
	
	
	
	public float displacementX;
	public float displacementY;
	
	//lastKnownX
	//startScrollX
	private float lastKnownX;
	private float lastKnownY;
	
	//newX
	//currentScrollX
	//possibly could've just been a local variable
	private float currentScrollX;
	private float currentScrollY;
	
	private boolean dragOccurred;
	
	
	public Listener() {
		displacementX = 0;
		displacementY = 0;
		
		dragOccurred = false;
	}
	
	public void registerMediator(Mediator caller) {
		mediator = caller;
	}
	
	
	
	
	
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		//System.out.println("Touch down detected");
		//System.out.println(screenX);
		//System.out.println(screenY);
		
		
		
		int libX = screenX;
		int libY =  540 - screenY;
		
		
		
		//lastKnownX = screenX;
		//lastKnownY = screenY;
		lastKnownX = libX;
		lastKnownY = libY;
		
		
		return true;
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		//System.out.println("Touch up detected");
		//System.out.println(screenX);
		//System.out.println(screenY);
		
		
		
		//only update the hexagon ActiveState info if there wasn't a drag event
		if (!dragOccurred) {
			
			int libX = screenX;
			int libY =  540 - screenY;
			
			
			
			float translateX = libX - mediator.listener.displacementX;
			float translateY = libY - mediator.listener.displacementY;
			
			
			Hexagon pressed = Logic_Tile.getClosestTile(mediator.model, translateX, translateY);
			
			
			
			
			//Logic_Selection call here
			Logic_Selection.pressOccurred(mediator.model, pressed);
		}
		else {
			dragOccurred = false;
		}
		
		
		
		
		
		
		/*
		mediator.model.setPressedTile(pressed);
		
		//if the user selected something on the grid
		if (pressed != null) {
			Logic_ActiveState.tilePressed(mediator, pressed);
		}
		/**/
		
		
		
		//System.out.println("Touch up detected");
		//System.out.println(screenX);
		//System.out.println(screenY);
		//System.out.println(displacementX);
		//System.out.println(displacementY);
		
		
		return true;
	}
	
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		
		int freshX = screenX;
		int freshY =  540 - screenY;
		
		
		
		
		//these are null/uncleared on first call to drag
		currentScrollX = freshX;
		currentScrollY = freshY;
		
		displacementX += currentScrollX - lastKnownX;
		displacementY += currentScrollY - lastKnownY;
		//displacements are finished updating
		//So, clear the currentScroll values to the lastKnown values
		lastKnownX = currentScrollX;
		lastKnownY = currentScrollY;
		
		
		dragOccurred = true;
		
		return true;
	}
	
	
	
	
	
	
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}

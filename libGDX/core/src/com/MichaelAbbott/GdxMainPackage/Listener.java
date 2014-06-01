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
	
	private float startScrollX;
	private float startScrollY;
	private float currentScrollX;
	private float currentScrollY;
	
	public Listener() {
		//
	}
	
	public void registerMediator(Mediator caller) {
		mediator = caller;
	}
	
	
	
	
	
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		int libY =  540 - screenY;
		int libX = screenX;
		
		//System.out.println("Touch down detected");
		//System.out.println(screenY);
		
		
		startScrollX = screenX;
		startScrollY = screenY;
		
		
		return true;
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		//System.out.println("Touch up detected");
		
		int libY =  540 - screenY;
		int libX = screenX;
		
		
		
		Hexagon pressed = Logic_Tile.getClosestTile(mediator.model, libX, libY);
		
		
		
		
		
		//Logic_Selection call here
		Logic_Selection.pressOccurred(mediator.model, pressed);
		
		
		
		
		
		/*
		mediator.model.setPressedTile(pressed);
		
		//if the user selected something on the grid
		if (pressed != null) {
			Logic_ActiveState.tilePressed(mediator, pressed);
		}
		/**/
		
		
		
		
		
		return true;
	}
	
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		int libY =  540 - screenY;
		int libX = screenX;
		
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

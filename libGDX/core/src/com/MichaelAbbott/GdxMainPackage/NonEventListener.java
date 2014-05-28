package com.MichaelAbbott.GdxMainPackage;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class NonEventListener {
	
	Mediator mediator;
	
	public NonEventListener() {
		//
	}
	
	public void registerMediator(Mediator caller) {
		mediator = caller;
	}
	
	
	public void checkInput() {
		
		if ( Gdx.input.isTouched() ) {
			
			//System.out.println("Touch detected");
			
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			
			mediator.view.camera.unproject(touchPos);
			
			//touchPos.x;
		}
		
	}
	
	
	
}

package com.MichaelAbbott.GdxMainPackage;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Mediator {
	
	public GeneralView view;
	
	//public NonEventListener oldListener;
	
	public Listener listener;
	
	public TileModel model;
	
	
	
	public Mediator() {
		
		model = new TileModel();
		model.registerMediator(this);
		
		
		
		view = new GeneralView();
		view.registerMediator(this);
		
		
		
		listener = new Listener();
		Gdx.input.setInputProcessor(listener);
		
		listener.registerMediator(this);
		
		
		//model = new TileModel();
		//model.registerMediator(this);
		
		
		
	}
	
	
	
}




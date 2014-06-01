package com.MichaelAbbott.GdxMainPackage;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Actor_BeigeAlien extends Actor {
	
	
	public Actor_BeigeAlien(Mediator med) {
		
		
		commonPart(med);
	}
	
	
	
	public Actor_BeigeAlien(Mediator med, Hexagon loc) {
		
		this.setLocation(loc);
		
		commonPart(med);
	}
	
	
	public void commonPart(Mediator med) {
		
		
		//super(med);
		//this.mediator = med;
		this.registerMediator(med);
		
		Texture texture = new Texture("alien_beige.png");
		this.setAppearance(texture);
		//this.appearance = new Texture("demo_grass.png");
		
		
		//float top = occBeige.getHeight() / 2;
		//float top = texture.getHeight();
		float width = texture.getWidth();
		float height = texture.getHeight();
		
		this.setDrawWidth(width);
		this.setDrawHeight(height);
		
		
		float left = width / 2;
		//float bottom = height / 2;
		float bottom = 10;
		
		this.setDrawScale(1.0f);
		this.setDrawX(-1 * left);
		this.setDrawY(-1 * bottom);
		
		//this.setTranslateY(-60);
		//this.setTranslateX(0);
		
		
		
		this.setActorType(ActorType.ALIEN);
	}
	
	
}




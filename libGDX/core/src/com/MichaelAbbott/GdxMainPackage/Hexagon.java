package com.MichaelAbbott.GdxMainPackage;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Hexagon {
	
	
	public static enum CubeState {
		NONE, DIRT, GRASS, SAND
	}
	
	public static enum ActiveState {
		NONE, BLUE, PURPLE, YELLOW, RED
	}
	
	
	public Mediator mediator;
	
	
	private CubeState cubeState;
	private ActiveState activeState;
	
	private int row;
	private int column;
	
	private float centerX;
	private float centerY;
	
	//private float canvasX;
	//private float canvasY;
	
	
	
	public Hexagon() {
		//
	}
	
	public Hexagon(Mediator med, int r, int c, CubeState newCube) {
		this.mediator = med;
		
		this.row = r;
		this.column = c;
		
		this.cubeState = newCube;
		
		centerX = c * 192 + 150;
		
		if (r % 2 != 0) //if odd
		{
			centerX += 96;
		}
		
		centerY = r * 145 + 150;
	}
	
	public Hexagon(Mediator med, int r, int c) {
		this.mediator = med;
		
		this.row = r;
		this.column = c;
		
		
		
		
		centerX = c * 192 + 150;
		
		if (r % 2 != 0) //if odd
		{
			centerX += 96;
		}
		
		centerY = r * 145 + 150;
		
		
		
		this.activeState = ActiveState.BLUE;
	}
	
	
	
	
	public void registerMediator(Mediator caller) {
		mediator = caller;
	}
	
	
	
	public void setMyColor() {
		//
	}
	
	
	
	
	public void drawHexagon() {
		
		ShapeRenderer shapes = mediator.view.shapes;
		float[] verts = mediator.view.verts;
		
		
		
		//shapes.translate(x, y, 0);
		shapes.translate(centerX, centerY, 0);
		
		shapes.scale(0.9f, 0.9f, 1.0f);
		
		
		
		shapes.triangle(0, 0, verts[0], verts[1], verts[10], verts[11]);
		
		for (int i = 0; i < 5; i++) {
			shapes.triangle(0, 0, verts[2*i], verts[2*i + 1], verts[2*i + 2], verts[2*i + 3]);
		}
		
		
		
		shapes.scale(1/0.9f, 1/0.9f, 1.0f);
		
		//shapes.translate(-x, -y, 0);
		shapes.translate(-centerX, -centerY, 0);
		
		
		
	}
	
	
	
}






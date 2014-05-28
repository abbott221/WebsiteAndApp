package com.MichaelAbbott.GdxMainPackage;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
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
		
		
		
		
		int xSpacing = 80;
		int ySpacing = 90;
		//int xSpacing = 65;
		//int ySpacing = 50;
		
		
		
		//centerX = c * 192 + 150;
		centerX = c * xSpacing + 150;
		
		if (r % 2 != 0) //if odd
		{
			centerX += (xSpacing / 2.0f);
		}
		
		//centerY = r * 145 + 150;
		centerY = r * ySpacing + 150;
		
		
		
		this.activeState = ActiveState.BLUE;
	}
	
	
	
	
	public void registerMediator(Mediator caller) {
		mediator = caller;
	}
	
	
	
	public float getCenterX() {
		return this.centerX;
	}
	public float getCenterY() {
		return this.centerY;
	}
	
	
	public float getRow() {
		return this.row;
	}
	public float getColumn() {
		return this.column;
	}
	
	
	
	/**/
	public ActiveState getActiveState() {
		return this.activeState;
	}
	public void setActiveState(ActiveState newValue) {
		this.activeState = newValue;
	}
	/**/
	
	
	//only call within this class for drawing
	private void setMyColor(ShapeRenderer shapes) {
		
		if (activeState == null) {
			//
		}
		else if (activeState == ActiveState.NONE) {
			//
		}
		else if (activeState == ActiveState.BLUE) {
			shapes.setColor(Color.BLUE);
			//System.out.println("blue");
		}
		else if (activeState == ActiveState.PURPLE) {
			shapes.setColor(Color.DARK_GRAY);
		}
		
		if (activeState == ActiveState.YELLOW) {
			shapes.setColor(Color.YELLOW);
			//System.out.println("yellow");
		}
		else if (activeState == ActiveState.RED) {
			shapes.setColor(Color.RED);
		}
		
		
		//System.out.println("entered");
		//shapes.setColor(Color.BLUE);
	}
	
	
	public void printStuff() {
		//String out = shapes.getColor().toString();
		System.out.println( this.getActiveState().toString() );
	}
	
	
	
	public void drawHexagon(ShapeRenderer shapes) {
		
		//ShapeRenderer shapes = mediator.view.shapes;
		float[] verts = mediator.view.verts;
		
		
		setMyColor(shapes);
		
		
		shapes.translate(centerX, centerY, 0);
		
		//shapes.scale(0.9f, 0.9f, 1.0f);
		
		
		
		shapes.triangle(0, 0, verts[0], verts[1], verts[10], verts[11]);
		
		for (int i = 0; i < 5; i++) {
			shapes.triangle(0, 0, verts[2*i], verts[2*i + 1], verts[2*i + 2], verts[2*i + 3]);
		}
		
		
		
		//String out = shapes.getColor().toString();
		//System.out.println(out);
		
		
		
		//shapes.scale(1/0.9f, 1/0.9f, 1.0f);
		
		shapes.translate(-centerX, -centerY, 0);
		
		
		
	}
	
	
	
	public void drawBlock() {
		
		if (mediator == null) {
			System.out.println("mediator");
		}
		if (mediator.view == null) {
			System.out.println("view");
		}
		if (mediator.view.batch == null) {
			System.out.println("batch");
		}
		
		
		SpriteBatch batch = mediator.view.batch;
		Texture block_grass = mediator.view.block_grass;
		
		float left = centerX - (32.5f); // 65/2 = 32.5
		float bottom = centerY - (44.5f); // 89/2 = 44.5
		
		bottom -= 10f;
		
		batch.draw(block_grass, left, bottom, 65, 89);
		
	}
	
	
	
}






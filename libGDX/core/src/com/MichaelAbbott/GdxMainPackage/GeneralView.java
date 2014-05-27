package com.MichaelAbbott.GdxMainPackage;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GeneralView {
	
	Mediator mediator;
	
	
	OrthographicCamera camera;
	
	ShapeRenderer shapes;
	float[] verts;
	
	SpriteBatch batch;
	
	Texture img;
	Texture block_grass;
	
	
	
	public GeneralView() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 960, 540);
		
		shapes = new ShapeRenderer();
		//shapes.setToOrtho(false, 960, 540);
		
		batch = new SpriteBatch();
		
		img = new Texture("badlogic.jpg");
		block_grass = new Texture("demo_grass.png");
		
		
		double angle = (1.0 / 12.0) * 2.0 * Math.PI;
		float tempX = 0;
		float tempY = 0;
		
		verts = new float[12];
		
		int rad = 0;
		for (int i = 0; i < 6; i++) {
			rad = i * 2 + 1;
			angle = (rad / 12.0) * 2.0 * Math.PI;
			
			//tempX = (float) (Math.cos(angle) * 112.0);
			//tempY = (float) (Math.sin(angle) * 97.0);
			tempX = (float) (Math.cos(angle) * 36.0);
			tempY = (float) (Math.sin(angle) * 31.5);
			
			verts[2*i] = tempX;
			verts[2*i + 1] = tempY;
		}
		
		
	}
	
	public void registerMediator(Mediator caller) {
		mediator = caller;
	}
	
	
	
	
	public void draw() {
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		
		
		
		int myRows = 4;
		int myColumns = 4;
		Hexagon[][] board = new Hexagon[ myRows ][ myColumns ];
		
		for (int i = 0; i < myRows; i++) {
			for (int j = 0; j < myColumns; j++) {
				board[i][j] = new Hexagon(mediator, i, j);
			}
		}
		
		
		
		/*
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		
		//batch.draw(img, 0, 0);
		//draw hexagon blocks here
		batch.draw(block_grass, 0, 0);
		
		batch.end();
		/**/
		
		
		
		
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		
		//batch.draw(img, 0, 0);
		//draw hexagon blocks here
		//batch.draw(block_grass, 0, 0);
		
		/*
		for (int i = 0; i < myRows; i++) {
			for (int j = 0; j < myColumns; j++) {
				board[i][j].drawBlock();
			}
		}
		/**/
		
		for (int i = (myRows - 1); i >= 0; i--) {
			for (int j = (myColumns - 1); j >= 0; j--) {
				board[i][j].drawBlock();
			}
		}
		
		batch.end();
		
		
		
		
		
		shapes.setProjectionMatrix(camera.combined);
		
		shapes.begin(ShapeType.Filled);
		shapes.setColor(Color.BLUE);
		
		//shapes.scale(0.9f, 0.9f, 1.0f);
		
		//drawHexagon(100, 100);
		
		/*
		for (int i = 0; i < myRows; i++) {
			for (int j = 0; j < myColumns; j++) {
				board[i][j].drawHexagon();
			}
		}
		/**/
		
		for (int i = (myRows - 1); i >= 0; i--) {
			for (int j = (myColumns - 1); j >= 0; j--) {
				board[i][j].drawHexagon();
			}
		}
		
		shapes.end();
		
		
		
		
		/*
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		
		//batch.draw(img, 0, 0);
		//draw hexagon blocks here
		//batch.draw(block_grass, 0, 0);
		
		for (int i = 0; i < myRows; i++) {
			for (int j = 0; j < myColumns; j++) {
				board[i][j].drawBlock();
			}
		}
		
		batch.end();
		/**/
		
	}
	
	
	
}

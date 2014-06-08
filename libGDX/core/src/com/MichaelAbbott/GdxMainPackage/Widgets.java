package com.MichaelAbbott.GdxMainPackage;

import javax.swing.plaf.ProgressBarUI;

import com.MichaelAbbott.GdxMainPackage.Actor.ActorType;
import com.MichaelAbbott.GdxMainPackage.Hexagon.ActiveState;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class Widgets {
	
	Mediator mediator;
	
	
	
	private Skin skin;
	
	ProgressBar leftTop;
	ProgressBar leftBottom;
	
	ProgressBar rightTop;
	ProgressBar rightBottom;
	
	
	Label leftTopLabel;
	Label leftBottomLabel;
	
	Label rightTopLabel;
	Label rightBottomLabel;
	
	boolean leftShown;
	boolean rightShown;
	
	Label playerLabel;
	
	
	
	
	public TextButton turnButton;
	
	boolean buttonDown;
	
	
	
	
	//Stage stage;
	
	
	public Widgets() {
		
		//stage = new Stage();
		//Gdx.input.setInputProcessor(stage);
		
		
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		
		leftShown = true;
		rightShown = true;
		
		float labelTopRow = 70;
		float labelBottomRow = 30;
		float pbTopRow = 60;
		float pbBottomRow = 20;
		
		float screenWidth = 960;
		float barWidth = 350;
		float margin = 30;
		
		float leftSide = margin;
		float rightSide = screenWidth - (margin + barWidth); //630 = 960 - (300 + 30)
		
		
		
		leftTop = new ProgressBar(0, 100, 1, false, skin);
		leftTop.setBounds(leftSide, pbTopRow, barWidth, 0);
		
		leftBottom = new ProgressBar(0, 100, 1, false, skin);
		leftBottom.setBounds(leftSide, pbBottomRow, barWidth, 0);
		
		rightTop = new ProgressBar(0, 100, 1, false, skin);
		rightTop.setBounds(rightSide, pbTopRow, barWidth, 0);
		
		rightBottom = new ProgressBar(0, 100, 1, false, skin);
		rightBottom.setBounds(rightSide, pbBottomRow, barWidth, 0);
		
		
		
		leftTopLabel = new Label("Player 1 Health", skin);
		leftTopLabel.setPosition(leftSide, labelTopRow);
		
		leftBottomLabel = new Label("Player 1 Energy", skin);
		leftBottomLabel.setPosition(leftSide, labelBottomRow);
		
		rightTopLabel = new Label("Player 2 Health", skin);
		rightTopLabel.setPosition(rightSide, labelTopRow);
		
		rightBottomLabel = new Label("Player 2 Energy", skin);
		rightBottomLabel.setPosition(rightSide, labelBottomRow);
		
		
		
		
		leftTop.setValue(70.0f);
		leftBottom.setValue(70.0f);
		rightTop.setValue(70.0f);
		rightBottom.setValue(70.0f);
		
		//toggleLeft(false);
		
		//visibility
		//max value, min value, current value
		
		//active tile is player 1
		
		
		playerLabel = new Label("It is Player 1's turn", skin);
		//playerLabel.setPosition(800, 500);
		//x, y
		playerLabel.setPosition(780, 500);
		//playerLabel.setPosition(50, 500);
		
		
		
		turnButton = new TextButton("End Turn", skin);
		turnButton.setPosition(780, 450);
		turnButton.setSize(100, 40);
		
		buttonDown = false;
		
		//turnButton.
		
		
		/*
		turnButton.addListener(new ChangeListener() {
			
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				// TODO Auto-generated method stub
				System.out.println("changed");
			}
			
		});
		/**/
		
		
		//turnButton.g
		/*
		turnButton.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				
				//process down event
				//System.out.println("down");
				
				return true;
			}
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				
				//process up event
				//System.out.println("up");
				
				//return true;
			}
		});
		/**/
		//stage.addActor(turnButton);
	}
	
	
	
	public void registerMediator(Mediator caller) {
		mediator = caller;
	}
	
	
	
	
	public void drawWidgets() {
		
		
		SpriteBatch batch = mediator.view.batch;
		
		if (leftShown) {
			leftTopLabel.draw(batch, 1.0f);
			leftBottomLabel.draw(batch, 1.0f);
			
			
			leftTop.draw(batch, 1.0f);
			leftBottom.draw(batch, 1.0f);
		}
		
		
		if (rightShown) {
			rightTopLabel.draw(batch, 1.0f);
			rightBottomLabel.draw(batch, 1.0f);
			
			
			rightTop.draw(batch, 1.0f);
			rightBottom.draw(batch, 1.0f);
		}
		
		
		playerLabel.draw(batch, 1.0f);
		
		turnButton.draw(batch, 1.0f);
		
		
		
		/**/
		boolean justTouched = Gdx.input.justTouched();
		boolean touched = Gdx.input.isTouched();
		
		if (touched) {
			
			int firstX = Gdx.input.getX();
			int firstY = 540 - Gdx.input.getY();
			
			//turnButton.toggle();
			
			//process up here or in else statements?
			
			//System.out.println("just touched");
			
			//System.out.println(firstX);
			//System.out.println(firstY);
			
			if (firstY > 450 && firstY < 490) {
				if (firstX > 780 && firstX < 880) {
					//down
					//System.out.println("just touched");
					
					//batch.draw((Texture) turnButton.getStyle().down, 780, 450, 100, 40);
					
					if (buttonDown == false) {
						freshButtonPress();
					}
					
					buttonDown = true;
					turnButton.getStyle().down.draw(batch, 780, 450, 100, 40);
					
					//turnButton.toggle();
				}
				else {
					//up
					buttonDown = false;
					turnButton.draw(batch, 1.0f);
				}
			}
			else {
				//up
				buttonDown = false;
				turnButton.draw(batch, 1.0f);
			}
			
		}
		else {
			/*
			//batch.draw((Texture) turnButton.getStyle().up, 780, 450, 100, 40);
			//turnButton.draw(batch, 1.0f);
			turnButton.getStyle().up.draw(batch, 780, 450, 100, 40);
			//turnButton.getStyle().font.draw(batch, "End Turn", 780, 450);
			int regionX = turnButton.getStyle().font.getRegion().getRegionX();
			int regionY = turnButton.getStyle().font.getRegion().getRegionY();
			turnButton.getStyle().font.draw(batch, "End Turn", regionX, regionY);
			/**/
			buttonDown = false;
			turnButton.draw(batch, 1.0f);
			
		}
		/**/
		
	}
	
	
	
	public void freshButtonPress() {
		//leftShown = visible;
		System.out.println("fresh button press");
		
	}
	
	
	
	public void toggleLeft(boolean visible) {
		leftShown = visible;
	}
	
	public void toggleRight(boolean visible) {
		rightShown = visible;
		
		//rightTop.setVisible(visible);
		//rightBottom.setVisible(visible);
	}
	
	
	
	
	public void updateLeftTop(int current, int max) {
		leftTop.setRange(0.0f, max);
		leftTop.setValue(current);
	}
	public void updateLeftBottom(int current, int max) {
		leftBottom.setRange(0.0f, max);
		leftBottom.setValue(current);
	}
	public void updateRightTop(int current, int max) {
		rightTop.setRange(0.0f, max);
		rightTop.setValue(current);
	}
	public void updateRightBottom(int current, int max) {
		rightBottom.setRange(0.0f, max);
		rightBottom.setValue(current);
	}
	
	
	
	
}



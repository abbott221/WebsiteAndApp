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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

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
	
	
	public Widgets() {
		
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		
		
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
		//leftTop.setX(leftSide);
		//leftTop.setY(pbTopRow);
		//leftTop.setSize(barWidth, 0);
		leftTop.setBounds(leftSide, pbTopRow, barWidth, 0);
		
		
		leftBottom = new ProgressBar(0, 100, 1, false, skin);
		//leftBottom.setX(leftSide);
		//leftBottom.setY(pbBottomRow);
		//leftBottom.setSize(barWidth, 0);
		leftBottom.setBounds(leftSide, pbBottomRow, barWidth, 0);
		
		
		rightTop = new ProgressBar(0, 100, 1, false, skin);
		//rightTop.setX(rightSide);
		//rightTop.setY(pbTopRow);
		//rightTop.setSize(barWidth, 0);
		rightTop.setBounds(rightSide, pbTopRow, barWidth, 0);
		
		
		rightBottom = new ProgressBar(0, 100, 1, false, skin);
		//rightBottom.setX(rightSide);
		//rightBottom.setY(pbBottomRow);
		//rightBottom.setSize(barWidth, 0);
		rightBottom.setBounds(rightSide, pbBottomRow, barWidth, 0);
		
		
		
		
		leftTopLabel = new Label("Player 1 Health", skin);
		//leftTopLabel.setX(leftSide);
		//leftTopLabel.setY(labelTopRow);
		leftTopLabel.setPosition(leftSide, labelTopRow);
		
		
		leftBottomLabel = new Label("Player 1 Energy", skin);
		//leftBottomLabel.setX(leftSide);
		//leftBottomLabel.setY(labelBottomRow);
		leftBottomLabel.setPosition(leftSide, labelBottomRow);
		
		
		rightTopLabel = new Label("Player 2 Health", skin);
		//rightTopLabel.setX(rightSide);
		//rightTopLabel.setY(labelTopRow);
		rightTopLabel.setPosition(rightSide, labelTopRow);
		
		
		rightBottomLabel = new Label("Player 2 Energy", skin);
		//rightBottomLabel.setX(rightSide);
		//rightBottomLabel.setY(labelBottomRow);
		rightBottomLabel.setPosition(rightSide, labelBottomRow);
		
		
	}
	
	
	
	public void registerMediator(Mediator caller) {
		mediator = caller;
	}
	
	
	
	
	public void drawWidgets() {
		
		SpriteBatch batch = mediator.view.batch;
		
		
		leftTopLabel.draw(batch, 1.0f);
		leftBottomLabel.draw(batch, 1.0f);
		
		rightTopLabel.draw(batch, 1.0f);
		rightBottomLabel.draw(batch, 1.0f);
		
		
		
		leftTop.setValue(50.0f);
		
		
		leftTop.draw(batch, 1.0f);
		leftBottom.draw(batch, 1.0f);
		
		rightTop.draw(batch, 1.0f);
		rightBottom.draw(batch, 1.0f);
		
		//first.draw(batch, 1.0f);
	}
	
	
	
}



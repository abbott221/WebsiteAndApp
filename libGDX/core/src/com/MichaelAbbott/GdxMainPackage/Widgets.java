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
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Widgets {
	
	Mediator mediator;
	
	
	//OrthographicCamera camera;
	
	//ShapeRenderer shapes;
	//float[] verts;
	
	//SpriteBatch batch;
	
	//Texture img;
	//Texture block_grass;
	
	private Skin skin;
	private ProgressBar.ProgressBarStyle pbStyle;
	private ProgressBar.ProgressBarStyle style;
	
	
	ProgressBar first;
	
	
	public Widgets() {
		
		
		//skin = new Skin();
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		
		/*
		//BEGIN
		
		//store a white texture called "white"
		Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("white", new Texture(pixmap));
		
		//store default libgdx font as "default"
		skin.add("default", new BitmapFont());
		
		
		style = new ProgressBar.ProgressBarStyle();
		style.background = skin.newDrawable("white", Color.DARK_GRAY);
		
		skin.add("default", style);
		
		//END
		/**/
		
		
		
		
		first = new ProgressBar(0, 100, 1, false, skin);
		
		first.setX(50);
		first.setY(50);
		first.setSize(300, 0);
		
		
		
		
		
		
		/*
		
		//block_grass = new Texture("demo_grass.png");
		
		ProgressBarStyle style = new ProgressBar.ProgressBarStyle();
		
		pbStyle = skin.get("default-horizontal", ProgressBar.ProgressBarStyle.class);
		
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		
		first = new ProgressBar(0, 100, 1, false, skin);
		//first = new ProgressBar(0, 100, 1, false, style);
		
		//last parameter is either skin or style
		//first = new ProgressBar(0, 100, 1, false, style);
		//first = new ProgressBar(0, 0, 0, false, null);
		
		first.setX(10);
		first.setY(10);
		first.setSize(100, 10);
		
		//first = new ProgressBar();
		
		//first = new ProgressBar(0, 0, 0, false, null, null);
		
		/**/
		
	}
	
	public void registerMediator(Mediator caller) {
		mediator = caller;
	}
	
	
	
	
	public void drawWidgets() {
		
		SpriteBatch batch = mediator.view.batch;
		
		//batch.draw(block_grass, translateX, translateY, 65, 89);
		
		//batch.draw(first, 1.0f);
		
		first.draw(batch, 1.0f);
		
	}
	
	
	
}



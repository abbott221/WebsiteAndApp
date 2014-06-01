package com.MichaelAbbott.GdxMainPackage.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.MichaelAbbott.GdxMainPackage.GdxMainClass;

public class MyDesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.height = 540;
		config.width = 960;
		
		new LwjglApplication(new GdxMainClass(), config);
	}
}

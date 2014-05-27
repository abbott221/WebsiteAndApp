package com.MichaelAbbott.GdxMainPackage.desktop;

import com.MichaelAbbott.GdxMainPackage.GdxMainClass;
import com.badlogic.gdx.backends.lwjgl.LwjglApplet;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;


public class HelloWorldApplet extends LwjglApplet
{
    private static final long serialVersionUID = 1L;
    public HelloWorldApplet()
    {
        super(new GdxMainClass());
        //LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        //new LwjglApplet(new GdxMainClass(), config);
    }
}
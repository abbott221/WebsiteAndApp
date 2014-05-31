package com.MichaelAbbott.GdxMainPackage.desktop;

import com.MichaelAbbott.GdxMainPackage.GdxMainClass;
import com.badlogic.gdx.backends.lwjgl.LwjglApplet;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopApplet extends LwjglApplet {
private final static LwjglApplicationConfiguration DEFAULT_CONFIG =
    new LwjglApplicationConfiguration() {
    {
        width = 960;
        height = 540;
    }
};

public DesktopApplet() {
    super(new GdxMainClass(), DEFAULT_CONFIG);
}

private static final long serialVersionUID = 1L;
}

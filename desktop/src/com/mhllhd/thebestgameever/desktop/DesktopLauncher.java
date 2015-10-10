package com.mhllhd.thebestgameever.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mhllhd.thebestgameever.MainGameClass;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Hackathon Game";
		config.useGL30 = true;
        config.width = MainGameClass.WIDTH;
        config.height = MainGameClass.HEIGHT;
        new LwjglApplication(new MainGameClass(), config);
	}
}

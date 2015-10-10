package com.mhllhd.thebestgameever.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.mhllhd.thebestgameever.MainGameClass;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(MainGameClass.WIDTH, MainGameClass.HEIGHT);
        }

        @Override
        public ApplicationListener getApplicationListener () {
                return new MainGameClass();
        }
}
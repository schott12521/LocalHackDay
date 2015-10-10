package com.mhllhd.thebestgameever;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import screen.Screen;
import screen.ScreenManager;

/**
 * This should be the root game class. Are we commited? Yes!
 */
public class MainGameClass extends ApplicationAdapter {
	SpriteBatch batch;

    public static int WIDTH = 800, HEIGHT = 480;
    private Texture texture;
    private Sprite sprite;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("littleGuy.png"));
        sprite = new Sprite(texture);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (ScreenManager.getCurrentScreen() != null) {
            ScreenManager.getCurrentScreen().render(batch);
        }

        batch.begin();
        sprite.draw(batch);
        batch.end();

	}

    @Override
    public void dispose() {
        if (ScreenManager.currentScreen != null) {
            ScreenManager.getCurrentScreen().dispose();
        }
        texture.dispose();
        batch.dispose();
    }

    public void reize() {
        if (ScreenManager.getCurrentScreen() != null) {
            ScreenManager.getCurrentScreen().resize(WIDTH, HEIGHT);
        }
    }

    @Override
    public void pause() {
        if (ScreenManager.getCurrentScreen() != null) {
            ScreenManager.getCurrentScreen().pause();
        }
    }

    @Override
    public void resume() {
        if (ScreenManager.getCurrentScreen() != null) {
            ScreenManager.getCurrentScreen().resume();
        }
    }
}

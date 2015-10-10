package com.mhllhd.thebestgameever;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import entities.Boss;
import entities.Player;
import entities.Bullet;
import screen.ScreenManager;

/**
 * This should be the root game class. Are we commited? Yes!
 */
public class MainGameClass extends ApplicationAdapter {
	SpriteBatch batch;

    public static int WIDTH = 800 * 3 / 2, HEIGHT = 480 * 3 / 2;
    private Player mainCharacter;
    private Boss boss;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        mainCharacter = new Player(batch);
        boss = new Boss(batch);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (ScreenManager.getCurrentScreen() != null) {
            ScreenManager.getCurrentScreen().render(batch);
        }

        mainCharacter.move();
        boss.update(false);

        batch.begin();
        drawBackground(batch);
        batch.draw(mainCharacter.getSprite(), mainCharacter.getxPos(), mainCharacter.getyPos(), 100, 100);
        for (int i = 0; i < mainCharacter.bulletArrayList.size(); i++) {
            Bullet temp = ((Bullet) mainCharacter.bulletArrayList.get(i));
            temp.update();
            batch.draw(temp.getSprite(), temp.getxPos() + 25, temp.getyPos() + 25, 50, 50);
        }
//        batch.draw(boss.getSprite(), boss.getxPos(), boss.getyPos());
        boss.getSprite().draw(batch);
        batch.end();

	}

    public void drawBackground(SpriteBatch batch) {
        Texture frontWall = new Texture(Gdx.files.internal("frontWall.png"));
        Texture backWall = new Texture(Gdx.files.internal("backWall.png"));
        Texture floor = new Texture(Gdx.files.internal("floor.png"));
        Texture leftWall = new Texture(Gdx.files.internal("leftWall.png"));
        Texture rightWall = new Texture(Gdx.files.internal("rightwall.png"));
        Texture corner = new Texture(Gdx.files.internal("corner.png"));

        Sprite frontWallSprite = new Sprite(frontWall);
        Sprite backWallSprite = new Sprite(backWall);
        Sprite floorSprite = new Sprite(floor);
        Sprite leftWallSprite = new Sprite(leftWall);
        Sprite rightWallSprite = new Sprite(rightWall);
        Sprite cornerSprite = new Sprite(corner);


        for (int i = 0; i < WIDTH; i += 32) {
            for (int j = 0; j < HEIGHT; j += 32)
                batch.draw(floorSprite, i, j);
        }
        for (int i = 0; i < WIDTH; i += 32) {
            batch.draw(backWallSprite, i, HEIGHT - 64);
            batch.draw(frontWallSprite, i, 0);
        }
        for (int i = 0; i < HEIGHT; i += 32) {
            batch.draw(leftWallSprite, 0, i);
            batch.draw(rightWallSprite, WIDTH - 64, i);
        }
        batch.draw(cornerSprite, 0, HEIGHT - 64);
        cornerSprite.setRotation(270f);
        cornerSprite.setPosition(WIDTH - 64, HEIGHT - 64);
        cornerSprite.draw(batch);
        cornerSprite.setRotation(180f);
        cornerSprite.setPosition(WIDTH - 64, -32);
        cornerSprite.draw(batch);
        cornerSprite.setRotation(90f);
        cornerSprite.setPosition(0, -32);
        cornerSprite.draw(batch);
    }

    @Override
    public void dispose() {
        if (ScreenManager.currentScreen != null) {
            ScreenManager.getCurrentScreen().dispose();
        }
        mainCharacter.getTexture().dispose();
        batch.dispose();
    }

    public void resize() {
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

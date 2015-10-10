package entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet {

    private Sprite sprite;
    private Texture texture;
    private SpriteBatch batch;

    private int xPos, yPos, velocity = 10, direction;

    public Bullet(int startX, int startY, SpriteBatch batchIn, int direction) {
        xPos = startX;
        yPos = startY;
        batch = batchIn;
        this.direction = direction;

        texture = new Texture(Gdx.files.internal("Bullet.png"));
        sprite = new Sprite(texture);
    }

    public void update() {
        if (direction == 1) xPos += velocity;
        if (direction == 2) xPos -= velocity;
        if (direction == 3) yPos += velocity;
        if (direction == 4) yPos -= velocity;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
}

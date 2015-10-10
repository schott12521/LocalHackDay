package entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mhllhd.thebestgameever.MainGameClass;

public class Boss {

    private Sprite sprite;
    private Texture texture;
    private SpriteBatch batch;

    private int health;
    private boolean direction = true; // true == left, right == false

    private int xPos = MainGameClass.WIDTH / 2, yPos = MainGameClass.HEIGHT - 32, velocity = 10;

    public Boss(SpriteBatch batch) {
        this.batch = batch;

        texture = new Texture(Gdx.files.internal("bigBadGuy.png"));
        sprite = new Sprite(texture);
        sprite.scale(15);
        sprite.setPosition(xPos, yPos - 230);
        health = 100;
    }

    public void update(boolean hit) {
        if (hit) health -= 13;
        if (direction && xPos - 200 <= 0)
            direction = false;
        else if (!direction && xPos + 200 >= MainGameClass.WIDTH)
            direction = true;

        if (direction)
            xPos -= 2 * velocity;
        else
            xPos += 2 * velocity;
        sprite.setPosition(xPos, yPos - 230);
    }

    public int getyPos() {
        return yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public int getHealth() {
        return health;
    }

    public Sprite getSprite() {
        return sprite;
    }
}

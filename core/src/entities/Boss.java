package entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mhllhd.thebestgameever.MainGameClass;

import java.util.ArrayList;

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

    public boolean detectHit(ArrayList bullets) {
        for (int i = 0; i < bullets.size(); i++) {
            if (((Bullet) bullets.get(i)).getyPos() >= yPos - 200 && ((Bullet) bullets.get(i)).getyPos() <= yPos)
                if (((Bullet) bullets.get(i)).getxPos() <= xPos && ((Bullet) bullets.get(i)).getxPos() >= xPos - 200)
                    return true;
        }
        return false;
    }

    public void update(boolean hit) {
        if (hit) {
            health -= 13;
        }
        if (direction && xPos - 200 <= 0)
            direction = false;
        else if (!direction && xPos + 200 >= MainGameClass.WIDTH)
            direction = true;

        if (direction)
            xPos -= 2 * velocity;
        else
            xPos += 2 * velocity;
        sprite.setPosition(xPos, yPos - 230);
        if (health <= 0) {
            sprite.setPosition(-100000, -100000);
        }
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

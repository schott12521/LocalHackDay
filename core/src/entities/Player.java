package entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mhllhd.thebestgameever.MainGameClass;

import java.util.ArrayList;

public class Player {

    private Sprite sprite, spriteLeft, spriteRight, spriteUp, displaySprite;
    private Texture texture, textureLeft, textureRight, textureUp;
    private SpriteBatch batch;

    private int xPos = MainGameClass.WIDTH / 2 - 50, yPos = MainGameClass.HEIGHT / 2 - 50;

    public ArrayList bulletArrayList = new ArrayList();
    private int direction = 4; // 1 = RIGHT, 2 = LEFT, 3 UP, 4 = DOWN

    public Player(SpriteBatch batchIn) {
        texture = new Texture(Gdx.files.internal("littleGuy.png"));
        sprite = new Sprite(texture);
        textureLeft = new Texture(Gdx.files.internal("littleGuyLeft.png"));
        spriteLeft = new Sprite(textureLeft);
        textureRight = new Texture(Gdx.files.internal("littleGuyRight.png"));
        spriteRight = new Sprite(textureRight);
        textureUp = new Texture(Gdx.files.internal("littleGuyUp.png"));
        spriteUp = new Sprite(textureUp);

        displaySprite = sprite;
        batch = batchIn;
    }

    // TODO handle diagonal moving...
    public void move() {
        if (Gdx.input.isKeyPressed(Input.Keys.W) && canPlayerMove(3)) {
            yPos += 2;
            displaySprite = spriteUp;
            direction = 3;
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                Bullet bullet = new Bullet(this.xPos, this.yPos, batch, direction);
                bulletArrayList.add(bullet);
            }
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) && canPlayerMove(4)) {
            yPos -= 2;
            displaySprite = sprite;
            direction = 4;
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                Bullet bullet = new Bullet(this.xPos, this.yPos, batch, direction);
                bulletArrayList.add(bullet);
            }
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) && canPlayerMove(2)) {
            xPos -= 2;
            displaySprite = spriteLeft;
            direction = 2;
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                Bullet bullet = new Bullet(this.xPos, this.yPos, batch, direction);
                bulletArrayList.add(bullet);
            }
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) && canPlayerMove(1)) {
            xPos += 2;
            displaySprite = spriteRight;
            direction = 1;
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                Bullet bullet = new Bullet(this.xPos, this.yPos, batch, direction);
                bulletArrayList.add(bullet);
            }
            return;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            Bullet bullet = new Bullet(this.xPos, this.yPos, batch, direction);
            bulletArrayList.add(bullet);
        }

    }

    public boolean canPlayerMove(int direction) {
        if (direction == 1 && xPos + 132 >= MainGameClass.WIDTH) return false;
        if (direction == 2 && xPos <= 32) return false;
        if (direction == 3 && yPos + 100 >= MainGameClass.HEIGHT) return false;
        if (direction == 4 && yPos <= 25) return false;
        return true;
    }

//    public void shoot(float direction) {
//        Bullet bullet = new Bullet(this.xPos, this.yPos, batch);
//        bulletArrayList.add(bullet);
//    }

    public Sprite getSprite() {
        return displaySprite;
    }

    public Texture getTexture() {
        return texture;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
}

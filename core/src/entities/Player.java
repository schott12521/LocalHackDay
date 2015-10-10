package entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mhllhd.thebestgameever.MainGameClass;

public class Player {

    private Sprite sprite, spriteLeft, spriteRight, spriteUp, displaySwipe;
    private Texture texture, textureLeft, textureRight, textureUp;
    private SpriteBatch batch;

    private int xPos = MainGameClass.WIDTH / 2, yPos = MainGameClass.HEIGHT / 2;

    public Player(SpriteBatch batchIn) {
        texture = new Texture(Gdx.files.internal("littleGuy.png"));
        sprite = new Sprite(texture);
        textureLeft = new Texture(Gdx.files.internal("littleGuyLeft.png"));
        spriteLeft = new Sprite(textureLeft);
        textureRight = new Texture(Gdx.files.internal("littleGuyRight.png"));
        spriteRight = new Sprite(textureRight);
        textureUp = new Texture(Gdx.files.internal("littleGuyUp.png"));
        spriteUp = new Sprite(textureUp);
        batch = batchIn;
    }

    public void move() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            yPos += 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            yPos -= 2;
            texture = new Texture(Gdx.files.internal("littleGuy.png"));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            xPos -= 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            xPos += 2;
        }

    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public Texture getTexture() {
        return texture;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
}

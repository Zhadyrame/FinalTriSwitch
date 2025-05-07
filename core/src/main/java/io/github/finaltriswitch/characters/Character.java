package io.github.finaltriswitch.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Character {
    protected float x;
    protected float y;
    protected Texture texture;

    public Character(float x, float y, String texturePath) {
        this.x = x;
        this.y = y;
        this.texture = new Texture(texturePath);
    }

    public void act(float delta) {

    }

    public void draw(SpriteBatch batch, float alpha) {
        if (texture != null) {
            batch.draw(texture, x, y, texture.getWidth() * 0.4f, texture.getHeight() * 0.4f);
        }
    }


    public void move(float dx, float dy) {
        x += dx;
        y += dy;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void dispose() {
        if (texture != null) texture.dispose();
    }

    public void jump() {
    }
}

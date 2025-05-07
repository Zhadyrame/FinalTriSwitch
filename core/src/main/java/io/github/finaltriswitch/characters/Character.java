package io.github.finaltriswitch.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.Gdx;

public abstract class Character extends Actor {
    protected Texture texture;

    public Character(String texturePath, float x, float y) {
        try {
            this.texture = new Texture(Gdx.files.internal(texturePath));
        } catch (Exception e) {
            Gdx.app.error("Character", "Failed to load texture: " + texturePath, e);
            Gdx.app.exit();
        }
        setPosition(x, y);
        setSize(32, 32);
    }

    public void move(float dx, float dy) {
        moveBy(dx, dy);
        if (getY() < 50) setY(50); // Simple ground collision
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (texture != null) {
            batch.draw(texture, getX(), getY(), getWidth(), getHeight());
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void dispose() {
        if (texture != null) texture.dispose();
    }
}
package io.github.finaltriswitch.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MissJ implements Character {
    private Texture texture;
    private float x, y;

    public MissJ() {
        texture = new Texture("characters/missj.png");
        x = 100;
        y = 100;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y, 64, 64);
    }

    @Override
    public void moveLeft() { x -= 5; }

    @Override
    public void moveRight() { x += 5; }

    @Override
    public void jump() { y += 20; }

    @Override
    public void dispose() { texture.dispose(); }
}
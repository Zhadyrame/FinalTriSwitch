package io.github.finaltriswitch.characters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Character {
    void render(SpriteBatch batch);
    void moveLeft();
    void moveRight();
    void jump();
    void dispose();
}

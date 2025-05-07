package io.github.finaltriswitch.levels;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level2 {
    private Texture background;

    public Level2() {
        background = new Texture("level2.png");
    }

    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
    }

    public void dispose() {
        background.dispose();
    }
}
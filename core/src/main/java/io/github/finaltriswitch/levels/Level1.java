package io.github.finaltriswitch.levels;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level1 {
    private Texture levelTexture;

    public Level1() {
        levelTexture = new Texture("assets/level1.png");
    }

    public void render(SpriteBatch batch) {
        if (levelTexture != null) {
            batch.draw(levelTexture, 0, 0, 1600, 1200); // Новый размер карты
        }
    }

    public void dispose() {
        if (levelTexture != null) levelTexture.dispose();
    }
}
package io.github.finaltriswitch.levels;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level2 {
    private Texture levelTexture;
    private Texture blockTexture;
    private float blockX;
    private float blockY;

    public Level2() {
        levelTexture = new Texture("assets/level2.png");
        blockTexture = new Texture("assets/metal_block.png");
        blockX = 300; // Увеличили координаты в 2 раза
        blockY = 500;
    }

    public void render(SpriteBatch batch) {
        if (levelTexture != null) {
            batch.draw(levelTexture, 0, 0, 1600, 1200); // Новый размер карты
        }
        if (blockTexture != null) {
            batch.draw(blockTexture, blockX, blockY);
        }
    }

    public float getBlockX() {
        return blockX;
    }

    public float getBlockY() {
        return blockY;
    }

    public void moveBlock(float newX, float newY) {
        blockX = newX;
        blockY = newY;
    }

    public void dispose() {
        if (levelTexture != null) levelTexture.dispose();
        if (blockTexture != null) blockTexture.dispose();
    }
}

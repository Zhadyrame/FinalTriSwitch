package io.github.finaltriswitch.levels;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level2 {
    private Texture levelTexture;
    private Texture blockTexture;
    private Texture doorTexture;

    private float blockX;
    private float blockY;
    private float doorX;
    private float doorY;

    public Level2() {
        levelTexture = new Texture("assets/level2.png");
        blockTexture = new Texture("assets/metal_block.png");
        doorTexture = new Texture("assets/door.png");

        blockX = 900;
        blockY = 200;

        doorX = 1200;
        doorY = 300;
    }

    public void render(SpriteBatch batch) {
        if (levelTexture != null) {
            batch.draw(levelTexture, 0, 0, 1600, 1200);
        }
        if (blockTexture != null) {
            batch.draw(blockTexture, blockX, blockY, blockTexture.getWidth() / 5f, blockTexture.getHeight() / 5f);
        }
        if (doorTexture != null) {
            batch.draw(doorTexture, doorX, doorY, doorTexture.getWidth() / 4f, doorTexture.getHeight() / 4f);
        }
    }

    public float getBlockX() {
        return blockX;
    }

    public float getBlockY() {
        return blockY;
    }

    public void moveBlock(float newX, float newY) {
        if (newX >= 0 && newX <= 1500 - blockTexture.getWidth() / 2f) {
            blockX = newX;
        }
        blockY = 200;
    }

    public float getDoorX() {
        return doorX;
    }

    public float getDoorY() {
        return doorY;
    }

    public boolean isAtDoor(float characterX, float characterY) {
        float doorWidth = doorTexture.getWidth() / 4f;
        float doorHeight = doorTexture.getHeight() / 4f;

        return Math.abs(characterX - doorX) < doorWidth &&
            Math.abs(characterY - doorY) < doorHeight;
    }

    public void dispose() {
        if (levelTexture != null) levelTexture.dispose();
        if (blockTexture != null) blockTexture.dispose();
        if (doorTexture != null) doorTexture.dispose();
    }
}


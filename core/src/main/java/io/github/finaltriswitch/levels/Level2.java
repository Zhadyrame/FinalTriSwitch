package io.github.finaltriswitch.levels;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level2 {
    private Texture background;
    private Texture metalBlock;
    private float blockX = 400;
    private float blockY = 50;

    public Level2() {
        background = new Texture("assets/level2.png");
        metalBlock = new Texture("assets/metal_block.png");
    }

    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
        batch.draw(metalBlock, blockX, blockY, 32, 32);
    }

    public void moveBlock(float x, float y) {
        blockX = x;
        blockY = y;
        if (blockY < 50) blockY = 50;
    }

    public float getBlockX() {
        return blockX;
    }

    public float getBlockY() {
        return blockY;
    }

    public void dispose() {
        background.dispose();
        metalBlock.dispose();
    }
}

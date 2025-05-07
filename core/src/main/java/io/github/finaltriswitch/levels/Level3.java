package io.github.finaltriswitch.levels;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level3 {
    private Texture background;
    private Texture button;
    private Texture door;
    private float buttonX = 500;
    private float buttonY = 50;
    private float doorX = 600;
    private float doorY = 50;
    private boolean doorOpen = false;

    public Level3() {
        background = new Texture("assets/level3.png");
        button = new Texture("assets/button.png");
        door = new Texture("assets/door.png");
    }

    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
        batch.draw(button, buttonX, buttonY, 32, 32);
        if (!doorOpen) {
            batch.draw(door, doorX, doorY, 32, 32);
        }
    }

    public void openDoor() {
        doorOpen = true;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public float getDoorX() {
        return doorX;
    }

    public float getDoorY() {
        return doorY;
    }

    public float getButtonX() {
        return buttonX;
    }

    public float getButtonY() {
        return buttonY;
    }

    public void dispose() {
        background.dispose();
        button.dispose();
        door.dispose();
    }
}

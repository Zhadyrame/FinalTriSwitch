package io.github.finaltriswitch.levels;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level3 {
    private Texture levelTexture;
    private Texture buttonTexture;
    private Texture doorTexture;
    private float buttonX;
    private float buttonY;
    private float doorX;
    private float doorY;
    private boolean doorOpen;

    public Level3() {
        levelTexture = new Texture("assets/level3.png");
        buttonTexture = new Texture("assets/button.png");
        doorTexture = new Texture("assets/door.png");
        buttonX = 1000; // Увеличили координаты в 2 раза
        buttonY = 200;
        doorX = 1200;
        doorY = 200;
        doorOpen = false;
    }

    public void render(SpriteBatch batch) {
        if (levelTexture != null) {
            batch.draw(levelTexture, 0, 0, 1600, 1200); // Новый размер карты
        }
        if (buttonTexture != null) {
            batch.draw(buttonTexture, buttonX, buttonY);
        }
        if (doorTexture != null && !doorOpen) {
            batch.draw(doorTexture, doorX, doorY);
        }
    }

    public float getButtonX() {
        return buttonX;
    }

    public float getButtonY() {
        return buttonY;
    }

    public float getDoorX() {
        return doorX;
    }

    public float getDoorY() {
        return doorY;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public void openDoor() {
        doorOpen = true;
    }

    public void dispose() {
        if (levelTexture != null) levelTexture.dispose();
        if (buttonTexture != null) buttonTexture.dispose();
        if (doorTexture != null) doorTexture.dispose();
    }
}

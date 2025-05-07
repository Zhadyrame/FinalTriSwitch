package io.github.finaltriswitch.utils;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input;
import io.github.finaltriswitch.characters.MissJ;
import com.badlogic.gdx.audio.Sound;

public class InputHandler extends InputAdapter {

    private MissJ player;
    private Sound jumpSound;

    public InputHandler(MissJ player, Sound jumpSound) {
        this.player = player;
        this.jumpSound = jumpSound;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.LEFT) {
            player.moveLeft();
        } else if (keycode == Input.Keys.RIGHT) {
            player.moveRight();
        } else if (keycode == Input.Keys.SPACE || keycode == Input.Keys.W || keycode == Input.Keys.UP) {
            if (player.jump()) {
                jumpSound.play();
            }
        }
        return true;
    }
}


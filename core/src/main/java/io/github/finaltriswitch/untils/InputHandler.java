package io.github.finaltriswitch.untils;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Gdx;
import io.github.finaltriswitch.logic.GameLogic;

public class InputHandler {
    public static void setupInput(GameLogic logic) {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Keys.NUM_1) {
                    logic.switchToMissJ();
                } else if (keycode == Keys.NUM_2) {
                    logic.switchToMissK();
                } else if (keycode == Keys.NUM_3) {
                    logic.switchToMrB();
                }
                return true;
            }
        });
    }
}

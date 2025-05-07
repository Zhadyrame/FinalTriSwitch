package io.github.finaltriswitch.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import io.github.finaltriswitch.FinalTriSwitch;
import io.github.finaltriswitch.logic.GameLogic;
import io.github.finaltriswitch.characters.Character;

public class GameScreen implements Screen {
    private FinalTriSwitch game;
    private GameLogic gameLogic;

    public GameScreen(FinalTriSwitch game) {
        this.game = game;
        this.gameLogic = new GameLogic();

        Gdx.input.setInputProcessor(new com.badlogic.gdx.InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                if (gameLogic != null) {
                    if (keycode == Keys.NUM_1) {
                        gameLogic.switchToMissJ();
                    } else if (keycode == Keys.NUM_2) {
                        gameLogic.switchToMissK();
                    } else if (keycode == Keys.NUM_3) {
                        gameLogic.switchToMrB();
                    }
                }
                return true;
            }
        });
    }

    private void handleInput() {
        float speed = 200 * Gdx.graphics.getDeltaTime();
        Character active = (gameLogic != null) ? gameLogic.getActiveCharacter() : null;

        if (active != null) {
            if (Gdx.input.isKeyPressed(Keys.LEFT)) active.move(-speed, 0);
            if (Gdx.input.isKeyPressed(Keys.RIGHT)) active.move(speed, 0);
        }
    }

    @Override
    public void render(float delta) {
        handleInput();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (game != null && game.getBatch() != null && gameLogic != null) {
            game.getBatch().begin();
            gameLogic.render(game.getBatch());
            game.getBatch().end();
        }

        if (gameLogic != null) gameLogic.update(delta);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        if (gameLogic != null) {
            gameLogic.dispose();
        }
    }
}

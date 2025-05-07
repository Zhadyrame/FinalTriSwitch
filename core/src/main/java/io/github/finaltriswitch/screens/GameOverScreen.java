package io.github.finaltriswitch.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import io.github.finaltriswitch.FinalTriSwitch;

public class GameOverScreen extends ScreenAdapter {
    private FinalTriSwitch game;
    private float record;

    public GameOverScreen(FinalTriSwitch game, float record) {
        this.game = game;
        this.record = record;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (game != null && game.getBatch() != null) {
            game.getBatch().begin();
            Gdx.app.log("GameOver", "Игра закончена! Рекорд: " + record + " секунд");
            game.getBatch().end();
        }

        if (Gdx.input.isKeyPressed(Keys.ENTER)) {
            game.setScreen(new PlayScreen(game));
        }
    }

    @Override
    public void dispose() {
    }
}

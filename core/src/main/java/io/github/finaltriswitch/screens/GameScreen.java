package io.github.finaltriswitch.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import io.github.finaltriswitch.Main;
import io.github.finaltriswitch.logic.GameLogic;
import io.github.finaltriswitch.levels.Level1;

public class GameScreen extends ScreenAdapter {
    private Main game;
    private GameLogic logic;
    private Level1 level;

    public GameScreen(Main game) {
        this.game = game;
        logic = new GameLogic();
        level = new Level1();
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0.2f, 0.3f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        level.render(game.batch);
        logic.getMissJ().render(game.batch);
        logic.getMissK().render(game.batch);
        logic.getMrB().render(game.batch);
        game.batch.end();
    }

    private void update(float delta) {
        logic.getMissJ().update(delta);
        logic.getMissK().update(delta);
        logic.getMrB().update(delta);
    }

    @Override
    public void dispose() {
        logic.dispose();
        level.dispose();
    }
}

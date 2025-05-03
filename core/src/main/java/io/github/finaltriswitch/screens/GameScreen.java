package io.github.finaltriswitch.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import io.github.finaltriswitch.Main;
import io.github.finaltriswitch.logic.GameLogic;
import io.github.finaltriswitch.levels.Level1;
import io.github.finaltriswitch.levels.Level2;
import io.github.finaltriswitch.levels.Level3;

public class GameScreen extends ScreenAdapter {
    private Main game;
    private GameLogic logic;
    private Object currentLevel;
    private int levelNumber;

    public GameScreen(Main game) {
        this.game = game;
        logic = new GameLogic();
        currentLevel = new Level1();
        levelNumber = 1;
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0.2f, 0.3f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        renderLevel();
        logic.render(game.batch);
        game.batch.end();
    }

    private void update(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            logic.switchCharacter(); // Переключение персонажа
        }
        logic.update(delta);

        // Переход на следующий уровень (например, после 10 секунд игры)
        if (Gdx.input.isKeyJustPressed(Input.Keys.N)) { // временно по кнопке 'N'
            nextLevel();
        }
    }

    private void renderLevel() {
        if (currentLevel instanceof Level1) {
            ((Level1) currentLevel).render(game.batch);
        } else if (currentLevel instanceof Level2) {
            ((Level2) currentLevel).render(game.batch);
        } else if (currentLevel instanceof Level3) {
            ((Level3) currentLevel).render(game.batch);
        }
    }

    private void nextLevel() {
        if (currentLevel != null) {
            disposeCurrentLevel();
        }

        levelNumber++;
        if (levelNumber == 2) {
            currentLevel = new Level2();
        } else if (levelNumber == 3) {
            currentLevel = new Level3();
        } else {
            // Game Over
            game.setScreen(new MenuScreen(game));
        }
    }

    private void disposeCurrentLevel() {
        if (currentLevel instanceof Level1) {
            ((Level1) currentLevel).dispose();
        } else if (currentLevel instanceof Level2) {
            ((Level2) currentLevel).dispose();
        } else if (currentLevel instanceof Level3) {
            ((Level3) currentLevel).dispose();
        }
    }

    @Override
    public void dispose() {
        logic.dispose();
        disposeCurrentLevel();
    }
}

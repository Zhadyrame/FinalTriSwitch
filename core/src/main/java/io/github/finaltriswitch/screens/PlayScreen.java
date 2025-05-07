package io.github.finaltriswitch.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import io.github.finaltriswitch.FinalTriSwitch;
import io.github.finaltriswitch.characters.Character;
import io.github.finaltriswitch.characters.MissK;
import io.github.finaltriswitch.logic.GameLogic;
import io.github.finaltriswitch.levels.Level1;
import io.github.finaltriswitch.levels.Level2;

public class PlayScreen extends ScreenAdapter {
    private FinalTriSwitch game;
    private Stage stage;
    private OrthographicCamera camera;
    private FitViewport viewport;
    private GameLogic gameLogic;
    private Level1 level1;
    private Level2 level2;

    private int currentLevel;
    private float timer;
    private float record;

    public PlayScreen(FinalTriSwitch game) {
        this.game = game;
        camera = new OrthographicCamera();
        viewport = new FitViewport(1600, 1200, camera);
        stage = new Stage(viewport, game.getBatch());
        gameLogic = new GameLogic();
        level1 = new Level1();
        level2 = new Level2();

        currentLevel = 1;
        timer = 0;
        record = 0;

        Gdx.input.setInputProcessor(new com.badlogic.gdx.InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                if (gameLogic != null) {
                    if (keycode == Keys.NUM_1) gameLogic.switchToMissJ();
                    else if (keycode == Keys.NUM_2) gameLogic.switchToMissK();
                    else if (keycode == Keys.NUM_3) gameLogic.switchToMrB();
                }
                return true;
            }
        });
    }
    private void handleInput() {
        float speed = 400 * Gdx.graphics.getDeltaTime();
        Character active = (gameLogic != null) ? gameLogic.getActiveCharacter() : null;

        if (active != null) {
            float nextX = active.getX();
            float nextY = active.getY();

            // Вычисляем nextX / nextY
            if (Gdx.input.isKeyPressed(Keys.LEFT)) nextX -= speed;
            if (Gdx.input.isKeyPressed(Keys.RIGHT)) nextX += speed;
            if (Gdx.input.isKeyPressed(Keys.UP)) nextY += speed;
            if (Gdx.input.isKeyPressed(Keys.DOWN)) nextY -= speed;

            // Проверяем столкновение с блоком (только на 2 уровне)
            boolean blocked = false;
            if (currentLevel == 2 && level2 != null) {
                float blockX = level2.getBlockX();
                float blockY = level2.getBlockY();
                float blockSize = 64;  // предполагаем размер блока

                boolean touchingBlockX = Math.abs(nextX - blockX) < blockSize;
                boolean touchingBlockY = Math.abs(nextY - blockY) < blockSize;

                // MissK может толкать блок
                if (active instanceof MissK && Gdx.input.isKeyPressed(Keys.M)) {
                    float newBlockX = level2.getBlockX() +
                        (Gdx.input.isKeyPressed(Keys.LEFT) ? -speed : Gdx.input.isKeyPressed(Keys.RIGHT) ? speed : 0);
                    level2.moveBlock(newBlockX, level2.getBlockY());
                } else if (touchingBlockX && touchingBlockY) {
                    blocked = true;
                }
            }

            // Двигаем персонажа, если не заблокировано
            if (!blocked) {
                active.setX(nextX);
                active.setY(nextY);
            }

            // Прыжок
            if (Gdx.input.isKeyPressed(Keys.SPACE)) {
                active.jump();
            }
        }
    }



    private void checkWinCondition() {
        Character active = gameLogic.getActiveCharacter();

        if (active != null && active.getX() > 1000) {
            gameLogic.setReachedGoal(active);

            if (currentLevel == 1 && gameLogic.allReachedGoal()) {
                currentLevel = 2;
                resetPositions();
                timer = 0;
                gameLogic.resetGoals();
            } else if (currentLevel == 2 && gameLogic.allReachedGoal()) {
                float finalTime = timer;
                if (record == 0 || finalTime < record) record = finalTime;
                game.setScreen(new GameOverScreen(game, record));
            }
        }
    }

    private void resetPositions() {
        gameLogic.getMissJ().setPosition(20, 200);
        gameLogic.getMissK().setPosition(30, 200);
        gameLogic.getMrB().setPosition(40, 200);
        gameLogic.switchToMissJ();
    }

    @Override
    public void render(float delta) {
        timer += delta;
        handleInput();
        checkWinCondition();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().setProjectionMatrix(camera.combined);
        game.getBatch().begin();
        if (currentLevel == 1) level1.render(game.getBatch());
        else if (currentLevel == 2) level2.render(game.getBatch());
        gameLogic.render(game.getBatch());
        game.getBatch().end();

        gameLogic.update(delta);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void dispose() {
        stage.dispose();
        gameLogic.dispose();
        level1.dispose();
        level2.dispose();
    }
}

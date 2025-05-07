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
import io.github.finaltriswitch.characters.MissJ;
import io.github.finaltriswitch.characters.MissK;
import io.github.finaltriswitch.characters.MrB;
import io.github.finaltriswitch.logic.GameLogic;
import io.github.finaltriswitch.levels.Level1;
import io.github.finaltriswitch.levels.Level2;
import io.github.finaltriswitch.levels.Level3;

public class PlayScreen extends ScreenAdapter {
    private FinalTriSwitch game;
    private Stage stage; // Оставляем для камеры
    private OrthographicCamera camera;
    private FitViewport viewport;
    private GameLogic gameLogic;
    private Level1 level1;
    private Level2 level2;
    private Level3 level3;
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
        level3 = new Level3();
        currentLevel = 1;
        timer = 0;
        record = 0;

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
        float speed = 400 * Gdx.graphics.getDeltaTime();
        Character active = (gameLogic != null) ? gameLogic.getActiveCharacter() : null;

        if (active != null) {
            if (Gdx.input.isKeyPressed(Keys.LEFT)) active.move(-speed, 0);
            if (Gdx.input.isKeyPressed(Keys.RIGHT)) active.move(speed, 0);
            if (Gdx.input.isKeyPressed(Keys.SPACE) && active instanceof MissJ) {
                ((MissJ) active).jump();
            }
            if (Gdx.input.isKeyPressed(Keys.M) && active instanceof MissK && currentLevel == 2 && level2 != null) {
                float newX = level2.getBlockX() + (Gdx.input.isKeyPressed(Keys.LEFT) ? -speed : Gdx.input.isKeyPressed(Keys.RIGHT) ? speed : 0);
                float newY = level2.getBlockY() + (Gdx.input.isKeyPressed(Keys.UP) ? speed : Gdx.input.isKeyPressed(Keys.DOWN) ? -speed : 0);
                level2.moveBlock(newX, newY);
            }
            if (Gdx.input.isKeyPressed(Keys.P) && active instanceof MrB && currentLevel == 3 && level3 != null) {
                if (Math.abs(active.getX() - level3.getButtonX()) < 100 && Math.abs(active.getY() - level3.getButtonY()) < 100) {
                    level3.openDoor();
                }
            }
        }
    }

    private void checkCollisions() {
        Character active = (gameLogic != null) ? gameLogic.getActiveCharacter() : null;
        if (active != null) {
            if (currentLevel == 2 && level2 != null) {
                float blockX = level2.getBlockX();
                float blockY = level2.getBlockY();
                if (Math.abs(active.getX() - blockX) < 64 && Math.abs(active.getY() - blockY) < 64) {
                    active.move(active.getX() < blockX ? -10 : 10, 0);
                }
            }
            if (currentLevel == 3 && level3 != null && !level3.isDoorOpen()) {
                float doorX = level3.getDoorX();
                float doorY = level3.getDoorY();
                if (Math.abs(active.getX() - doorX) < 64 && Math.abs(active.getY() - doorY) < 64) {
                    active.move(active.getX() < doorX ? -10 : 10, 0);
                }
            }
        }
    }

    private void checkWinCondition() {
        Character active = (gameLogic != null) ? gameLogic.getActiveCharacter() : null;
        if (active != null && active.getX() > 1400) {
            if (gameLogic != null) {
                gameLogic.setReachedGoal(active);
                if (currentLevel == 1 && gameLogic.allReachedGoal()) {
                    currentLevel = 2;
                    resetPositions();
                    timer = 0;
                } else if (currentLevel == 2 && gameLogic.getReachedCount() >= 2) {
                    currentLevel = 3;
                    resetPositions();
                    timer = 0;
                } else if (currentLevel == 3 && gameLogic.getReachedCount() >= 1) {
                    float finalTime = timer;
                    if (gameLogic.allReachedGoal() && (record == 0 || finalTime < record)) {
                        record = finalTime;
                    }
                    game.setScreen(new GameOverScreen(game, record));
                }
            }
        }
    }

    private void resetPositions() {
        if (gameLogic != null) {
            gameLogic.getMissJ().setPosition(200, 200);
            gameLogic.getMissK().setPosition(300, 200);
            gameLogic.getMrB().setPosition(400, 200);
            gameLogic.switchToMissJ();
        }
    }

    @Override
    public void render(float delta) {
        timer += delta;
        handleInput();
        checkCollisions();
        checkWinCondition();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (game != null && game.getBatch() != null) {
            game.getBatch().setProjectionMatrix(camera.combined); // Используем камеру для масштаба
            game.getBatch().begin();
            if (currentLevel == 1 && level1 != null) level1.render(game.getBatch());
            else if (currentLevel == 2 && level2 != null) level2.render(game.getBatch());
            else if (currentLevel == 3 && level3 != null) level3.render(game.getBatch());
            if (gameLogic != null) gameLogic.render(game.getBatch());
            game.getBatch().end();
        }

        if (gameLogic != null) gameLogic.update(delta);
    }

    @Override
    public void resize(int width, int height) {
        if (viewport != null) viewport.update(width, height);
    }

    @Override
    public void dispose() {
        if (stage != null) stage.dispose();
        if (gameLogic != null) gameLogic.dispose();
        if (level1 != null) level1.dispose();
        if (level2 != null) level2.dispose();
        if (level3 != null) level3.dispose();
    }
}

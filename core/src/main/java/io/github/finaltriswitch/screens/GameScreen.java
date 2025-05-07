package io.github.finaltriswitch.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.finaltriswitch.Main;
import io.github.finaltriswitch.characters.Character;
import io.github.finaltriswitch.characters.MissJ;
import io.github.finaltriswitch.characters.MissK;
import io.github.finaltriswitch.characters.MrB;

public class GameScreen extends ScreenAdapter {
    private final Main game;
    private final SpriteBatch batch;
    private final Texture background;
    private final Character[] characters;
    private int currentCharacterIndex;

    public GameScreen(Main game) {
        this.game = game;
        batch = new SpriteBatch();
        background = new Texture("backgrounds/level1.png");
        characters = new Character[] {
            new MissJ(),
            new MissK(),
            new MrB()
        };
        currentCharacterIndex = 0;
    }

    private Character getActiveCharacter() {
        return characters[currentCharacterIndex];
    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        getActiveCharacter().render(batch);
        batch.end();

        handleInput();
    }

    private void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.TAB)) {
            currentCharacterIndex = (currentCharacterIndex + 1) % characters.length;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            getActiveCharacter().moveLeft();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            getActiveCharacter().moveRight();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            getActiveCharacter().jump();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        for (Character character : characters) {
            character.dispose();
        }
    }
}

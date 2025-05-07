package io.github.finaltriswitch.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.finaltriswitch.Main;

public class MenuScreen extends ScreenAdapter {
    private final Main game;
    private final SpriteBatch batch;
    private final Texture menuTexture;

    public MenuScreen(Main game) {
        this.game = game;
        batch = new SpriteBatch();
        menuTexture = new Texture("ui/menu.png");
    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(menuTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            game.setScreen(new GameScreen(game));
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        menuTexture.dispose();
    }
}

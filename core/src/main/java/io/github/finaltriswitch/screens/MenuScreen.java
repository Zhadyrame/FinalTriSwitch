package io.github.finaltriswitch.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import io.github.finaltriswitch.FinalTriSwitch;

public class MenuScreen extends ScreenAdapter {
    private FinalTriSwitch game;
    private Texture menuTexture;

    public MenuScreen(FinalTriSwitch game) {
        this.game = game;
    }

    @Override
    public void show() {
        menuTexture = new Texture("assets/menu.png");
        Gdx.app.log("MenuScreen", "Texture loaded: " + (menuTexture != null));
        Gdx.input.setInputProcessor(new com.badlogic.gdx.InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Keys.ENTER) {
                    Gdx.app.log("MenuScreen", "Enter pressed, switching to PlayScreen");
                    game.setScreen(new PlayScreen(game));
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void render(float delta) {
        if (game != null && game.getBatch() != null) {
            game.getBatch().begin();
            if (menuTexture != null) {
                game.getBatch().draw(menuTexture, 0, 0, 700, 500); // Новый размер меню
            } else {
                Gdx.app.log("MenuScreen", "menuTexture is null, displaying fallback");
                game.getBatch().draw(new Texture("badlogic.png"), 0, 0, 1600, 1200);
            }
            game.getBatch().end();
        }
    }

    @Override
    public void dispose() {
        if (menuTexture != null) menuTexture.dispose();
    }
}

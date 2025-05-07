package io.github.finaltriswitch;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.finaltriswitch.screens.MenuScreen;

public class Main extends Game {
    public SpriteBatch batch;
    public AssetManager manager;

    @Override
    public void create() {
        batch = new SpriteBatch();
        manager = new AssetManager();
        this.setScreen(new MenuScreen(this));
    }

    @Override
    public void dispose() {
        batch.dispose();
        manager.dispose();
        super.dispose();
    }
}

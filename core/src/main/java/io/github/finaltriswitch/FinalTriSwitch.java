package io.github.finaltriswitch;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.assets.AssetManager;
import io.github.finaltriswitch.screens.MenuScreen;

public class FinalTriSwitch extends Game {
    private SpriteBatch batch;          // Рисует спрайты
    public AssetManager manager;        // Менеджер ассетов

    @Override
    public void create() {
        batch = new SpriteBatch();
        manager = new AssetManager();
        setScreen(new MenuScreen(this)); // Запускаем с меню
    }

    @Override
    public void dispose() {
        if (batch != null) batch.dispose();
        if (manager != null) manager.dispose();
        super.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }
}

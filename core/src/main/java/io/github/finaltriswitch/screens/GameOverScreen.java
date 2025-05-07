package io.github.finaltriswitch.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.finaltriswitch.FinalTriSwitch;

public class GameOverScreen extends ScreenAdapter {
    private FinalTriSwitch game;     // Ссылка на игру
    private float record;            // Рекордное время
    private BitmapFont font;         // Шрифт
    private GlyphLayout layout;      // Помощь в выравнивании текста

    public GameOverScreen(FinalTriSwitch game, float record) {
        this.game = game;
        this.record = record;
        this.font = new BitmapFont();
        this.font.getData().setScale(2f);
        this.font.setColor(Color.WHITE);
        this.layout = new GlyphLayout();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        SpriteBatch batch = game.getBatch();
        batch.begin();

        String message = "GAME OVER\n" +
            "Record: " + String.format("%.2f", record) + " seconds\n" +
            "Press ENTER to restart\n" +
            "New levels coming soon! Stay tuned!";

        layout.setText(font, message);
        float x = (Gdx.graphics.getWidth() - layout.width) / 2;
        float y = (Gdx.graphics.getHeight() + layout.height) / 2;

        font.draw(batch, message, x, y);
        batch.end();

        if (Gdx.input.isKeyPressed(Keys.ENTER)) {
            game.setScreen(new PlayScreen(game));
        }
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}

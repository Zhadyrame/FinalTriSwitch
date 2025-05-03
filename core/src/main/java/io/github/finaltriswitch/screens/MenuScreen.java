package io.github.finaltriswitch.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.finaltriswitch.Main;
public class MenuScreen extends ScreenAdapter {
    private Main game;
    private BitmapFont font;

    public MenuScreen(Main game) {
        this.game = game;
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()) {
            game.setScreen(new GameScreen(game));
        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        font.draw(game.batch, "Touch to Start!", 300, 300);
        game.batch.end();
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}

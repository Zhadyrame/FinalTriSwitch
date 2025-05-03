package io.github.finaltriswitch.characters;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class MissK {
    private Texture texture;
    private Vector2 position;
    private float speedX = 150f;

    public MissK() {
        texture = new Texture("missk.png");
        position = new Vector2(100, 100);
    }

    public void update(float delta) {
        position.x += speedX * delta;
        if (position.x > 600) {
            position.x = 100;
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void dispose() {
        texture.dispose();
    }
}

package io.github.finaltriswitch.characters;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class MissJ {
    private Texture texture;
    private Vector2 position;
    private float speedY = 20f;

    public MissJ() {
        texture = new Texture("missj.png");
        position = new Vector2(10, 10);
    }

    public void update(float delta) {
        position.y += speedY * delta;
        if (position.y > 30) {
            position.y = 10;
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void dispose() {
        texture.dispose();
    }
}

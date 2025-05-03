package io.github.finaltriswitch.characters;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class MissJ {
    private Texture texture;
    private Vector2 position;
    private float speedY = 200f;

    public MissJ() {
        texture = new Texture("missj.png");
        position = new Vector2(100, 100);
    }

    public void update(float delta) {
        position.y += speedY * delta;
        if (position.y > 400) {
            position.y = 100;
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void dispose() {
        texture.dispose();
    }
}

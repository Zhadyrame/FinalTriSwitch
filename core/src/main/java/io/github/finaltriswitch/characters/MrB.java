package io.github.finaltriswitch.characters;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class MrB {
    private Texture texture;
    private Vector2 position;

    public MrB() {
        texture = new Texture("mrb.png");
        position = new Vector2(400, 100);
    }

    public void update(float delta) {
        // MrB стоит на месте
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void dispose() {
        texture.dispose();
    }
}

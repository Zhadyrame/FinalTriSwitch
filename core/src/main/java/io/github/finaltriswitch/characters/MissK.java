package io.github.finaltriswitch.characters;

import com.badlogic.gdx.Gdx;

public class MissK extends Character {
    public MissK(float x, float y) {
        super("assets/missk.png", x, y);
    }

    public void magnetize(float targetX, float targetY) {
        Gdx.app.log("MissK", "Magnetizing to (" + targetX + ", " + targetY + ")");
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}

package io.github.finaltriswitch.characters;

import com.badlogic.gdx.Gdx;

public class MrB extends Character {
    public MrB(float x, float y) {
        super("assets/mrb.png", x, y);
    }

    public void solvePuzzle() {
        Gdx.app.log("MrB", "Solving puzzle!");
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}

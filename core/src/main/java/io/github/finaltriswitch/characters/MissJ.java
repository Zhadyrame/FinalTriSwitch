package io.github.finaltriswitch.characters;

import com.badlogic.gdx.Gdx;

public class MissJ extends Character {
    private boolean canDoubleJump;
    private boolean isJumping;

    public MissJ(float x, float y) {
        super("assets/missj.png", x, y);
        canDoubleJump = false;
        isJumping = false;
    }

    public void jump() {
        if (!isJumping) {
            move(0, 100);
            isJumping = true;
            canDoubleJump = true;
        } else if (canDoubleJump) {
            move(0, 100);
            canDoubleJump = false;
        }
    }

    @Override
    public void move(float dx, float dy) {
        super.move(dx, dy);
        if (getY() <= 50) {
            isJumping = false;
            canDoubleJump = false;
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        // Simulate gravity
        if (getY() > 50) {
            move(0, -200 * delta);
        }
    }
}

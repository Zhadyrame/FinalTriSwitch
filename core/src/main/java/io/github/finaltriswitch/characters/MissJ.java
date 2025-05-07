package io.github.finaltriswitch.characters;

import com.badlogic.gdx.Gdx;

public class MissJ extends Character {
    private float velocityY;
    private boolean isJumping;

    public MissJ(float x, float y) {
        super(x, y, "assets/missj.png");
        velocityY = 0;
        isJumping = false;
    }

    public void jump() {
        if (!isJumping) {
            velocityY = 600; // Увеличили высоту прыжка в 2 раза
            isJumping = true;
        }
    }

    @Override
    public void act(float delta) {
        if (isJumping) {
            y += velocityY * delta;
            velocityY -= 1200 * delta; // Увеличили гравитацию в 2 раза
            if (y <= 200) { // Увеличили уровень земли в 2 раза
                y = 200;
                velocityY = 0;
                isJumping = false;
            }
        }
    }
}

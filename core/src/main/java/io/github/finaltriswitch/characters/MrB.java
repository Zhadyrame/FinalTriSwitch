package io.github.finaltriswitch.characters;

import com.badlogic.gdx.Gdx;

public class MrB extends Character {
    private float velocityY;
    private boolean isJumping;

    public MrB(float x, float y) {
        super(x, y, "assets/mrb.png");
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
            velocityY -= 1300 * delta; // Увеличили гравитацию в 2 раза
            if (y <= 200) { // Увеличили уровень земли в 2 раза
                y = 200;
                velocityY = 0;
                isJumping = false;
            }
        }
    }
}
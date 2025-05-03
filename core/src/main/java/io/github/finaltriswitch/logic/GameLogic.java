package io.github.finaltriswitch.logic;

import io.github.finaltriswitch.characters.MissJ;
import io.github.finaltriswitch.characters.MissK;
import io.github.finaltriswitch.characters.MrB;

public class GameLogic {
    private MissJ missJ;
    private MissK missK;
    private MrB mrB;
    private Object activeCharacter; // Новый активный персонаж

    public GameLogic() {
        missJ = new MissJ();
        missK = new MissK();
        mrB = new MrB();
        activeCharacter = missJ; // Стартуем с MissJ
    }

    public void switchCharacter() {
        if (activeCharacter == missJ) {
            activeCharacter = missK;
        } else if (activeCharacter == missK) {
            activeCharacter = mrB;
        } else {
            activeCharacter = missJ;
        }
    }

    public void update(float delta) {
        if (activeCharacter instanceof MissJ) {
            ((MissJ) activeCharacter).update(delta);
        } else if (activeCharacter instanceof MissK) {
            ((MissK) activeCharacter).update(delta);
        } else if (activeCharacter instanceof MrB) {
            ((MrB) activeCharacter).update(delta);
        }
    }

    public void render(com.badlogic.gdx.graphics.g2d.SpriteBatch batch) {
        if (activeCharacter instanceof MissJ) {
            ((MissJ) activeCharacter).render(batch);
        } else if (activeCharacter instanceof MissK) {
            ((MissK) activeCharacter).render(batch);
        } else if (activeCharacter instanceof MrB) {
            ((MrB) activeCharacter).render(batch);
        }
    }

    public void dispose() {
        missJ.dispose();
        missK.dispose();
        mrB.dispose();
    }
}

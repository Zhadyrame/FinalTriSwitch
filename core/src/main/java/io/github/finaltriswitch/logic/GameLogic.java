package io.github.finaltriswitch.logic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.finaltriswitch.characters.MissJ;
import io.github.finaltriswitch.characters.MissK;
import io.github.finaltriswitch.characters.MrB;
import io.github.finaltriswitch.characters.Character;

public class GameLogic {
    private MissJ missJ;
    private MissK missK;
    private MrB mrB;
    private Character activeCharacter;
    private boolean missJReachedGoal;
    private boolean missKReachedGoal;
    private boolean mrBReachedGoal;

    public GameLogic() {
        missJ = new MissJ(400, 600);
        missK = new MissK(0, 150);
        mrB = new MrB(700, 450);
        activeCharacter = missJ;
        resetGoals();
    }

    public void switchToMissJ() { activeCharacter = missJ; }
    public void switchToMissK() { activeCharacter = missK; }
    public void switchToMrB() { activeCharacter = mrB; }

    public Character getActiveCharacter() { return activeCharacter; }
    public MissJ getMissJ() { return missJ; }
    public MissK getMissK() { return missK; }
    public MrB getMrB() { return mrB; }

    public void update(float delta) {
        missJ.act(delta);
        missK.act(delta);
        mrB.act(delta);
    }

    public void render(SpriteBatch batch) {
        missJ.draw(batch, 1);
        missK.draw(batch, 1);
        mrB.draw(batch, 1);
    }

    public void setReachedGoal(Character character) {
        if (character instanceof MissJ) missJReachedGoal = true;
        else if (character instanceof MissK) missKReachedGoal = true;
        else if (character instanceof MrB) mrBReachedGoal = true;
    }

    public boolean allReachedGoal() {
        return missJReachedGoal && missKReachedGoal && mrBReachedGoal;
    }

    public void resetGoals() {
        missJReachedGoal = false;
        missKReachedGoal = false;
        mrBReachedGoal = false;
    }

    public void dispose() {
        missJ.dispose();
        missK.dispose();
        mrB.dispose();
    }
}

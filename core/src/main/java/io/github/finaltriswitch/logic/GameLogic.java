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
        missJ = new MissJ(100, 100);
        missK = new MissK(150, 100);
        mrB = new MrB(200, 100);
        activeCharacter = missJ;
        missJReachedGoal = false;
        missKReachedGoal = false;
        mrBReachedGoal = false;
    }

    public void switchToMissJ() {
        activeCharacter = missJ;
    }

    public void switchToMissK() {
        activeCharacter = missK;
    }

    public void switchToMrB() {
        activeCharacter = mrB;
    }

    public Character getActiveCharacter() {
        return activeCharacter;
    }

    public MissJ getMissJ() {
        return missJ;
    }

    public MissK getMissK() {
        return missK;
    }

    public MrB getMrB() {
        return mrB;
    }

    public void update(float delta) {
        if (missJ != null) missJ.act(delta);
        if (missK != null) missK.act(delta);
        if (mrB != null) mrB.act(delta);
    }

    public void render(SpriteBatch batch) {
        if (missJ != null) missJ.draw(batch, 1);
        if (missK != null) missK.draw(batch, 1);
        if (mrB != null) mrB.draw(batch, 1);
    }

    public void setReachedGoal(Character character) {
        if (character == missJ) missJReachedGoal = true;
        if (character == missK) missKReachedGoal = true;
        if (character == mrB) mrBReachedGoal = true;
    }

    public boolean allReachedGoal() {
        return missJReachedGoal && missKReachedGoal && mrBReachedGoal;
    }

    public int getReachedCount() {
        int count = 0;
        if (missJReachedGoal) count++;
        if (missKReachedGoal) count++;
        if (mrBReachedGoal) count++;
        return count;
    }

    public void dispose() {
        if (missJ != null) missJ.dispose();
        if (missK != null) missK.dispose();
        if (mrB != null) mrB.dispose();
    }
}

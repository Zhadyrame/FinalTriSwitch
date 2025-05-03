package io.github.finaltriswitch.logic;
import io.github.finaltriswitch.characters.MissJ;
import io.github.finaltriswitch.characters.MissK;
import io.github.finaltriswitch.characters.MrB;
public class GameLogic {
    private MissJ missJ;
    private MissK missK;
    private MrB mrB;
    public GameLogic() {
        missJ = new MissJ();
        missK = new MissK();
        mrB = new MrB();
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
    public void dispose() {
        missJ.dispose();
        missK.dispose();
        mrB.dispose();
    }
}

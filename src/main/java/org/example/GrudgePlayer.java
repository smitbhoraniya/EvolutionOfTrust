package org.example;

public class GrudgePlayer implements Player {
    private boolean isGrudging = false;
    @Override
    public Move makeMove() {
        Move move = Move.COOPERATE;
        if (isGrudging) {
            move = Move.CHEAT;
        }
        return move;
    }

    @Override
    public void invest() {
        this.isGrudging = true;
    }

    @Override
    public void gain() {
        if (this.isGrudging) {
            this.isGrudging = false;
        }
    }
}

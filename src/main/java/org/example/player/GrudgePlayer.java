package org.example.player;

import org.example.Move;

public class GrudgePlayer extends Player {
    private boolean isGrudging = false;
    private boolean isInvestedInPreviousRound = false;
    @Override
    public Move makeMove() {
        Move move = Move.COOPERATE;
        if (isInvestedInPreviousRound && !this.isGrudging)
            this.isGrudging = true;
        if (isGrudging) {
            move = Move.CHEAT;
        }
        this.isInvestedInPreviousRound = false;
        return move;
    }

    @Override
    public void invest() {
        this.isInvestedInPreviousRound = true;
        super.invest();
    }

    @Override
    public void gain() {
        this.isInvestedInPreviousRound = false;
        super.gain();
    }
}

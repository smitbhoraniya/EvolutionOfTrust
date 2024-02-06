package org.example.player;

import org.example.Move;

public class GrudgePlayer implements Player {
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
        return move;
    }

    @Override
    public void invest() {
        this.isInvestedInPreviousRound = true;
    }

    @Override
    public void gain() {
        if (this.isInvestedInPreviousRound) {
            this.isInvestedInPreviousRound = false;
        }
    }
}

package org.example.player;

import org.example.Move;

public class CopyKittenPlayer implements Player {
    private boolean isInvestedInPreviousRound = false;
    @Override
    public Move makeMove() {
        Move move = Move.COOPERATE;
        if (isInvestedInPreviousRound) {
            move = Move.CHEAT;
        }
        isInvestedInPreviousRound = false;
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

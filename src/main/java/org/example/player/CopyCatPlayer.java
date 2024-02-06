package org.example.player;

import org.example.Move;

public class CopyCatPlayer implements Player {
    private boolean isGainedInPreviousRound = false;
    @Override
    public Move makeMove() {
        Move move = Move.CHEAT;
        if (isGainedInPreviousRound) {
            move = Move.COOPERATE;
        }
        isGainedInPreviousRound = false;
        return move;
    }

    @Override
    public void gain() {
        this.isGainedInPreviousRound = true;
    }
}

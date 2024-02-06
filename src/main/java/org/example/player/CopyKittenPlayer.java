package org.example.player;

import org.example.Move;

public class CopyKittenPlayer implements Player {
    private boolean isGainedInPreviousRound = true;
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

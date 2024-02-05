package org.example;

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
        this.isInvestedInPreviousRound = !this.isInvestedInPreviousRound;
    }

    @Override
    public void gain() {
        this.isInvestedInPreviousRound = !this.isInvestedInPreviousRound;
    }
}

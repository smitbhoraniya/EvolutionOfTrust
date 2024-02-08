package org.example.player;

import org.example.Move;

public class DetectivePlayer extends Player {
    private boolean isInvestedInPreviousRound = false;
    private boolean isGainedInPreviousRound = false;
    private int roundNumber = 0;
    private boolean isCopyCat = false;
    @Override
    public Move makeMove() {
        this.roundNumber++;
        Move move = Move.CHEAT;
        if (this.roundNumber == 1) {
            move = Move.COOPERATE;
        }
        else if (this.roundNumber == 2) {
            move = Move.CHEAT;
        }

        if (this.isInvestedInPreviousRound && !this.isCopyCat) {
            this.isCopyCat = true;
        }
        if (this.isCopyCat && this.roundNumber > 2) {
            if (isGainedInPreviousRound) {
                move = Move.COOPERATE;
            }
            isGainedInPreviousRound = false;
        }

        return move;
    }

    @Override
    public void invest() {
        this.isInvestedInPreviousRound = true;
        super.invest();
    }

    @Override
    public void gain() {
        this.isGainedInPreviousRound = true;
        if (this.isInvestedInPreviousRound) {
            this.isInvestedInPreviousRound = false;
        }
        super.gain();
    }
}

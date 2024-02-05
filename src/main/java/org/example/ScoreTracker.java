package org.example;

public class ScoreTracker {
    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    public void update(Move playerOneMove, Move playerTwoMove) {
        if (playerOneMove == Move.CHEAT && playerTwoMove == Move.COOPERATE) {
            this.playerOneScore += 3;
            this.playerTwoScore -= 1;
        }
        else if (playerOneMove == Move.COOPERATE && playerTwoMove == Move.CHEAT) {
            this.playerOneScore -= 1;
            this.playerTwoScore += 3;
        }
        else if (playerOneMove == Move.COOPERATE && playerTwoMove == Move.COOPERATE) {
            this.playerOneScore += 2;
            this.playerTwoScore += 2;
        }
    }

    public int winner() {
        if (playerOneScore > playerTwoScore) {
            return 1;
        }
        else if (playerTwoScore > playerOneScore) {
            return -1;
        }
        return 0;
    }
}

package org.example;

import org.example.player.Player;

public class TrustTransaction {
    private final Player player1;
    private final Player player2;
    private final ScoreTracker scoreTracker;
    public TrustTransaction(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.scoreTracker = new ScoreTracker();
    }

    public void evaluate(int numberOfRound) {
        for (int i = 0; i < numberOfRound; i++) {
            Move player1Move = player1.makeMove();
            Move player2Move = player2.makeMove();

            if (player1Move == Move.COOPERATE) {
                player1.invest();
                player2.gain();
            }
            if (player2Move == Move.COOPERATE) {
                player2.invest();
                player1.gain();
            }
            scoreTracker.updateScores(player1Move, player2Move);
        }
    }

    public Player winner() {
        int player1Score = scoreTracker.getPlayerOneScore();
        int player2Score = scoreTracker.getPlayerTwoScore();
        if (player1Score > player2Score) {
            return player1;
        }
        else if (player2Score > player1Score) {
            return player2;
        }
        return null;
    }
}

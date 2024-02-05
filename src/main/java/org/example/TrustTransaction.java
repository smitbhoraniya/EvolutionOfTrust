package org.example;

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

            scoreTracker.update(player1Move, player2Move);
        }
    }

    public Player winner() {
        int winnerPlayer = this.scoreTracker.winner();
        if (winnerPlayer == 1) {
            return player1;
        }
        else if (winnerPlayer == -1) {
            return player2;
        }
        return null;
    }
}

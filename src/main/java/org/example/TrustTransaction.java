package org.example;

public class TrustTransaction {
    private final Player player1;
    private final Player player2;
    public TrustTransaction(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void evaluate(int numberOfRound) {
        for (int i = 0; i < numberOfRound; i++) {
            Move player1Move = player1.makeMove();
            Move player2Move = player2.makeMove();

            player1.updateScore(player2Move);
            player2.updateScore(player1Move);

            System.out.println("Player1 score: " + player1.getPoints());
            System.out.println("Player2 score: " + player2.getPoints());
        }
    }
}

package org.example;

import java.util.Random;

public class Player {
    private int points = 0;
    protected Move move;

    public Move makeMove() {
        Random random = new Random();
        int move = random.nextInt(2);
        this.move = move == 0 ? Move.CHEAT : Move.COOPERATE;
        return this.move;
    }

    public void updateScore(Move opponentMove) {
        if (this.move == null) {
            throw new UnsupportedOperationException("Make move and update the points.");
        }
        if (this.move == Move.CHEAT && opponentMove == Move.COOPERATE) {
            this.points += 3;
        }
        else if (this.move == Move.COOPERATE && opponentMove == Move.CHEAT) {
            this.points -= 1;
        }
        else if (this.move == Move.COOPERATE && opponentMove == Move.COOPERATE) {
            this.points += 2;
        }
        this.move = null;
    }

    public int getPoints() {
        return this.points;
    }
}

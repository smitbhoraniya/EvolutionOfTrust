package org.example;

import java.util.Scanner;

public class Player {
    private int points = 0;

    public void updateScore(Move myMove, Move opponentMove) {
        if (myMove == Move.CHEAT && opponentMove == Move.COOPERATE) {
            this.points += 3;
        }
        else if (myMove == Move.COOPERATE && opponentMove == Move.CHEAT) {
            this.points += -1;
        }
        else if (myMove == Move.COOPERATE && opponentMove == Move.COOPERATE) {
            this.points += 2;
        }
    }

    public int getScore() {
        return this.points;
    }
}

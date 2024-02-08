package org.example.player;

import org.example.Move;

import java.util.Random;

public class Player {
    private int score = 0;
    public Move makeMove() {
        Random random = new Random();
        return random.nextInt(Move.values().length) == 0 ? Move.CHEAT: Move.COOPERATE;
    }
    private void addScore(int score) {
        this.score += score;
    }

    public void gain() {
        this.addScore(3);
    }

    public void invest() {
        this.addScore(-1);
    }

    public int score() {
        return this.score;
    }

    public Player clone() {
        return new Player();
    }
}

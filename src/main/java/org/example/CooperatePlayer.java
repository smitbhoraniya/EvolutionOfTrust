package org.example;

public class CooperatePlayer extends Player {
    @Override
    public Move makeMove() {
        this.move = Move.COOPERATE;
        return Move.COOPERATE;
    }
}

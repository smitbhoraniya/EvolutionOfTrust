package org.example;

public class CooperatePlayer implements Player {
    @Override
    public Move makeMove() {
        return Move.COOPERATE;
    }
}

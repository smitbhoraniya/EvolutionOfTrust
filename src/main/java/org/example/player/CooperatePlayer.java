package org.example.player;

import org.example.Move;

public class CooperatePlayer extends Player {
    @Override
    public Move makeMove() {
        return Move.COOPERATE;
    }
}

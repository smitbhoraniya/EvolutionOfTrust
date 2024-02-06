package org.example.player;

import org.example.Move;

public class CooperatePlayer implements Player {
    @Override
    public Move makeMove() {
        return Move.COOPERATE;
    }
}

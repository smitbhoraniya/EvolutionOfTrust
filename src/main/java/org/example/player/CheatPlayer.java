package org.example.player;

import org.example.Move;

public class CheatPlayer extends Player {
    @Override
    public Move makeMove() {
        return Move.CHEAT;
    }
}

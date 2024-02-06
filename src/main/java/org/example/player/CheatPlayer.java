package org.example.player;

import org.example.Move;

public class CheatPlayer implements Player {
    @Override
    public Move makeMove() {
        return Move.CHEAT;
    }
}

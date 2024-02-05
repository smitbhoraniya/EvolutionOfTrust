package org.example;

public class CheatPlayer implements Player {
    @Override
    public Move makeMove() {
        return Move.CHEAT;
    }
}

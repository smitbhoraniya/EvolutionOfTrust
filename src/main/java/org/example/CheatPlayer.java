package org.example;

public class CheatPlayer extends Player {
    @Override
    public Move makeMove() {
        this.move = Move.CHEAT;
        return Move.CHEAT;
    }
}

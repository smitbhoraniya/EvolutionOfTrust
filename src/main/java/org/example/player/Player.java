package org.example.player;

import org.example.Move;

public interface Player {
    Move makeMove();
    default void gain() {}
    default void invest() {}
}

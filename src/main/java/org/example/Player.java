package org.example;

public interface Player {
    Move makeMove();
    default void gain() {}
    default void invest() {}
}

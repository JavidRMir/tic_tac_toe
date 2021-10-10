package com.elitespectra;

public enum Player {
    X("Player_X"),
    O("Player_O");

    public final String label;

    Player(String playerLabel) {
        this.label = playerLabel;
    }
}

package com.elitespectra;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TicTacToe {

    private final List<String> BOARD;
    private String playerTurn;

    public TicTacToe() {
        BOARD = new ArrayList<String>();
        reset();
    }


    public void play(String player, int spot) {
//        var spotsAvailable = getSpotsAvailable();
        if (getSpotsAvailable().contains(String.valueOf(spot))) {
            var spotIndex = BOARD.indexOf(String.valueOf(spot));
            BOARD.set(spotIndex, player);
        } else {
            throw new IllegalArgumentException(spot + " spot not available");
        }

    }

    public String playerWonOrGameDraw(String playerMark) {
        if (hasPlayerWon(playerMark))
            return "Won";

        if (getSpotsAvailable().size() == 0)
            return "Game Drawn";

        return "Game on";
    }


    public List<String> getSpotsAvailable() {
        return BOARD.stream().filter(s -> !s.equals("X") && !s.equals("O"))
                .collect(Collectors.toList());
    }

    public void reset() {

        BOARD.clear();

        BOARD.add("1");
        BOARD.add("2");
        BOARD.add("3");
        BOARD.add("4");
        BOARD.add("5");
        BOARD.add("6");
        BOARD.add("7");
        BOARD.add("8");
        BOARD.add("9");

    }

    private boolean hasPlayerWon(String playerMark) {

        return ((BOARD.get(0).equals(playerMark) && BOARD.get(1).equals(playerMark) && BOARD.get(2).equals(playerMark))
                ||
                (BOARD.get(3).equals(playerMark) && BOARD.get(4).equals(playerMark) && BOARD.get(5).equals(playerMark))
                ||
                (BOARD.get(6).equals(playerMark) && BOARD.get(7).equals(playerMark) && BOARD.get(8).equals(playerMark))
                ||
                (BOARD.get(0).equals(playerMark) && BOARD.get(3).equals(playerMark) && BOARD.get(6).equals(playerMark))
                ||
                (BOARD.get(1).equals(playerMark) && BOARD.get(4).equals(playerMark) && BOARD.get(7).equals(playerMark))
                ||
                (BOARD.get(2).equals(playerMark) && BOARD.get(5).equals(playerMark) && BOARD.get(8).equals(playerMark))
                ||
                (BOARD.get(0).equals(playerMark) && BOARD.get(4).equals(playerMark) && BOARD.get(8).equals(playerMark))
                ||
                (BOARD.get(2).equals(playerMark) && BOARD.get(4).equals(playerMark) && BOARD.get(6).equals(playerMark)));

    }

    public List<String> getBoard() {
        return List.copyOf(BOARD);
    }

}

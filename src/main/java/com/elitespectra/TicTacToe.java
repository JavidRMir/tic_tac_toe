package com.elitespectra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TicTacToe {

    private final List<String> BOARD;
    private Player nextPlayer = null;


    public TicTacToe() {
        BOARD = new ArrayList<String>();
        reset();
    }


    public void play(Player player, int spot) {

        if (nextPlayer != null && !player.equals(nextPlayer))
            throw new IllegalArgumentException("It's not " + player.label + "'s turn");

        if (getSpotsAvailable().contains(String.valueOf(spot))) {
            var spotIndex = BOARD.indexOf(String.valueOf(spot));
            BOARD.set(spotIndex, player.name());
            setNextPlayer(player);
        } else {
            throw new IllegalArgumentException(spot + " spot not available");
        }

    }


    public String playerWonOrGameDraw(Player player) {
        if (hasPlayerWon(player.name()))
            return "Won";

        if (getSpotsAvailable().size() == 0)
            return "Game Draw";

        return "Game on";
    }


    public List<String> getSpotsAvailable() {
        return BOARD.stream().filter(s -> !s.equals("X") && !s.equals("O"))
                .collect(Collectors.toList());
    }


    public void reset() {

        BOARD.clear();
        BOARD.addAll(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));

    }


    private boolean hasPlayerWon(String player) {

        return ((BOARD.get(0).equals(player) && BOARD.get(1).equals(player) && BOARD.get(2).equals(player))
                ||
                (BOARD.get(3).equals(player) && BOARD.get(4).equals(player) && BOARD.get(5).equals(player))
                ||
                (BOARD.get(6).equals(player) && BOARD.get(7).equals(player) && BOARD.get(8).equals(player))
                ||
                (BOARD.get(0).equals(player) && BOARD.get(3).equals(player) && BOARD.get(6).equals(player))
                ||
                (BOARD.get(1).equals(player) && BOARD.get(4).equals(player) && BOARD.get(7).equals(player))
                ||
                (BOARD.get(2).equals(player) && BOARD.get(5).equals(player) && BOARD.get(8).equals(player))
                ||
                (BOARD.get(0).equals(player) && BOARD.get(4).equals(player) && BOARD.get(8).equals(player))
                ||
                (BOARD.get(2).equals(player) && BOARD.get(4).equals(player) && BOARD.get(6).equals(player)));

    }


    public List<String> getBoard() {
        return List.copyOf(BOARD);
    }


    public Player getNextPlayer() {
        return nextPlayer;
    }


    private void setNextPlayer(Player player) {
        nextPlayer = player.equals(Player.X) ? Player.O : Player.X;
    }
}

package com.elitespectra;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class TicTacToeTest {

    TicTacToe ticTacToe = new TicTacToe();
    String playerX = "X";
    String playerO = "O";


    @BeforeEach
    public void setUp() {
        ticTacToe.reset();
    }

    @Test
    public void checkEmptySlotsAvailable() {

        assertEquals(9, ticTacToe.getSpotsAvailable().size());

        ticTacToe.play(playerX, 1);
        ticTacToe.play(playerO, 2);
        assertEquals(7, ticTacToe.getSpotsAvailable().size());

    }

    @Test
    public void checkHorizontalFieldsWin() {

        ticTacToe.play(playerX, 1);
        ticTacToe.play(playerO, 4);
        ticTacToe.play(playerX, 2);
        ticTacToe.play(playerO, 5);
        ticTacToe.play(playerX, 3);

        assertEquals("Won", ticTacToe.playerWonOrGameDraw(playerX));

    }

    @Test
    public void checkVerticalFieldsWin() {

        ticTacToe.play(playerO, 1);
        ticTacToe.play(playerX, 2);
        ticTacToe.play(playerO, 4);
        ticTacToe.play(playerX, 9);
        ticTacToe.play(playerO, 7);

        assertEquals("Won", ticTacToe.playerWonOrGameDraw(playerO));

    }

    @Test
    public void checkDiagonalFieldsWin() {

        ticTacToe.play(playerO, 3);
        ticTacToe.play(playerX, 1);
        ticTacToe.play(playerO, 5);
        ticTacToe.play(playerX, 4);
        ticTacToe.play(playerO, 7);

        assertEquals("Won", ticTacToe.playerWonOrGameDraw(playerO));
    }

    @Test
    public void checkGameDrawn() {

        ticTacToe.play(playerO, 1);
        ticTacToe.play(playerX, 2);
        ticTacToe.play(playerO, 3);
        ticTacToe.play(playerX, 4);
        ticTacToe.play(playerO, 5);
        ticTacToe.play(playerX, 7);
        ticTacToe.play(playerO, 6);
        ticTacToe.play(playerX, 9);
        ticTacToe.play(playerO, 8);

        assertEquals("Game Drawn", ticTacToe.playerWonOrGameDraw(playerO));
    }

}

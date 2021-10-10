package com.elitespectra;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;


public class TicTacToeTest {

    TicTacToe ticTacToe = new TicTacToe();

    @BeforeEach
    public void setUp() {
        ticTacToe.reset();
    }


    @Test
    public void checkEmptySlotsAvailable() {

        assertEquals(9, ticTacToe.getSpotsAvailable().size());

        ticTacToe.play(Player.X, 1);
        ticTacToe.play(Player.O, 2);
        assertEquals(7, ticTacToe.getSpotsAvailable().size());

    }


    @Test
    public void checkSpotValueZeroOrNegativeCanNotBeAccepted() {

        assertThrows(IllegalArgumentException.class, () ->
                ticTacToe.play(Player.X, 0));

        assertThrows(IllegalArgumentException.class, () ->
                ticTacToe.play(Player.X, -1));

    }


    @Test
    public void checkSpotValueMoreThan9CanNotBeAccepted() {

        assertThrows(IllegalArgumentException.class, () ->
                ticTacToe.play(Player.X, 10));

    }


    @Test
    public void checkNextPlayer() {

        ticTacToe.play(Player.X, 1);
        assertEquals(Player.O, ticTacToe.getNextPlayer());

    }

    @Test
    public void checkHorizontalFieldsWin() {

        ticTacToe.play(Player.X, 1);
        ticTacToe.play(Player.O, 4);
        ticTacToe.play(Player.X, 2);
        ticTacToe.play(Player.O, 5);
        ticTacToe.play(Player.X, 3);

        assertEquals("Won", ticTacToe.playerWonOrGameDraw(Player.X));

    }


    @Test
    public void checkVerticalFieldsWin() {

        ticTacToe.play(Player.O, 1);
        ticTacToe.play(Player.X, 2);
        ticTacToe.play(Player.O, 4);
        ticTacToe.play(Player.X, 9);
        ticTacToe.play(Player.O, 7);

        assertEquals("Won", ticTacToe.playerWonOrGameDraw(Player.O));

    }


    @Test
    public void checkDiagonalFieldsWin() {

        ticTacToe.play(Player.O, 3);
        ticTacToe.play(Player.X, 1);
        ticTacToe.play(Player.O, 5);
        ticTacToe.play(Player.X, 4);
        ticTacToe.play(Player.O, 7);

        assertEquals("Won", ticTacToe.playerWonOrGameDraw(Player.O));
    }


    @Test
    public void checkGameDraw() {

        ticTacToe.play(Player.O, 1);
        ticTacToe.play(Player.X, 2);
        ticTacToe.play(Player.O, 3);
        ticTacToe.play(Player.X, 4);
        ticTacToe.play(Player.O, 5);
        ticTacToe.play(Player.X, 7);
        ticTacToe.play(Player.O, 6);
        ticTacToe.play(Player.X, 9);
        ticTacToe.play(Player.O, 8);

        assertEquals("Game Draw", ticTacToe.playerWonOrGameDraw(Player.O));
    }

    @Test
    public void checkResetGame() {

        ticTacToe.reset();
        assertThat(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9"),
                Matchers.contains(ticTacToe.getBoard().toArray()));

    }

}

package com.elitespectra;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        TicTacToe ticTacToe = new TicTacToe();

        List<String> spotsAvailable = Collections.unmodifiableList(ticTacToe.getSpotsAvailable());

        Scanner spotInput = new Scanner(System.in);
        int spot;

        for (int i = 0; i < ticTacToe.getBoard().size(); i++) {
            System.out.println("Board " + ticTacToe.getBoard());
            if (i % 2 == 0) {
                System.out.print("Player X choose spot: ");
                spot = spotInput.nextInt();
                ticTacToe.play("X", spot);
            } else {
                System.out.print("Player O choose spot: ");
                spot = spotInput.nextInt();
                ticTacToe.play("O", spot);
            }
        }

        System.out.println("Final board: " + ticTacToe.getBoard());
        ticTacToe.reset();
        System.out.println("Reset Game Board: " + ticTacToe.getBoard());


    }
}

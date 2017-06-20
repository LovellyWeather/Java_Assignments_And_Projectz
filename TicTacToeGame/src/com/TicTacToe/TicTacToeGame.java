package com.TicTacToe;

import java.util.Scanner;

/**
 * Created by Tanner on 9/22/2015.
 */
public class TicTacToeGame {

    private static Marker X = new Marker("X");
    private static Marker O = new Marker("O");

    private Board myBoard;
    private String currentPlayer;
    private Scanner consoleInput;

    public TicTacToeGame() {

        myBoard = new Board();
        currentPlayer = new String("X");
        consoleInput = new Scanner(System.in);

    }


    public void playGame() throws InvalidCellException {

        while (myBoard.gameOver() != true) {
            myBoard.refreshBoard();
            System.out.println("Player " + "enter your move row:");
            int row = consoleInput.nextInt();
            System.out.println("Player " + "enter your move col:");
            int col = consoleInput.nextInt();

            myBoard.placeMarker(row, col, currentPlayer);

            if (currentPlayer.equals("X")) {
                currentPlayer = "O";
            } else {
                currentPlayer = "X";
            }



        }

    }

}

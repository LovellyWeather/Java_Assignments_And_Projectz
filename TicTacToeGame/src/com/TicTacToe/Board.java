package com.TicTacToe;

import com.sun.media.jfxmedia.events.MarkerEvent;

/**
 * Created by Tanner on 9/21/2015.
 */
public class Board {

    private Cell[][] board;

    public Board() {

        board = new Cell[3][3];

    }

    public boolean isFull() {
        boolean result = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j< 3; j++) {
                if (board[i][j] == null) {
                    result = false;
                }
            }
        }
        return result;
    }

    public boolean isWinner() {
        return (checkRows() || checkColumns() || checkDiagonal());
    }

    /*helper methods for checking for a winner */

    private boolean checkCells(Cell c1, Cell c2, Cell c3) {
        return ((c1 != null) && (c1.equals(c2)) && (c2.equals(c3)));
    }

    private boolean checkDiagonal() {
        return ((checkCells(board[0][0], board[1][1], board[2][2])) ||  (checkCells(board[0][2], board[1][1], board[2][0])));
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (checkCells(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (checkCells(board[i][0], board[i][1], board[i][2]) == true) {
                return true;
            }
        }
        return false;
    }

    public boolean gameOver() {
        return (isFull() || isWinner());
    }

    /*public String getWinner() {

    }*/

    public void refreshBoard() {        /*Work in progress*/
        for (int i = 0; i < 3; i++) {
            System.out.println("------------");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "| ");
            }
            System.out.println();
        }
    }

    public void replaceMarker(int row, int col, String aMarker) throws InvalidCellException {
        if ((row > 3) || (col > 3)){
            throw new InvalidCellException();
        } else {
            board[row][col].switchMarker(aMarker);
        }
    }

    public void placeMarker(int row, int col, String aMarker){
        board[row][col].switchMarker(aMarker);
    }



}

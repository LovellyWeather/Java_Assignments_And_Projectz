package com.TicTacToe;

/**
 * Created by Tanner on 9/21/2015.
 */
public class Cell {

    private String value;

    public Cell(){

        value = " ";
    }


    public String makeString(){
        if (this.value == null)  {
            return null;
        } else {
            return value;
        }
    }

    public String getMarker() throws EmptyCellException {
        if (this.value == null) {
            throw new EmptyCellException();
        } else {
            return value;
        }
    }

    public void removeMarker() {
        value = null;
    }

    public boolean isEmpty() {
        return value.equals(" ");
    }

    public void switchMarker(String aMarker) {
        value = aMarker;
    }
}

package com.TicTacToe;

/**
 * Created by Tanner on 9/21/2015.
 */
public class Marker {

    private String value;

    public Marker(String aValue){
        value = aValue;
    }

    public String changeToString(){
        return value;
    }

    public void changeMarker(String aString) {
        value = aString;
    }

    public boolean equals(Marker otherMarker){
        return this.value.equals(otherMarker.value);
    }

}

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Die userDie = new Die();
        Die compDie = new LoadedDie();

        Scanner consoleInput = new Scanner(System.in);

        System.out.print("(H)igh or (L)ow?");
        String guess = consoleInput.next().toUpperCase();


        int userRoll = userDie.roll();
        int compRoll = compDie.roll();

        String result;

        if (userRoll >= compRoll) {
            result ="H";
        } else {
            result ="L";
        }

        if (guess.equals(result)) {
            System.out.println("Your Roll:" + userRoll);
            System.out.println("Computer roll:" + compRoll);
            System.out.println("You Won!");
        } else {
            System.out.println("Your Roll:" + userRoll);
            System.out.println("Computer roll:" + compRoll);
            System.out.println("You Lost!");

        }

    }

}


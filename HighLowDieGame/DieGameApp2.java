/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diegameapp2;

import java.util.Scanner;

/**
 *
 * @author Tanner
 */
public class DieGameApp2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Die userDie = new Die();
	    Die compDie = new Die();

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

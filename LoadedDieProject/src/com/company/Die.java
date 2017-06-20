package com.company;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;

/**
 *
 * @author Tanner
 */
public class Die {
   //----------------------------------------------------------------------------------
    // Instance Variables
    //----------------------------------------------------------------------------------
    private int numSides;
    private int currentValue;
    private Random myRandomNumGenerator;
      
    
    //----------------------------------------------------------------------------------
    //Constructors
    //----------------------------------------------------------------------------------
   
    /** 
     * Default constructor creates a 6-sided die.
     */
    public Die()
    {
        numSides = 6;
        myRandomNumGenerator = new Random();
        roll();
    }
    
    /** 
     * This constructor takes in a single integer value and create a die with
     * that number of sides.
     * 
     * @param aNumSides Number of sides to create on the die.
     */
    public Die(int aNumSides)
    {
        numSides = aNumSides;
        myRandomNumGenerator = new Random();
        roll();
    }
    
    
    
    //----------------------------------------------------------------------------------
    //Class Methods
    //----------------------------------------------------------------------------------
    
    /** 
     * Getter for the number of sides on the die.
     * 
     * @return The number of sides on the die.
     */
    public int getNumOfSides() 
    {
        return numSides;
    }
    
    
    /** 
     * Getter for the number of sides on the die.
     * 
     * @return The number of sides on the die.
     */
    public int getCurrentValue() 
    {
        return currentValue;
    }
       
    /** 
     * Rolls the die to get a random value.
     * 
     * @return A random value between 1 and the number of sides.
     */
    public int roll() 
    {
        currentValue = myRandomNumGenerator.nextInt(numSides) + 1;
        return currentValue;
    } 
}

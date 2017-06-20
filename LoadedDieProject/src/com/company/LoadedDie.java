package com.company;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Tanner on 10/11/2015.
 */
public class LoadedDie extends Die {

    private int loadedSide;
    private int chanceOfRoll;


    public LoadedDie() {

        super();
        loadedSide = 1;
        chanceOfRoll = 50;

    }

    public LoadedDie(int aSide, int aChance) {

        super();
        loadedSide = aSide;
        chanceOfRoll = aChance;

    }

    @Override
    public int roll() {

        ArrayList<Integer> listOfSides = new ArrayList<>();
        listOfSides.add(1);
        listOfSides.add(2);
        listOfSides.add(3);
        listOfSides.add(4);
        listOfSides.add(5);
        listOfSides.add(6);

        listOfSides.remove(loadedSide);

        Random randValue = new Random();

        if (randInt() < chanceOfRoll) {
            return loadedSide;
        } else {
            int index = randValue.nextInt(listOfSides.size());
            return index;
        }

    }

    private int randInt() {

        Random rand = new Random();

        int randomNumber = rand.nextInt((100) + 1);

        return randomNumber;
    }

}
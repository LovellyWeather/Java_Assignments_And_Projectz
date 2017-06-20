package com.company;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Tanner on 10/13/2015.
 */
public class LoadedDieTest extends LoadedDie {

    private LoadedDie testDie1 = new LoadedDie(1,90);
    private LoadedDie testDie2 = new LoadedDie(2,70);
    private LoadedDie testDie3 = new LoadedDie(3,50);

    @Before
    public void setup() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void testRoll1() throws Exception {

        int successfulRolls = 0;
        for (int i = 0; i < 1000; i++) {
            if (testDie1.roll() == 1) {
                successfulRolls += 1;
            }
        }
        assertEquals(900, successfulRolls, 100);
    }

    @Test
    public void testRoll2() throws Exception {

        int successfulRolls = 0;
        for (int i = 0; i < 1000; i++) {
            if (testDie2.roll() == 2) {
                successfulRolls += 1;
            }
        }
        assertEquals(700, successfulRolls, 100);
    }

    @Test
    public void testRoll3() throws Exception {

        int successfulRolls = 0;
        for (int i = 0; i < 1000; i++) {
            if (testDie3.roll() == 3) {
                successfulRolls += 1;
            }
        }
        assertEquals(500, successfulRolls, 100);
    }
}
package com.goit.groupTask.TEST;


import com.goit.groupTask.Exceptions.InputIsEmptyException;
import com.goit.groupTask.LuhnAlgorithm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Администратор on 1/27/2016.
 */
public class LuhnAlgorithmTest {

    @Test
    public void testCheckNumber() throws Exception {
        String number1 = "489";
        String number2 = "488";

        assertEquals(true, LuhnAlgorithm.checkNumber(number1));
        assertEquals(false, LuhnAlgorithm.checkNumber(number2));

    }

    @Test(expected = InputIsEmptyException.class)
    public void testCheckNumberException() throws Exception {
        String number = "";

        assertEquals(true, LuhnAlgorithm.checkNumber(number));
    }

}
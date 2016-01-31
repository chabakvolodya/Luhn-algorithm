package com.goit.groupTask;

import com.goit.groupTask.Exceptions.*;

import java.util.ArrayList;

/**
 * Created by Администратор on 22.01.2016.
 */
public abstract class LuhnAlgorithm {

    private static final int LUHN_MULTIPLIER = 2;
    private static final int LUHN_THRESHOLD = 10;
    private static final int LUHN_SUBTRAHEND = 9;
    private static final int ZERO = 0;
    private static final String LUHN_CHARACTERS_FOR_PARSING_INPUT = "[\\\\,A-Za-z\u0410-\u042f\u0430-\u044f\\-/| ]";

    public static boolean checkNumber(String number){

        boolean result = false;

        number = number.replaceAll(LUHN_CHARACTERS_FOR_PARSING_INPUT, "");

        ArrayList<Integer> listIntegers = new ArrayList<>();

        int sumAllNumbers = 0;

        verification(number);   //Перевірка номера

        for (int index = 0; index < number.length(); index++){

            int tempNumber = Integer.parseInt((String.valueOf(number.charAt(index))));

            if (numberOrEvenNumberLength(number.length())) {   // Якщо розмір номеру == парне число
                if (numberOrEvenNumberLength(index)){   //Якщо index == парне число
                    if (tempNumber * LUHN_MULTIPLIER > LUHN_SUBTRAHEND){
                        tempNumber = tempNumber * LUHN_MULTIPLIER - LUHN_SUBTRAHEND;
                    }
                    else {
                        tempNumber *= LUHN_MULTIPLIER;
                    }
                }
                listIntegers.add(index, tempNumber);
            }
            else {
                if (!numberOrEvenNumberLength(index)){  //Якщо index == НЕ парне число
                    if (tempNumber * LUHN_MULTIPLIER > LUHN_SUBTRAHEND){
                        tempNumber = tempNumber * LUHN_MULTIPLIER - LUHN_SUBTRAHEND;
                    }
                    else {
                        tempNumber *= LUHN_MULTIPLIER;
                    }
                }
                listIntegers.add(index, tempNumber);
            }
        }
        for (int num : listIntegers){
            sumAllNumbers = num + sumAllNumbers;
        }
        if (sumAllNumbers % LUHN_THRESHOLD == ZERO){
            result = true;
        }
        return result;
    }

    private static void verification(String number){

        if (number.length() == ZERO) throw new InputIsEmptyException();
    }

    private static boolean numberOrEvenNumberLength(int length){
        boolean result = false;
        int divisor = 2;

        if (length % divisor == ZERO) result = true;
        return result;
    }
}

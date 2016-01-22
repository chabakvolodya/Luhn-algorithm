package com.goit.groupTask;

import com.goit.groupTask.Exceptions.*;

import java.util.ArrayList;

/**
 * Created by Администратор on 22.01.2016.
 */
public abstract class MethodMoon {

    public static boolean checkNumber(String number){

        boolean status = false;

        number = number.replaceAll("[\\\\,A-Za-z\u0410-\u042f\u0430-\u044f\\-/| ]", "");

        ArrayList<Integer> integers = new ArrayList<>();

        int sum = 0;

        verification(number);   //Перевірка номера

        for (int i = 0; i < number.length(); i++){

            int temp = Integer.parseInt((String.valueOf(number.charAt(i))));

            if (number.length() % 2 == 0) {   // Якщо розмір парне число
                if (i % 2 == 0){
                    if (temp * 2 > 9){
                        temp = temp * 2 - 9;
                    }
                    else {
                        temp *= 2;
                    }
                }
                integers.add(i, temp);
            }
            else {
                if (i % 2 != 0){
                    if (temp * 2 > 9){
                        temp = temp * 2 - 9;
                    }
                    else {
                        temp *= 2;
                    }
                }
                integers.add(i, temp);
            }
        }
        for (int num : integers){
            sum = num + sum;
        }
        if (sum % 10 == 0){
            status = true;
        }
        return status;
    }

    private static void verification(String number){

        if (number.length() == 0) throw new InputIsEmptyException();
    }
}

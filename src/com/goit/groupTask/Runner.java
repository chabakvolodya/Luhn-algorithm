package com.goit.groupTask;

import com.goit.groupTask.Exceptions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Администратор on 22.01.2016.
 */
public class Runner {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        boolean valid;
        boolean statusLoop = true;

        while (statusLoop){

            System.out.println("Input: ");
            input = reader.readLine();

            switch (input){
                case "exit": statusLoop = false; break;

                default:
                    try {
                        valid = MethodMoon.checkNumber(input);

                        if (valid) {
                            System.out.println("Номер правильний!");
                        }
                        else {
                            System.err.println("Номер НЕ правильний!");
                        }

                    } catch (InputIsEmptyException e){
                        System.err.println("Ви не ввели номеру.");
                    } finally {
                        System.out.println("\n");
                    }
            }
        }
    }
}
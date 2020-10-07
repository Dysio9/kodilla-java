package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("SimpleUser test - OK");
        } else {
            System.out.println("SimpleUser - Error!");
        }

        System.out.println("------------------------------------");

        Calculator calculator = new Calculator();

        int calculatorResult = calculator.add(1,5);
        if (calculatorResult == 6) {
            System.out.println("Addition is OK");
        } else {
            System.out.println("Addition Error!");
        }

        calculatorResult = calculator.subtract(50,9);
        if (calculatorResult == 41) {
            System.out.println("Subtraction is OK");
        } else {
            System.out.println("Subtraction Error!");
        }
    }
}
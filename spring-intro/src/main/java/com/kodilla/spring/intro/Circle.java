package com.kodilla.spring.intro;

public class Circle implements Shape {

    @Override
    public String draw() {
        System.out.println("This is a circle from class");
        return "This is a circle";
    }
}
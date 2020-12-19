package com.kodilla.spring.intro;

public class Triangle implements Shape {

    @Override
    public String draw() {
        System.out.println("This is a triangle from class");
        return "This is a triangle";
    }
}

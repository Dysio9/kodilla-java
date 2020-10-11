package com.kodilla.testing.shape;

public class Circle implements Shape {

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public String getField() {
        return "PI * r^2";
    }
}

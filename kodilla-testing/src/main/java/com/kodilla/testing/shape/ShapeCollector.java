package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    List<Shape> shapes = new ArrayList<>();

    public boolean addFigure(Shape shape) {
        boolean result = false;
        if (shapes.add(shape)) {
            result = true;
        }
        return result;
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i).getShapeName().equals(shape.getShapeName())) {
                shapes.remove(i);
                result = true;
            }
        }
        return result;
    }

    public Shape getFigure(int n) {
        if (shapes.size() <= 0) {
            return null;
        }
        return shapes.get(n);
    }

    public String showFigures() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < shapes.size(); i++) {
            stringBuilder.append(shapes.get(i).getShapeName());
            if (i < shapes.size()-1) {
                stringBuilder.append(" ");
            }
        }
        return String.valueOf(stringBuilder);
    }
}

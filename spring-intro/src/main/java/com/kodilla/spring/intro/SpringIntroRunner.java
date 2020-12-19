package com.kodilla.spring.intro;

public class SpringIntroRunner {

    public static void main(String[] args) {
        Drawer drawer = new Drawer(new Circle());
        System.out.println(drawer.doDrawing());
    }
}

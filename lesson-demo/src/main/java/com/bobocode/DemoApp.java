package com.bobocode;

public class DemoApp {
    public static void main(String[] args) {
        var annotation = MagicClass.class.getAnnotation(Marker.class);
        System.out.println(annotation.value());
    }
}

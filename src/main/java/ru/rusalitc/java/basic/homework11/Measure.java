package ru.rusalitc.java.basic.homework11;

public class Measure {
    private static long time;

    public static void stamp() {
        time = System.currentTimeMillis();
    }

    public static void print() {
        time = System.currentTimeMillis() - time;
        System.out.println("Время сортировки, мс: " + time);
    }
}


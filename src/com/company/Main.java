package com.company;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    enum DayTime {
        NOCHES,
        DIAS,
        TARDES
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = greetings(scanner);
        communicate(scanner, name);
    }

    static String greetings(Scanner scanner) {
        System.out.println("Enter your name, please");
        String name = scanner.nextLine();
        switch (checkTime()) {
            case DIAS -> System.out.println("¡Buenas dias " + name + "!");
            case TARDES -> System.out.println("¡Buenas tardes " + name + "!");
            case NOCHES -> System.out.println("¡Buenas noches " + name);
        }
        return name;
    }

    static DayTime checkTime() {
        LocalTime time = LocalTime.now();
        if (time.isAfter(LocalTime.of(6, 0)) && time.isBefore(LocalTime.of(12,0)))
            return DayTime.DIAS;
        if (time.isBefore(LocalTime.of(20,0)))
            return DayTime.TARDES;
        return DayTime.NOCHES;
    }

    static void communicate(Scanner scanner, String name) {
        boolean isStop = false;
        while (!isStop) {
            String message = scanner.nextLine();
            if (message.equalsIgnoreCase("stop!")){
                System.out.println("Adios " + name);
                isStop = true;
            }
            String reverse = String.valueOf(new StringBuffer(message).reverse());
            System.out.println(reverse);
            if (message.equals(reverse)) {
                System.out.println("¡Bonita palabra!");
            }
        }
    }
}

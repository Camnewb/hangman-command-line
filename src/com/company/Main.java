package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int stage = 6;

        exitCheck(scanner);

        print(StaticText.introText());
        print(StaticText.hangMan(stage));


    }

    public static void print(String string) {
        System.out.println(string);
    }

    public static void exitCheck(Scanner scanner) {
        Runnable runnable = () -> {
            while (true) {
                if(scanner.nextLine().toLowerCase().equals("exit")) {
                    System.exit(1);
                }
            }
        };

        Thread t = new Thread(runnable);
        t.start();
    }

    public static void guessCheck(Scanner scanner) {
        Runnable runnable = () -> {
            while (true) {
                if(scanner.nextLine().toLowerCase().equals("exit")) {

                }
            }
        };

        Thread t = new Thread(runnable);
        t.start();
    }
}

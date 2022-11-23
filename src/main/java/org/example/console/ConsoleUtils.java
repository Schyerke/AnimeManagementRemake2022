package org.example.console;

public class ConsoleUtils {
    private ConsoleUtils() {
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

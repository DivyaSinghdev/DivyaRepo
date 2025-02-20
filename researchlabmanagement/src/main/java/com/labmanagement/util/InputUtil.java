package com.labmanagement.util;

import java.util.Scanner;
import java.util.function.Consumer;

public class InputUtil {

    public static String generateId(String prefix, int count) {
        return String.format("%s%03d", prefix, count + 1);
    }

    public static String readStringInput(Scanner scanner, String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static int readIntInput(Scanner scanner, String prompt) {
        System.out.println(prompt);
        return scanner.nextInt();
    }

    public static <T> void updateField(Scanner scanner, Consumer<T> updateAction, T value) {
        updateAction.accept(value);
        scanner.nextLine(); // Consume newline
    }
}


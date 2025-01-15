package org.example;

import java.util.Scanner;

public class ConsoleService {

    private Scanner scanner = new Scanner(System.in);
    public void welcomePrompt() {
        System.out.println("*******************************");
        System.out.println("Welcome to Planetary Calculator");
        System.out.println("*******************************");
    }


    public String promptForString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public Double promptForDouble(String prompt) {
        System.out.println(prompt);
        while (true) {
            try {
                double number = Double.parseDouble(scanner.nextLine());
                while (number < 0 ) {
                    System.out.println("Please enter a number greater than 0.");
                    number = Double.parseDouble(scanner.nextLine());
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a decimal number.");
            }
        }
    }
}

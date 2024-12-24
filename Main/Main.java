package Main;

import PassSec.PassSec;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean stillHere = true;

        while (stillHere) {
            displayMainMenu();

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    handlePasswordStrengthTest(scanner);
                    break;
                case "2":
                    handlePasswordGeneration();
                    break;
                default:
                    System.out.println("Invalid option selected. Please try again.");
            }

            stillHere = askToContinue(scanner);
        }

        System.out.println("Thanks for using PassSec from ThreatForge!");
    }

    private static void displayMainMenu() {
        System.out.println("What do you wish to do?");
        System.out.println("1 - Test password strength");
        System.out.println("2 - Generate a new password");
        System.out.print("Enter your choice: ");
    }

    private static void handlePasswordStrengthTest(Scanner scanner) {
        System.out.print("What's your password? ");
        String passwordString = scanner.nextLine();
        PassSec pass = new PassSec(passwordString);
        
        pass.verify();
        System.out.println("Analyzing password strength...");

        if (pass.getLevel() <= 4) {
            System.out.println("Your password is " + pass.getStrength() + ". Do you want to generate a better one?");
            System.out.println("1 - Yes");
            System.out.println("2 - No");
            System.out.print("Enter your choice: ");
            String choice2 = scanner.nextLine();
            if (choice2.equals("1")) {
                pass.regenPass();
                System.out.println("Your new password is: " + pass.getPass());
            }
        }
    }

    private static void handlePasswordGeneration() {
        PassSec pass = new PassSec("");
        pass.regenPass();
        System.out.println("Your new password is: " + pass.getPass());
    }

    private static boolean askToContinue(Scanner scanner) {
        System.out.println("Do you want to:");
        System.out.println("1 - Leave");
        System.out.println("2 - Reevaluate or test another password");
        System.out.print("Enter your choice: ");
        String choice3 = scanner.nextLine();
        return choice3.equals("2");
    }
}

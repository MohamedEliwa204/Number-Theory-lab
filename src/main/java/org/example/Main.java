package org.example;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=====================================");
            System.out.println("what you want to solve?(q to quit)");
            System.out.println("Prime Number Checker (press 1)!");
            System.out.println("Prime Factorization (press 2)!");
            System.out.println("GCD and LCM Computation (press 3)!");
            System.out.println("=====================================");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine().trim();

            if (choice.equalsIgnoreCase("q")) {
                System.out.println("Thank you for using the program. Goodbye!");
                break;
            }

            switch (choice) {
                case "1":
                    handlePrimeChecker(scanner);
                    break;
                case "2":
                    handlePrimeFactorization(scanner);
                    break;
                case "3":
                    handleGCDandLCM(scanner);
                    break;
                default:
                    System.out.println("Invalid option! Please enter 1, 2, 3, or q to quit.");
            }
        }

        scanner.close();
    }

    private static void handlePrimeChecker(Scanner scanner) {
        PrimeNumberChecker checker = new PrimeNumberChecker();
        System.out.print("Enter a number to check if it's prime: ");
        try {
            int number = Integer.parseInt(scanner.nextLine().trim());
            boolean isPrime = checker.isPrime(number);

            if (isPrime) {
                System.out.println("✓ " + number + " is a PRIME number!");
            } else {
                System.out.println("✗ " + number + " is NOT a prime number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer.");
        }
    }

    private static void handlePrimeFactorization(Scanner scanner) {
        PrimeNumberChecker checker = new PrimeNumberChecker();
        System.out.print("Enter a number to factorize: ");
        try {
            int number = Integer.parseInt(scanner.nextLine().trim());

            if (number <= 1) {
                System.out.println("Error: Please enter a number greater than 1.");
                return;
            }

            List<Integer> factors = checker.getAllFactors(number);
            String formatted = factors.toString();

            System.out.println("Prime factorization of " + number + ": " + formatted);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer.");
        }
    }

    private static void handleGCDandLCM(Scanner scanner) {
        System.out.print("Enter the first number: ");
        try {
            int a = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Enter the second number: ");
            int b = Integer.parseInt(scanner.nextLine().trim());

            // Handle special case: both numbers are 0
            if (a == 0 && b == 0) {
                System.out.println("Error: GCD(0, 0) is undefined.");
                return;
            }

            // Convert to absolute values for calculation
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            int gcdEuclidean = GCDandLCM.EuclideanGCD(absA, absB);
            int lcmEuclidean = GCDandLCM.LCMRelatedGCD(absA, absB);

            System.out.println("\n--- Results ---");
            if (a != absA || b != absB) {
                System.out.println("Note: Using absolute values |" + a + "| = " + absA + ", |" + b + "| = " + absB);
            }
            System.out.println("Using Euclidean Algorithm:");
            System.out.println("  GCD(" + a + ", " + b + ") = " + gcdEuclidean);
            System.out.println("  LCM(" + a + ", " + b + ") = " + lcmEuclidean);

            System.out.println("\n\nUsing Prime Factorization:");
            GCDandLCM.displayGCDandLCMWithSteps(absA, absB);

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid integers.");
        }
    }
}
package org.example;

import java.util.Map;
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
        System.out.print("Enter a number to check if it's prime: ");
        try {
            int number = Integer.parseInt(scanner.nextLine().trim());
            boolean isPrime = SieveOfEratosthenes.IsPrimes(number);

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
        System.out.print("Enter a number to factorize: ");
        try {
            int number = Integer.parseInt(scanner.nextLine().trim());

            if (number <= 1) {
                System.out.println("Error: Please enter a number greater than 1.");
                return;
            }

            Map<Integer, Integer> factors = PrimeFactorization.getPrimeFactorization(number);
            String formatted = PrimeFactorization.formatFactors(factors);

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

            if (a <= 0 || b <= 0) {
                System.out.println("Error: Please enter positive integers.");
                return;
            }

            int gcdEuclidean = GCDandLCM.EuclideanGCD(a, b);
            int lcmEuclidean = GCDandLCM.LCMRelatedGCD(a, b);

            System.out.println("\n--- Results ---");
            System.out.println("Using Euclidean Algorithm:");
            System.out.println("  GCD(" + a + ", " + b + ") = " + gcdEuclidean);
            System.out.println("  LCM(" + a + ", " + b + ") = " + lcmEuclidean);

            System.out.println("\n\nUsing Prime Factorization:");
            GCDandLCM.displayGCDandLCMWithSteps(a, b);

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid integers.");
        }
    }
}
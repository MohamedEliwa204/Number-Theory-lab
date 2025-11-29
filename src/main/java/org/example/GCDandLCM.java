package org.example;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GCDandLCM {
    public static int EuclideanGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return EuclideanGCD(b, a % b);
    }

    public static int LCMRelatedGCD(int a, int b) {
        // LCM is 0 if either number is 0
        if (a == 0 || b == 0) {
            return 0;
        }
        int gcd = GCDandLCM.EuclideanGCD(a, b);
        int lcm = (a / gcd) * b;
        return lcm;
    }



    public static void displayGCDandLCMWithSteps(int a, int b) {
        if (a == 0 || b == 0) {
            System.out.println("\nNote: Prime factorization method doesn't apply when one number is 0");
            System.out.println("GCD(" + a + ", " + b + ") = " + Math.max(a, b));
            System.out.println("LCM(" + a + ", " + b + ") = 0");
            return;
        }

        Map<Integer, Integer> factorsA = PrimeFactorization.getPrimeFactorization(a);
        Map<Integer, Integer> factorsB = PrimeFactorization.getPrimeFactorization(b);
        String formattedA = PrimeFactorization.formatFactors(factorsA);
        String formattedB = PrimeFactorization.formatFactors(factorsB);
        System.out.println("\nStep 1: Find prime factorization of each number");
        System.out.println("  " + a + " = " + formattedA);
        System.out.println("  " + b + " = " + formattedB);

        Set<Integer> allPrimes = new HashSet<>();
        allPrimes.addAll(factorsA.keySet());
        allPrimes.addAll(factorsB.keySet());

        System.out.println("\nStep 2: Calculate GCD (take minimum power of each common prime)");
        StringBuilder gcdSteps = new StringBuilder();
        int gcd = 1;
        boolean hasCommonPrime = false;

        for (Integer prime : allPrimes) {
            int powerA = factorsA.getOrDefault(prime, 0);
            int powerB = factorsB.getOrDefault(prime, 0);

            if (powerA > 0 && powerB > 0) {
                int minPower = Math.min(powerA, powerB);
                System.out.println("  Prime " + prime + ": min(" + powerA + ", " + powerB + ") = " + minPower);

                if (hasCommonPrime) {
                    gcdSteps.append(" × ");
                }
                if (minPower == 1) {
                    gcdSteps.append(prime);
                } else {
                    gcdSteps.append(prime).append("^").append(minPower);
                }
                gcd *= (int) Math.pow(prime, minPower);
                hasCommonPrime = true;
            }
        }

        if (hasCommonPrime) {
            System.out.println("  GCD = " + gcdSteps + " = " + gcd);
        } else {
            System.out.println("  No common primes, GCD = 1");
            gcd = 1;
        }

        System.out.println("\nStep 3: Calculate LCM (take maximum power of each prime)");
        StringBuilder lcmSteps = new StringBuilder();
        int lcm = 1;
        boolean first = true;

        for (Integer prime : allPrimes) {
            int powerA = factorsA.getOrDefault(prime, 0);
            int powerB = factorsB.getOrDefault(prime, 0);
            int maxPower = Math.max(powerA, powerB);

            System.out.println("  Prime " + prime + ": max(" + powerA + ", " + powerB + ") = " + maxPower);

            if (!first) {
                lcmSteps.append(" × ");
            }
            if (maxPower == 1) {
                lcmSteps.append(prime);
            } else {
                lcmSteps.append(prime).append("^").append(maxPower);
            }
            lcm *= (int) Math.pow(prime, maxPower);
            first = false;
        }

        System.out.println("  LCM = " + lcmSteps + " = " + lcm);

        System.out.println("\n--- Final Results ---");
        System.out.println("GCD(" + a + ", " + b + ") = " + gcd);
        System.out.println("LCM(" + a + ", " + b + ") = " + lcm);
    }
}

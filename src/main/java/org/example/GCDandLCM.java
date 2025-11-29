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
        int gcd = GCDandLCM.EuclideanGCD(a, b);
        int lcm = (a / gcd) * b;
        return lcm;
    }

    public static int GCDFactorization(int a, int b) {
        Map<Integer, Integer> Afactors = PrimeFactorization.getPrimeFactorization(a);
        Map<Integer, Integer> Bfactors = PrimeFactorization.getPrimeFactorization(b);
        int gcd = 1;
        for (Integer prime : Afactors.keySet()) {
            if (Bfactors.containsKey(prime)) {
                int powerA = Afactors.get(prime);
                int powerB = Bfactors.get(prime);

                int minPower = Math.min(powerA, powerB);
                gcd *= (int) Math.pow(prime, minPower);
            }
        }
        return gcd;
    }

    public static int LCMFactorization(int a, int b) {
        Map<Integer, Integer> Afactors = PrimeFactorization.getPrimeFactorization(a);
        Map<Integer, Integer> Bfactors = PrimeFactorization.getPrimeFactorization(b);

        Set<Integer> allPrimes = new HashSet<>();
        allPrimes.addAll(Afactors.keySet());
        allPrimes.addAll(Bfactors.keySet());

        int lcm = 1;
        for (Integer prime : allPrimes) {
            int powerA = Afactors.getOrDefault(prime, 0);
            int powerB = Bfactors.getOrDefault(prime, 0);

            int maxPower = Math.max(powerA, powerB);
            lcm *= (int) Math.pow(prime, maxPower);
        }
        return lcm;
    }
}

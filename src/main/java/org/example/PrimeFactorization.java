package org.example;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrimeFactorization {
    public static Map<Integer, Integer> getPrimeFactorization(int n) {
        Map<Integer, Integer> factors = new LinkedHashMap<>();
        while (n % 2 == 0) {
            factors.merge(2, 1, Integer::sum);
            n /= 2;
        }

        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.merge(i, 1, Integer::sum);
                n /= i;
            }
        }
        if (n > 1) {
            factors.merge(n, 1, Integer::sum);
        }
        return factors;
    }

    public static String formatFactors(Map<Integer, Integer> factors) {
        return factors.entrySet().stream()
                .map(entry -> entry.getKey() + "^" + entry.getValue())
                .collect(Collectors.joining(" x "));
    }
}

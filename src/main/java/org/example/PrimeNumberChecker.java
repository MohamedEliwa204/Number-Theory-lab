package org.example;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberChecker {
    private List<Boolean> arr;

    public Boolean isPrime(Integer n) {
        n = Math.abs(n);
        setArr(n);

        for(int p = 2; p < Math.sqrt(n); p++) {
            if(arr.get(p)) {
                for(int i = p*p; i <= n; i+=p) {
                    arr.set(i, false);
                }
            }
        }
        return arr.get(n);
    }

    public List<Integer> getAllFactors(Integer n) {
        List<Integer> result = new ArrayList<>();
        n = Math.abs(n);

        while((n % 2) == 0) {
            result.add(2);
            n /= 2;
        }

        for(int i = 3; i*i < n; i += 2) {
            while((n % i) == 0) {
                result.add(i);
                n /= i;
            }
        }

        if(n > 2) result.add(n);

        return result;
    }

    private void setArr(Integer n) {
        this.arr = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            arr.add((i != 0) && (i != 1));
        }
    }

    public static void main(String[] args) {
        PrimeNumberChecker primeChecker = new PrimeNumberChecker();

        System.out.println(primeChecker.getAllFactors(100));
    }
}

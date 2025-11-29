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

    public List<Integer> getAllPrimes(Integer n) {
        List<Integer> result = new ArrayList<>();
        n = Math.abs(n);
        setArr(n);

        for(int p = 2; p < Math.sqrt(n); p++) {
            if(arr.get(p)) {
                for(int i = p*p; i <= n; i+=p) {
                    arr.set(i, false);
                }
            }
        }

        for(int i = 0; i <= n; i++) {
            if (arr.get(i)) result.add(i);
        }
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

        System.out.println(primeChecker.getAllPrimes(100));
    }
}

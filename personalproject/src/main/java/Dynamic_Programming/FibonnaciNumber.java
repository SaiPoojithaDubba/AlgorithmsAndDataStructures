package Dynamic_Programming;

import java.util.HashMap;
import java.util.Map;

public class FibonnaciNumber {
    public static void main(String[] args) {
        FibonnaciNumber f = new FibonnaciNumber();
        System.out.println(f.getNthFibonnaciNumber(25, new HashMap<Integer, Integer>()));
    }

    public Integer getNthFibonnaciNumber(int number, Map<Integer, Integer> memo) {
        if (memo.containsKey(number)) return memo.get(number);
        if (number <= 2) return 1;
        int targetSum = getNthFibonnaciNumber(number - 1, memo) + getNthFibonnaciNumber(number - 2, memo);
        memo.put(number, targetSum);
        return memo.get(number);
    }
    //Time & Space Complexities with and without memoization
    //BruteForce: Time - O(2^n) Space - O(n)
    //After Memoization: Time - O(n) Space - O(n)
}

package Dynamic_Programming;

import java.util.HashMap;
import java.util.Map;

public class CanSum {
    public static void main(String[] args) {
        CanSum c = new CanSum();
        System.out.println(c.canGivenElementsOfArrayAddUpToTargetSum(5000, new int[]{2, 3, 5},
                new HashMap<Integer, Boolean>()));
    }

    public boolean canGivenElementsOfArrayAddUpToTargetSum(int targetSum, int[] input, Map<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;
        for (int num : input) {
            int remainder = targetSum - num;
            if (canGivenElementsOfArrayAddUpToTargetSum(remainder, input, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }

    //Time & Space Complexities with and without memoization
    //BruteForce: Time - O(n^m) Space - O(m)
    //After Memoization: Time - O(n*m) Space - O(m)
}

package Dynamic_Programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BestSum {

    public static void main(String[] args) {
        BestSum b = new BestSum();
        System.out.println(Arrays.toString(
                b.getSmallestCombinationOfElementsWhichAddUpToTargetSumIfPresent(7, new int[]{5, 3, 4, 7},
                        new HashMap<Integer, int[]>())));
    }

    public int[] getSmallestCombinationOfElementsWhichAddUpToTargetSumIfPresent(int targetSum, int[] input,
                                                                                Map<Integer, int[]> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return new int[]{};
        if (targetSum < 0) return null;
        int[] shortestArray = null;
        for (int num : input) {
            int remainder = targetSum - num;
            int[] remainderResult = getSmallestCombinationOfElementsWhichAddUpToTargetSumIfPresent(remainder, input, memo);
            if (remainderResult != null) {
                int[] temp = Arrays.copyOf(remainderResult, remainderResult.length + 1);
                temp[temp.length - 1] = num;
                if (shortestArray == null || temp.length < shortestArray.length) {
                    shortestArray = temp;
                }
            }
        }
        memo.put(targetSum, shortestArray);
        return shortestArray;
    }

    //Time & Space Complexities with and without memoization
    //BruteForce: Time - O(n^m*m) Space - O(m*m)
    //After Memoization: Time - O(n*m*m) Space - O(m*m)
}

package Dynamic_Programming.Memoization;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HowSum {
    public static void main(String[] args) {
        HowSum h = new HowSum();
        System.out.println(Arrays.toString(
                h.getCombinationOfElementsWhichAddUpToTargetSumIfPresent(3, new int[]{2, 2, 2},
                        new HashMap<Integer, int[]>())));
    }

    public int[] getCombinationOfElementsWhichAddUpToTargetSumIfPresent(int targetSum, int[] input,
                                                                        Map<Integer, int[]> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return new int[]{};
        if (targetSum < 0) return null;
        for (int num : input) {
            int remainder = targetSum - num;
            int[] remainderResult = getCombinationOfElementsWhichAddUpToTargetSumIfPresent(remainder, input, memo);
            if (remainderResult != null) {
                int[] tempArray = Arrays.copyOf(remainderResult, remainderResult.length + 1);
                tempArray[tempArray.length - 1] = num;
                memo.put(targetSum, tempArray);
                return tempArray;
            }
        }
        memo.put(targetSum, null);
        return null;
    }

    //Time & Space Complexities with and without memoization
    //BruteForce: Time - O(n^m*m) Space - O(m)
    //After Memoization: Time - O(n*m*m) Space - O(m*m)

}

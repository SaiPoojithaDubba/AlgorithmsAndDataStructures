package Dynamic_Programming.Memoization;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {
    public static void main(String[] args) {
        CountConstruct c = new CountConstruct();
        System.out.println(c.getnumberOfPossibleWaysToConstructTargetFromGivenBagOfWords("purple",
                new String[]{"pu", "ur", "pur", "ple"}, new HashMap<String, Integer>()));
    }

    public int getnumberOfPossibleWaysToConstructTargetFromGivenBagOfWords(String target, String[] words, Map<String, Integer> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target.equals("")) return 1;
        int totalCount = 0;
        for (String word : words) {
            if (target.startsWith(word)) {
                int count = getnumberOfPossibleWaysToConstructTargetFromGivenBagOfWords(target.substring(word.length()),//this operation takes extra `m` time and space
                        words, memo);
                totalCount += count;
            }
        }
        memo.put(target, totalCount);
        return totalCount;
    }

    //Time & Space Complexities with and without memoization
    //BruteForce: Time - O((n^m)*m) Space - O(m*m)
    //After Memoization: Time - O(n*m) Space - O(m*m)
}

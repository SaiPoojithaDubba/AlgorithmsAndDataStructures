package Dynamic_Programming.Memoization;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    public static void main(String[] args) {
        CanConstruct c = new CanConstruct();
        System.out.println(c.canConstructTargetFromGivenBagOfWords("purple",
                new String[]{"p", "ur", "pur", "ple"}, new HashMap<String, Boolean>()));
    }

    public boolean canConstructTargetFromGivenBagOfWords(String target, String[] words,
                                                         Map<String, Boolean> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target.equals("")) return true;
        for (String word : words) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());//this operation takes extra `m` time and space
                if (canConstructTargetFromGivenBagOfWords(suffix, words, memo)) {
                    memo.put(target, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;
    }

    //Time & Space Complexities with and without memoization
    //BruteForce: Time - O((n^m)*m) Space - O(m*m)
    //After Memoization: Time - O(n*m) Space - O(m*m)
}

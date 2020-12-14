package Dynamic_Programming.Memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AllConstruct {

    public static void main(String[]args){
        AllConstruct allConstruct = new AllConstruct();
        System.out.println(allConstruct.getAllCombinationOfStringsForGivenTarget(
                "abcdef",new String[]{"ab","abc","cd","def","abcd","ef","c"}, new HashMap<>()));
    }
    public List<List<String>> getAllCombinationOfStringsForGivenTarget(String target, String[]words,
                                                                       Map<String,List<List<String>>>memo) {
        List<List<String>> output = new ArrayList<>(0);
        if(memo.containsKey(target)) return memo.get(target);
        if(target.isEmpty()){
            output.add(new ArrayList<>());
            return output;
        }
        for(String word:words){
            if(target.startsWith(word)){
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = getAllCombinationOfStringsForGivenTarget(suffix,words,memo);
                List<List<String>> targetWays = new ArrayList<>(0);
                for (List<String>suffixList:suffixWays) {
                   List<String>temp = new ArrayList<>(0);
                   temp.add(word);
                   temp.addAll(suffixList);
                   targetWays.add(temp);
                }
                output.addAll(targetWays);
            }
        }
        memo.put(target,output);
        return output;
    }
    //here we are storing n^m leaves to the tree that means n^m combination which in turn leads to n^m subarrays
    //therefore we have O(n^m) time and O(n^m*m) space complexity even with memoization
    //here memoization doesn't make much difference as we have to compute for exponential output(n^m) subarrays

}

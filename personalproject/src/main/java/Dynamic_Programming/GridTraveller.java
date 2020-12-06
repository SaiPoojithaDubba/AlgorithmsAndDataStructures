package Dynamic_Programming;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {
    public int getNumberOfWaysOneCanTravelInGivenGrid(int rows, int columns, Map<String,Integer>memo) {
        String memoKey = rows+","+columns;
        if(memo.containsKey(memoKey)) return memo.get(memoKey);
        if (rows == 1 && columns == 1) return 1;
        if (rows == 0 || columns == 0) return 0;
        Integer tempWays = getNumberOfWaysOneCanTravelInGivenGrid(rows - 1, columns, memo) +
                getNumberOfWaysOneCanTravelInGivenGrid(rows, columns - 1, memo);
        memo.put(memoKey,tempWays);
        return memo.get(memoKey);
    }
    public static void main(String[] args){
        GridTraveller g = new GridTraveller();
        System.out.println(g.getNumberOfWaysOneCanTravelInGivenGrid(30,30, new HashMap<String, Integer>()));
    }
    //Time & Space Complexities with and without memoization
    //BruteForce: Time - O(2^(m+n)) Space - O(m+n)
    //After Memoization: Time - O(n*m) Space - O(m+n)
}

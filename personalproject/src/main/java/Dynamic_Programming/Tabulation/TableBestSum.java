package Dynamic_Programming.Tabulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TableBestSum {

    public static void main(String[] args) {
        TableBestSum b = new TableBestSum();
        System.out.println(b.getSmallestCombinationOfElementsWhichAddUpToTargetSumIfPresent(8, new int[]{2, 4}));
    }

    public List<Integer> getSmallestCombinationOfElementsWhichAddUpToTargetSumIfPresent(int targetSum, int[] input) {
        List<List<Integer>> table = new ArrayList<>(Collections.nCopies(targetSum + 1, null));
        table.set(0, new ArrayList<>());
        for (int i = 0; i <= targetSum; i++) {
            if (table.get(i) != null) {
                for (int num : input) {
                    int newIndex = i + num;
                    if (newIndex <= targetSum) {
                        int initialSize = table.get(newIndex) == null ? 0 : table.get(newIndex).size();
                        if (table.get(newIndex) == null || table.get(i).size() + 1 < initialSize) {
                            table.set(newIndex, table.get(i).stream().map(Integer::new).collect(Collectors.toList()));
                            table.get(newIndex).add(num);
                        }
                    }
                }
            }
        }
        return table.get(targetSum);
    }
    //Time - O(m*n*m) Space - O(m*m) where m is targetSum and n is length of inputArray
}

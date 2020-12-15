package Dynamic_Programming.Tabulation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TableHowSum {
    public static void main(String[] args) {
        TableHowSum h = new TableHowSum();
        System.out.println(
                h.getCombinationOfElementsWhichAddUpToTargetSumIfPresent(7, new int[]{4, 3, 3}));
    }

    public List<Integer> getCombinationOfElementsWhichAddUpToTargetSumIfPresent(int targetSum, int[] input) {
        List<List<Integer>> table = new ArrayList<>();
        for (int i = 0; i <= targetSum; i++) {
            table.add(i, null);
        }
        table.set(0, new ArrayList<>());
        for (int i = 0; i <= targetSum; i++) {
            if (table.get(i) != null) {
                for (int num : input) {
                    int newIndex = num + i;
                    if (newIndex <= targetSum) {
                        table.set(newIndex, table.get(i).stream().map(Integer::new).collect(Collectors.toList()));
                        table.get(newIndex).add(num);
                    }
                }
            }
        }
        return table.get(targetSum);
    }
    //Time - O(m*n*m) Space - O(m*m) where m is targetSum and n is length of inputArray
}

package Dynamic_Programming.Tabulation;

public class TableCountConstruct {
    public static void main(String[] args) {
        TableCountConstruct c = new TableCountConstruct();
        System.out.println(c.getnumberOfPossibleWaysToConstructTargetFromGivenBagOfWords("purple",
                new String[]{"pu", "ur", "pur", "ple"}));
    }

    public int getnumberOfPossibleWaysToConstructTargetFromGivenBagOfWords(String target, String[] words) {
        int targetLength = target.length();
        int[] table = new int[targetLength + 1];
        table[0] = 1;
        for (int i = 0; i <= target.length(); i++) {
            if (table[i] != 0) {
                for (String word : words) {
                    int newIndex = i + word.length();
                    if (newIndex <= targetLength && word.equals(target.substring(i, newIndex)))
                        table[newIndex] += table[i];
                }
            }
        }
        return table[targetLength];
    }
    //Time - O(m*n*m) Space - O(m) where m is targetSum and n is length of inputArray
}

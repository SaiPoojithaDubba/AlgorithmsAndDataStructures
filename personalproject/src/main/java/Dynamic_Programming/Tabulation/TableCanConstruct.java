package Dynamic_Programming.Tabulation;

public class TableCanConstruct {

    public static void main(String[] args) {
        TableCanConstruct canConstruct = new TableCanConstruct();
        System.out.println(canConstruct.canConstructTargetFromGivenBagOfWords("purple",
                new String[]{"p", "ur", "pur", "ple"}));
    }

    public boolean canConstructTargetFromGivenBagOfWords(String target, String[] words) {
        int targetLength = target.length();
        boolean[] table = new boolean[targetLength + 1];
        table[0] = true;
        for (int i = 0; i <= targetLength; i++) {
            if (table[i]) {
                for (String word : words) {
                    int newLength = i + word.length();
                    if (newLength <= targetLength && word.equals(target.substring(i,newLength)))
                        table[newLength] = true;
                }
            }
        }
        return table[targetLength];
    }

    //Time - O(m*n*m) Space - O(m) where m is targetSum and n is length of inputArray
}

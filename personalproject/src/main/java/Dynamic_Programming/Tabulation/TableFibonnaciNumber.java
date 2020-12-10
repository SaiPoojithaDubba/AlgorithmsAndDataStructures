package Dynamic_Programming.Tabulation;

public class TableFibonnaciNumber {
    public static void main(String[] args) {
        TableFibonnaciNumber t = new TableFibonnaciNumber();
        System.out.println(t.getNthFibonnaciNumber(8));
    }

    public Integer getNthFibonnaciNumber(int number) {
        int[] table = new int[number + 1];
        table[1] = 1;
        for (int i = 0; i < number; i++) {
            table[i + 1] += table[i];
            if (i != number - 1) table[i + 2] += table[i];
        }
        return table[number];
    }
    //After Tabulation: Time - O(n) Space - O(n)
}

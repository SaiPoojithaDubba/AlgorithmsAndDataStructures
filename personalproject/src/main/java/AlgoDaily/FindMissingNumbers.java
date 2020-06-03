package AlgoDaily;

public class FindMissingNumbers {
    private int[] a;
    private int size;

    public FindMissingNumbers(int[] inputArray, int count) {
        this.size = count;
        this.a = new int[count];
        this.a = inputArray;
    }

    public void MissingNumbers() {
        for (int i = 0; i < size - 1; i++) {
            if (a[i] == a[i + 1] - 1) {
                continue;
            } else {
                int difference = (a[i+1] - a[i])-1;
                int j=difference;
                int missingNumber = a[i];
                while(j>0) {
                    missingNumber = missingNumber+1;
                    System.out.println("the missing number is " + missingNumber);
                    j--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{3, 7, 9, 19};
        FindMissingNumbers findMissingNumbers = new FindMissingNumbers(inputArray,4);
        findMissingNumbers.MissingNumbers();
    }

}

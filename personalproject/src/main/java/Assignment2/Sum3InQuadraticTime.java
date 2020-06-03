package Assignment2;

import java.util.ArrayList;

public class Sum3InQuadraticTime {
    private int myArray[];
    private int capacity;
    private int triples = 0;
    public Sum3InQuadraticTime(int capacity){
        this.capacity = capacity;
        this.myArray = new int[]{10,20,30,40,50,-60,-71,-80,-90,-91};
    }

    public int findTriplesThatSumToZero(){
        for(int i = 0; i< capacity - 2;i++) {
            int j = i+1;
            int k = capacity-1;
            while (j < k) {
                int sum = myArray[i] + myArray[j] + myArray[k];
                if (sum == 0) {
                    System.out.println("the triples are " + myArray[i] + " , " + myArray[j] + " , " + myArray[k]);
                    triples++;
                } if(sum>0){
                    --k;
                }else{
                    ++j;
                }

            }
        }
        return triples;
    }
}

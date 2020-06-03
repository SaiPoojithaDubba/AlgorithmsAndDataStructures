package Assignment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Duplicates {
    public List<Integer> findDuplicates(int[]numbers) {
        List<Integer> output = new ArrayList<Integer>();
        int count = numbers.length/10;
        int counter = 1;
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]!=numbers[i+1]){
                if(counter>count){
                    output.add(numbers[i]);
                }
                counter=1;
            }else{
                counter++;
                }
            }
        if(counter>count){
            output.add(numbers[numbers.length-1]);
        }
        return  output;
    }

    public static void main(String[] args) {
        int[] nuts = new int[] {1,2,7,2,2,3,4,5,6,7};
        Duplicates sk = new Duplicates();
        List<Integer> output = sk.findDuplicates(nuts);
        int x = 0;

    }
}

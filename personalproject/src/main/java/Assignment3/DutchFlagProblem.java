package Assignment3;

import static Assignment3.DutchFlagProblem.Pebble.white;

public class DutchFlagProblem {

    enum Pebble{
        red,
        white,
        blue
    };
    private Pebble[] pebbles;

    private Pebble color(int i){
        return pebbles[i];
    }

    private int compareTo(Pebble i) {
        return i.ordinal() - white.ordinal();
    }

    private void sort(Pebble[] buckets) {
        int red = 0;
        int blue = buckets.length -1;
        int runner = 0;
        while(runner<=blue){
            Pebble colorOfBucket = color(runner);
            if(compareTo(colorOfBucket)< 0){
                swap(buckets,red++,runner++);
            }else if(compareTo(colorOfBucket)>0) {
                swap(buckets,runner,blue--);
            }else {
                runner++;
            }
        }

    }

    private void swap(Pebble[] buckets, int i, int j) {
        Pebble temp = buckets[i];
        buckets[i] = buckets[j];
        buckets[j] = temp;
    }

}

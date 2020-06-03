package Assignment4;

import edu.princeton.cs.algs4.StdOut;

public class NutsAndBolts {
    private final char[] nuts;
    private final char[] bolts;
    public NutsAndBolts(char[] nuts, char[] bolts){
        this.nuts = nuts;
        this.bolts = bolts;
        int high = bolts.length-1;
        matchNutsAndBolts(0,high,nuts,bolts);
    }

    private void matchNutsAndBolts(int low, int high, char[] nuts, char[] bolts) {
        if (low < high) {
            int pivot = partition(nuts, low, high, bolts[high]);
            partition(bolts, low, high, nuts[pivot]);
            matchNutsAndBolts(low, pivot - 1, nuts, bolts);
            matchNutsAndBolts(pivot + 1, high, nuts, bolts);
        }
    }

    private int partition(char[]a,int low,int high,char pivot){
        int i = low;
        for (int j = low; j < high; j++)
        {
            if(a[j]<pivot){
                exchange(i,j,a);
                i++;
            }else if(a[j]==pivot){
                exchange(j,high,a);
                j--;
            }
        }
        exchange(i,high,a);
        return i;
    }

    private void exchange(int i, int j, char[]a){
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        char[] nuts = new char[] { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i' };
        char[] bolts = new char[] { 'i', 'u', 'y', 't', 'r', 'e', 'w', 'q' };


        NutsAndBolts nb = new NutsAndBolts(nuts, bolts);
        int x = 0;

    }
}

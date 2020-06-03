package Assignment4;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSelect {
    private int partition(Comparable[]a,int lo, int hi){
        int i = lo;
        int j = hi+1;
        while(true){
            while(less(a[++i],a[lo])){
                if(i==hi) break;
            }
            while(less(a[lo], a[--j])){
                if(j==lo) break;
            }
            if(i>=j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }

    private void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    private boolean less(Comparable a, Comparable b) {
        return a.compareTo(b)<0;
    }

    public Comparable select(Comparable[]a,int k){
        StdRandom.shuffle(a);
        int i =0;
        int j = a.length-1;
        while(i<j){
            int pivot = partition(a,i,j);
            if(pivot<k) j=pivot-1;
            if(pivot>k) i = pivot+1;
            else return a[k];
        }
        return a[k];
    }
}

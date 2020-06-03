package Assignment4;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort
{
    private static int partition(Comparable[] a, int lo, int hi)
    {
        int i = lo, j = hi+1;
        while (true)
        {
            while (less(a[++i], a[lo]))
                if (i == hi) break;
            while (less(a[lo], a[--j]))
                if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;

    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b)<0;
    }

    private static void exch(Comparable[] a,int g, int h) {
        Comparable temp = a[g];
        a[g] = a[h];
        a[h] = temp;
    }

    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }
    public static void main(String[] args) {
        Comparable[] nuts = new Comparable[]{3,2,4,5,6};
        QuickSort q = new QuickSort();
        q.sort(nuts);
        int x = 0;

    }

}

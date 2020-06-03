package Assignment4;

public class ThreeWayPartitioning {

    public void sort(Comparable[]a,int lo,int hi) {
        Comparable v = a[lo];
        int i = lo;
        int lt = lo;
        int gt = hi;
        while(i<=gt){
            int cmp = a[i].compareTo(v);
            if(cmp<0) exch(a[i++], a[lt++]);
            if(cmp>0) exch(a[i],a[gt--]);
            else i++;
        }
        sort(a, lo,lt-1);
        sort(a, gt+1, hi);
    }

    private void exch(Comparable a, Comparable b) {
        Comparable temp = a;
        a = b;
        b = temp;
    }
}

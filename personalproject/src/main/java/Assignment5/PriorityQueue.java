package Assignment5;

public class PriorityQueue<key extends  Comparable<key>> {
    key[] pq;
    int N;

    public PriorityQueue(){}

    public PriorityQueue(int capacity) {
        pq = (key[]) new Comparable[capacity+1];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void insertKey(key k){
        pq[++N] = k;
        swim(N);
    }

    private void swim(int n) {
        while (n > 1 && less(n/2, n))
        {
            exch(n, n/2);
            n = n/2;
        }
    }

    private void sink(int n){
        while (2*n<=N){
            int j = 2*n;
            if(j<N && less(j,j+1)) j++;
            if(less(j,n)) break;
            exch(n,j);
            n=j;
        }
    }

    public void heapSort(Comparable[]a){
        int n = a.length;
        for(int k = n/2;k>=1;k--){
            sink(a,k,n);
        }
        while(n>1){
            exch(n--,1);
            sink(a,1,n);
        }
    }

    void sink(Comparable[] a, int n, int k) {
        while (2*n<=k){
            int j = 2*n;
            if(j<k && less(j,j+1)) j++;
            if(less(j,n)) break;
            exch(n,j);
            n=j;
        }
    }

    public key delMax(){
        key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null;
        return max;
    }
    public boolean less(int i, int j){
        return pq[i].compareTo(pq[j])<0;
    }

    public void exch(int i, int j) {
        key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}

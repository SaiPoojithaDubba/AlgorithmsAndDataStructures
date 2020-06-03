package Assignment5;

import edu.princeton.cs.algs4.StdRandom;

public class RamndomizedPQ extends PriorityQueue {

    public int sample() {
        return StdRandom.uniform(1, N);
    }

    public Comparable delRandom() {
        int i = sample();
        Comparable randomdel = pq[i];
        exch(i,N--);
        sink(pq,i,N);
        return randomdel;
    }
}

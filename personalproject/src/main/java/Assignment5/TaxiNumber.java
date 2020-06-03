package Assignment5;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class TaxiNumber {
    private class taxi implements Comparable<taxi>{
        private int a;
        private int b;
        private int cube;
        public taxi(int a, int  b){
            this.a = a;
            this.b = b;
            this.cube = a*a*a+b*b*b;
        }

        @Override
        public int compareTo(taxi that) {
            if (that.cube > this.cube) return -1;
            if (that.cube < this.cube) return 1;
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof taxi) {
                if (((taxi)o).compareTo(this) == 0)
                    return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return "number: " + cube + " (" + a + ", " + b + ")";
        }
    }
    private MinPQ<taxi> minPQ;
    public TaxiNumber(int N){
        minPQ = new MinPQ<taxi>(N+1);
    }

    public void findTaxiNumbers(int N){
        TaxiNumber t = new TaxiNumber(N);
        for(int i=1;i<N;i++){
            for(int j = i+1;j<=N;j++){
                taxi cab = new taxi(i,j);
                if(minPQ.size()<N){
                    minPQ.insert(cab);
                }else{
                    Queue<taxi> temp = new Queue<taxi>();
                    taxi min = minPQ.delMin();
                    while(minPQ.min().equals(min)){
                        temp.enqueue(minPQ.delMin());
                    }
                    if(!cab.equals(min)){
                        minPQ.insert(cab);
                    }
                    else{
                        temp.enqueue(cab);
                    }
                    if (!temp.isEmpty()) {
                        for (taxi taxii: temp) {
                            System.out.println(taxii);
                        }
                        System.out.println(min);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TaxiNumber t = new TaxiNumber(12);
        t.findTaxiNumbers(12);
    }
}

package Assignment5;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.MinPQ;

public class MedianPQ {
    private MinPQ<Integer>minPQ;
    private MaxPQ<Integer>maxPQ;

    public MedianPQ(){
        minPQ = new MinPQ<Integer>();
        maxPQ = new MaxPQ<Integer>();
    }

    public void insertKey(int key){
        double median = findMedian();
        if(key<=median){
            maxPQ.insert(key);
            if(maxPQ.size()-minPQ.size()>1){
                minPQ.insert(maxPQ.delMax());
            }else{
                minPQ.insert(key);
                if(minPQ.size()-maxPQ.size()>1){
                    maxPQ.insert(minPQ.delMin());
                }
            }
        }
    }

    public double findMedian(){
        int minSize = minPQ.size();
        int maxSize = maxPQ.size();
        if(minSize==maxSize){
            return ((double)minPQ.min()+(double)maxPQ.max())/2;
        }else if(maxSize>minSize) return maxPQ.max();
        else return minPQ.min();
    }

    public void removeMedian() {
        int minSize = minPQ.size();
        int maxSize = maxPQ.size();
        if(maxSize>minSize){
            maxPQ.delMax();
        }else if(minSize>maxSize){
            minPQ.delMin();
        }else{
            double median = findMedian();
            if(median == maxPQ.max()){
                maxPQ.delMax();
            }else{
                minPQ.delMin();
            }
        }
    }
}

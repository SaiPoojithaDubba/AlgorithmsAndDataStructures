package Assignment2;

import java.util.List;

public class BitonicArray {

    private List<Integer> myArray;

    public BitonicArray(List<Integer> inputArray) {
        this.myArray = inputArray;
    }

    public int peakOfTheArray(int first,int last){
        int mid = (first+last)/2;
        if(first==last) return mid;
        else if(myArray.get(mid+1)>myArray.get(mid)){
            return peakOfTheArray(mid+1,last);
        }else{
            return peakOfTheArray(first,mid);
        }
    }

    private boolean bitonicSearch(int start, int end, int target, boolean desc) {
        int mid = (start +end)/2;
        if(myArray.get(mid)==target) return true;
        if (start > end) {
            return false;
        }
        if ((desc && myArray.get(mid) < target) || (!desc && myArray.get(mid) > target)) {
            return bitonicSearch(start, mid-1, target, desc);
        } else {
            return bitonicSearch(mid+1, end, target, desc);
        }
    }

    public boolean find(int peak,int target) {
        return bitonicSearch(peak,myArray.size()-1,target,true) ||
                bitonicSearch(0,peak,target,false);
    }

}

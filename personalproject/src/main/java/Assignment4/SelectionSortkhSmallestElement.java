package Assignment4;

import java.util.Arrays;

public class SelectionSortkhSmallestElement {
    public int kthsmallestElementinTwoSortedArrays(int[]a,int[]b,int i,int j,int k) {
        if(i==0 || j==0){
            return minimum(a[i],b[j]);
        }
       if(a[i]<b[j-1]){
           i=((i+1)+minimum((a.length-1),k))/2;
           return kthsmallestElementinTwoSortedArrays(a,b,i,k-i-1,k);
       }else if(a[i-1]>b[j]){
           i--;
           return kthsmallestElementinTwoSortedArrays(a,b,i,k-i-1,k);
       }
       return minimum(a[i],b[j]);
    }

    public static void main(String[] args) {
        int[] nuts = new int[] {1,3,7,9,10};
        int[] bolts = new int[] {2,4,6,8};
        SelectionSortkhSmallestElement sk = new SelectionSortkhSmallestElement();
        int i = (nuts.length-1)/2;
        int k = 4;
        int output = sk.kthsmallestElementinTwoSortedArrays(nuts,bolts,i,k-i-1,k);
        int x = 0;

    }
    public int minimum(int a ,int b){
        return (a<b)?a:b;
    }
}

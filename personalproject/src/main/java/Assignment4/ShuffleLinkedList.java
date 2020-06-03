package Assignment4;

import edu.princeton.cs.algs4.StdRandom;

public class ShuffleLinkedList<Item> {
    private class Node{
        Item first;
        Node next;
    }

    public void shuffle(Node head,int N) {
        int h = 0;
        int rh = (N/2)-1;
        Node mid = head;
        int k = 0;
        while(k<N/2){
            mid=mid.next;
            k++;
        }
        Node mid1 = mid;
        shuffle(head,N/2);
        shuffle(mid1,N-N/2);
        merge(head,mid1);
    }
    private void merge(Node lh, Node rh) {
        Node left = lh;
        Node right = rh;
        Node runner = lh;
        while(left !=null || right !=null) {
            if(left == null || StdRandom.uniform()>0){
                runner.next = right;
                right = right.next;
            }else if(right == null || StdRandom.uniform()<0) {
                runner.next = left;
                left = left.next;
            }
        }

    }
}

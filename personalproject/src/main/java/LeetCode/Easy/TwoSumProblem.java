package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class TwoSumProblem {
    private class ListNode{
        public int first;
        public ListNode next;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode output = null;
        do{
            int sum = 0;
            if(l1==null || l2==null){
                sum = (l1==null)?l2.first:l1.first;
            }else{
                sum = l1.first + l2.first;
            }
            ListNode temp = new ListNode();
            ListNode carrier = new ListNode();
            if(sum<10){
                temp.first = sum;
                temp.next = output;
                output = temp;
            }else{
                int unitsDigit = sum%10;
                int tensDigit  = sum/10;
                temp.first = unitsDigit;
                temp.next = output;
                output = temp;
                if(l1!=null && l1.next!=null) {
                    l1.next.first = l1.next.first + tensDigit;
                }else if(l2!=null && l2.next!=null){
                    l2.next.first = l2.next.first + tensDigit;
                }
                else {
                    carrier.first = tensDigit;
                    carrier.next = output;
                    output = carrier;
                }
            }
            l1 = (l1==null)?null: l1.next;
            l2 = (l2==null)?null:l2.next;
        }while(l1 != null || l2!=null);
        return reverseSinglyLinkedList(output);
    }

    public static void main(String[] args) {
        TwoSumProblem t = new TwoSumProblem();
        List<Integer> a = new ArrayList<Integer>();
//        a.add(2);
//        a.add(4);
//        a.add(3);
        a.add(1);
        //a.add(8);
        List<Integer> b = new ArrayList<Integer>();
//        b.add(5);
//        b.add(6);
//        b.add(4);
        b.add(9);
        b.add(9);
        ListNode listNode1 = t.insertIntoSinglyLinkedList(a);
        ListNode listNode2 = t.insertIntoSinglyLinkedList(b);
        ListNode output = t.addTwoNumbers(listNode1,listNode2);
        int x = 0;
    }

    public ListNode insertIntoSinglyLinkedList(List<Integer>p) {
        ListNode g = null;
        for (Integer number: p) {
           ListNode temp = new ListNode();
           temp.first = number;
           temp.next = g;
           g = temp;
        }
        return g;
    }

    public ListNode reverseSinglyLinkedList(ListNode p) {
        ListNode current = p;
        if(current == null) {
            return current;
        }else if(current.next==null){
            return current;
        }
        ListNode newHeadNode = reverseSinglyLinkedList(current.next);
        current.next.next = current;
        current.next = null;
        return  newHeadNode;
    }
}

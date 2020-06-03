package Assignment3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    public Node first;
    public Node last;
    public int count;

    public class Node{
        public Item item;
        public Node next;
        public Node prev;
    }

    // construct an empty deque
    public Deque(){
        first = null;
        last = null;
        count =0;

    }

    private class ListIterator implements Iterator<Item> {
        private Node current;
        public ListIterator(Node initialNode) {
            current = initialNode;
        }
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    // is the deque empty?
    public boolean isEmpty(){
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        return count;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if(item == null) {
            throw new IllegalArgumentException();
        }
        else if(first == null){
            first = new Node();
            first.item = item;
            last = first;
        }else {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            oldFirst.prev = first;
        }
        count++;
    }

    // add the item to the back
    public void addLast(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }else if(first == null) {
            last = new Node();
            last.item = item;
            first = last;
        }else {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            last.prev = oldLast;
            oldLast.next = last;
        }
        count++;
    }

    // remove and return the item from the front
    public Item removeFirst(){
        Item item = null;
        if(first == null){
            throw new NoSuchElementException();
        }
        if(first == last){
            item = first.item;
            first = null;
            last = null;
        }else{
            item = first.item;
            first = first.next;
            first.prev = null;
        }
        count--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast(){
        Item item = null;
        if(first == null) {
            throw new NoSuchElementException();
        }else if(count == 1){
            item = first.item;
            first = null;
            last = null;
        }else {
            item = last.item;
            last = last.prev;
            last.next = null;
        }
        count--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new ListIterator(first);
    }

}

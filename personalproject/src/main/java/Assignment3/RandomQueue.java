package Assignment3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomQueue<Item> implements Iterable<Item> {
    // construct an empty randomized queue
    private Deque doom;
    public RandomQueue(){
        doom = new Deque();
    }

    // is the randomized queue empty?
    public boolean isEmpty(){
        return doom.isEmpty();
    }

    // return the number of items on the randomized queue
    public int size() {
        return doom.size();
    }

    // add the item
    public void enqueue(Item item){
        doom.addLast(item);
    }

    // remove and return a random item
    public Item dequeue(){
        return (Item) doom.removeFirst();
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (doom.count == 0) {
            throw new java.util.NoSuchElementException();
        }
        return (Item) randomNode().item;
    }

    private Deque.Node randomNode() {
        int randomIndex = StdRandom.uniform(0, doom.count);
        int currentIndex = 0;
        Deque.Node node = doom.first;
        while (currentIndex < randomIndex) {
            node = node.next;
            currentIndex++;
        }
        return node;
    }

    private class RandomListIterator implements Iterator<Item> {
        private int current = 0;
        private Item[] items;

        public RandomListIterator() {
            items = (Item[]) new Object[size()];
            Deque.Node node = doom.first;
            int i = 0;
            while (node != null) {
                items[i++] = (Item) node.item;
                node = node.next;
            }
            StdRandom.shuffle(items);
        }

        public boolean hasNext() {
            return current < doom.count;
        }

        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return items[current++];
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new RandomListIterator();
    }


}

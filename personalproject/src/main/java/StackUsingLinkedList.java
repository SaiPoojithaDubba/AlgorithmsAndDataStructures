public class StackUsingLinkedList {
    private Node first = null;
    private class Node{
        private String item;
        private Node next;
    }
    public void push(String item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
    public String pop(){
        String item = first.item;
        first = first.next;
        return item;
    }

}

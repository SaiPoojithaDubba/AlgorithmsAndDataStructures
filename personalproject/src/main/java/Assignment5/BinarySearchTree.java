package Assignment5;


import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BinarySearchTree <Key extends Comparable<Key>,Value> {
    private class Node {
        private Key ke;
        private Value val;
        private Node right;
        private Node left;
        private int count;

        public Node(Key key, Value val){
            this.ke = key;
            this.val = val;
        }

    }

    private Node root;

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.count;
    }

    public void put(Key key, Value val)
    {
        root = put(root,key,val);
    }

    private Node put(Node x, Key key, Value val) {
        if(x==null) return new Node(key,val);
        int cmp = key.compareTo(x.ke);
        if(cmp<0) return put(x.left,key,val);
        if(cmp>0) return put(x.right,key,val);
        else x.val = val;
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Value get(Key key) {
        Node x = root;
        while(x!=null) {
            int cmp = key.compareTo(x.ke);
            if (cmp < 0) x = x.left;
            if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    //FLOOR == Largest key ≤ a given key.
    public Key getFloor(Key key){
        Node x =  getFloor(root,key);
        if(x==null) return null;
        return x.ke;
    }

    private Node getFloor(Node y, Key key) {
        if(y==null) return null;
        int cmp = key.compareTo(y.ke);
        if(cmp<0) return getFloor(y.left,key);
        if(cmp==0) return y;
        Node t = getFloor(y.right,key);
        if(t!=null) return t;
        else return y;
    }

    public int rank(Key key) {
        return rank(root,key);
    }

    private int rank(Node x, Key key) {
        int cmp = key.compareTo(x.ke);
        if(cmp<0) return rank(x.left,key);
        if(cmp==0) return size(x.left);
        else return 1+size(x.left)+rank(x.right,key);
    }

    public void deleteMin()
    {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if(x.left==null) return x.right;
        deleteMin(x.left);
        x.count=1+size(x.right)+size(x.left);
        return x;
    }

    private Node min(Node x) {
        if(x.left==null) return x;
        min(x.left);
        return x;
    }

    public Iterable<Key> iterator()
    {
        Queue<Key> q =  new Queue<Key>();
        inorder(q,root);
        return q;
    }

    private void inorder(Queue<Key> q, Node x) {
        if(x==null) return;
        inorder(q,x.left);
        q.enqueue(x.ke);
        inorder(q,x.right);
    }

    //Hibbards deletion
    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if(x==null) return null;
        int cmp = key.compareTo(x.ke);
        if(cmp<0) return delete(x.right,key);
        if(cmp>0) return delete(x.left,key);
        else{
            if(x.left==null) return x.right;
            if(x.right==null) return x.left;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.count = 1+size(x.left)+size(x.right);
        return x;
    }

}

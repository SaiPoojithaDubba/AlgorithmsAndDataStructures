package Assignment5;

public class CheckWhetherBST {
    static class Node
    {
        int data;
        Node left, right;

        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    Node root;

    private Node min(Node x) {
        if(x.left==null) return x;
        return min(x.left);
    }
    private Node max(Node x){
        if(x.right==null) return x;
        return max(x.right);
    }
    public boolean isBST(){
        Node min = min(root);
        Node max = max(root);
        return isBSTUtil(root,min.data,max.data);
    }

    private boolean isBSTUtil(Node x, int min, int max) {
        if(x==null) return true;
        if(x.data<min || x.data>max){
            return false;
        }
        return isBSTUtil(x.left,min,x.data-1) && isBSTUtil(x.right,x.data+1,max);
    }

    public static void main(String args[])
    {
        CheckWhetherBST tree = new CheckWhetherBST();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}

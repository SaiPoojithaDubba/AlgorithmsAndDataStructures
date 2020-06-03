package Assignment5;

public class MorrisTraversalBST {
    static class Node{
        Node left;
        Node right;
        int value;
        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;
    //Time complexity O(n) and space complexity is O(1)
    //Inorder Traversal - visit left, visit root, visit left
    public void inorderTraversal(){
        Node current = root;
        while(current!=null){
           if(current.left==null){
               System.out.println(current.value+" ");
               current = current.right;
           }else{
               Node precedessor = current.left;
               while(precedessor.right!=current && precedessor.right!=null){
                   precedessor = precedessor.right;
               }
               if(precedessor.right==null){
                   precedessor.right=current;
                   //System.out.println(current.value+" "); //Uncomment for pre-order traversal
                   current = current.left;
               }else{
                   precedessor.right=null;
                   System.out.println(current.value+" "); //comment for pre-order traversal
                   current = current.right;
               }
           }
        }
    }

    public static void main(String args[])
    {
        MorrisTraversalBST tree = new MorrisTraversalBST();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.inorderTraversal();
        int output = 0;
    }
}

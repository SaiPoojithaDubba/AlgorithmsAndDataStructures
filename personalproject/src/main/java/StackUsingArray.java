public class StackUsingArray {
    private String a[];
    private int N = 0;
    public StackUsingArray(int capacity){
        String a[] = new String[capacity];
    }
     public void push(String item) {
         a[N++] = item;
     }
     public String pop() {
         return a[--N];
     }

     public boolean isEmpty(){
        return N==0;
     }
}

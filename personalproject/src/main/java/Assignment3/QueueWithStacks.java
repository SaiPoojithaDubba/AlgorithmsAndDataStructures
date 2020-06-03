package Assignment3;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueWithStacks<Item> {
    private Stack<Item> input = new Stack<Item>();
    private Stack<Item> output = new Stack<Item>();
     public int size() {
         return input.size()+output.size();
     }

     public boolean isEmpty(){
         return size()==0;
     }

     public void enqueue(Item item) {
         if(item==null){
             throw new NullPointerException();
         }
         input.push(item);
     }

     public Item dequeue(Item item) {
         if(isEmpty()){
             throw new NoSuchElementException();
         }
         while(!input.empty()){
             output.push(input.pop());
         }
         return output.pop();
     }
}

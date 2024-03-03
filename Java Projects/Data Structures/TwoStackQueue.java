import java.util.*;
import java.io.*;

//******************************************
// TwoStackQueue.java 
// Written by Christopher Demirjian
// cjd2186
//*******************************************
/* This class uses two stacks, S1 and S2, to implement a queue
 *   The queue has the following methods:
 *     enqueue: adds an element to the back of the queue (top of S1)
 *     dequeue: removes and returns an element from the front of the queue (top of S2)
 *     size: returns the number of elements in the queue
 *     isEmpty: returns true if the queue has no elements
 */
public class TwoStackQueue <T>{
    
    //number of elements in the queue
    private int currentSize;
    //S1 is in the input stack (back), where elements will be enqueued into
    private MyStack<T> S1;
    //S2 is in the input stack (front), where elements will be dequeued out of    
    private MyStack<T> S2;
    
    public TwoStackQueue(){
        
        //instantiate the two generic MyStack objects
        S1 = new MyStack<T>();
        S2 = new MyStack<T>();
        
        //queue must start as empty;
        currentSize=0;
    }
    
    //this method pushes the inputted element onto the input stack S1
    public void enqueue(T x){
        S1.push(x);
        //an object was added to the queue, so currentSize must be incremented
        currentSize++;
    }
    
    //this method pops the top element off of the output stack S2
    //if the output stack is empty, the contents of the input stack are added onto
    //  the output stack
    
    //LOGIC:
    //  the first items inputted into S1 will be at the bottom of this stack
    //    if all of the items from S1 are popped onto S2, the first items of S1
    //      will become the top items of S2, preserving the FIFO property of a queue
	public T dequeue(){
        //if both queues are empty, throw an exception
        if ( this.isEmpty() ){
            throw new NoSuchElementException();
        }
        //if only the ouput stack is empty,
        //pop the contents of the input stack and push them into the output stack
        if ( S2.isEmpty() ){
            while ( !S1.isEmpty() ){
                S2.push( S1.pop() );
            }
        }
        //store the item being dequeued from the output stack S2
        T dqItem=S2.pop();
        
        //an item is being removed from the queue, so currentSize must be decremented
        currentSize--;
        
        return dqItem;
    }
    
    //the size of the queue is tracked using currentSize,
    // therefore currentSize is returned as the size of the queue
	public int size(){
        return currentSize;
    }
    
    //if both stacks S1 and S2 are empty, the entire queue is empty
	public boolean isEmpty(){
        return ( S1.isEmpty() && S2.isEmpty() );
    }
   
}

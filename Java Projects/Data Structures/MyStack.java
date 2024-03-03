import java.util.*;
import java.io.*;

//******************************************
// MyStack.java 
// Written by Christopher Demirjian
// cjd2186
//*******************************************

//The class uses an array of Generic type T to implement a stack.
//The stack starts at the left side of the array, building to the right.

/*The methods in this class are as follows:
    pop(): returns the top value of stack, also decrements top and size
    push(T x): increments top and size, also adds element x to the top of stack
    peek: returns the value of top
    isEmpty(): returns true if there are no elements on stack 
    size(): returns the value of size (number of elements on stack)
*/

public class MyStack <T> implements MyStackInterface<T>{
    
    //create a default capacity of 10 for the underlying array
    private static final int DEFAULT_CAPACITY = 10;
    private T [] array;
    private int top;
    private int size;
    
    public MyStack(){

        //stack start off as empty
        //therefore top is instantied to -1 (before starting indice of 0)
        top= -1;
        //stack is empty, therefore has a size of 0
        size= 0;
        //call ensureCapacity with DEFAULT_CAPACITY of 10
        //  creates default stack of size 10
        ensureCapacity(DEFAULT_CAPACITY);
    }
    
    //Method ensureCapacity takes in required capacity of stack
    //  method is called when current stack is full
    //  method copies contents of current array into an array of size "newCapacity"
    //copied array then replaces the original array, making the copied array the current one
    
    //ignore "uses unchecked or unsafe operations" compiler warning
    @SuppressWarnings("unchecked")
    private void ensureCapacity ( int newCapacity){
        
        T [] old = array;
        //create new array of generic type T to hold the values of the stack
        array = (T []) new Object[newCapacity];
        for (int i=0; i<size(); i++){
            array[i]= old[i];
        }
    }
    
    //returns the size of the stack, as tracked using the size variable
    public int size(){
        return size;
    }
    
    public T pop(){
        //if stack is empty, print "StackUnderFlow"-
        //method ends by throwing EmptyStackException
        if (isEmpty()){
            System.out.println("StackUnderFlow");
            throw new EmptyStackException();
        }
        else{
        //stack not empty, return top item then decrement top
            T poppedItem= array[top--];
        
        //element is removed from the stack, therefore size must be decremented
            size--;
            return poppedItem;
        }
    }

    public void push(T x){
        //if array is full, print "StackOverFlow" and method ends by returning nothing
        if (isFull()){
            ensureCapacity( size() *2 +1);
        }
        //array not full, increment top then set array[top] to x
        array[++top]= x;
        
        //element is added to the stack, therefore size must be incremented
        size++;        
    }
    
    public boolean isEmpty(){
        //returns true if size of stack is 0
        return size()==0;
    }
    
    private boolean isFull(){
        //returns true if the length of the array equals the number of items within it
        return (array.length==size());        
    }    
    
    public T peek(){
        //if stack is empty, print "StackUnderFlow" and method throws exception
        if (isEmpty()){
            System.out.println("StackUnderFlow");
            throw new EmptyStackException();
        } 
        else{
        //return element in array at index top
            return array[top];
        }
    }
}

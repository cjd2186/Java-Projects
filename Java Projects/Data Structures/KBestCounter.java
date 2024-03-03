import java.util.*;
import java.io.*;

/**
 * This class represents a KBestCounter object in Java.
//******************************************
// KBestCounter.java 
// Written by Christopher Demirjian
// cjd2186
//*******************************************
 * Constructor:
     * takes in an int that represents the number of largest elements to be returned
 * Methods: 
     * count(T x):
         *takes in the next element in the set of data 
         *no return
         *runs in worst O(log k) time;
     * kbest():
         * takes in no arguments
         * returns a list of the k-largest elements.
         * runs in worst O(k logk) time.
 */

public class KBestCounter<T extends Comparable <? super T>> implements KBest<T>{
    //create kLargest and pq variables;
    int kLargest;
    //pq is a PriorityQueue (min heap) that is used to store the largest values of the data set
    PriorityQueue <T> pq;    

    //The constructor takes in an int k that indicates
    //  the amount of largest elements you want to return.    
    public KBestCounter(int k){
        //initialize kLargest and pq
        kLargest=k;
        pq= new PriorityQueue<>();
    }
    //This method processes the next element in the set of data.    
    //the main cost in this method lies in the add and remove methods of the java.util.PriorityQueue
    //the add method runs in worst O(log k) time, as there are worst case log k percolate ups to be performed.
    //the remove method runs in worst O(log k) time as well, as there are worst case log k percolate downs to be performed.
        //Therefore, in the worst case, this method runs in worst O(log k) time.
    public void count (T x){
        //if there are less than k kLargest elements in the PriorityQueue, 
        //  another element can be added and the element will be the largest
        if (pq.size()<kLargest){
            pq.add(x);
        }
        
        //if the element being added is greater than the first (smallest) element of the priorityQueue
        //  AND the priorityQueue is kLargest elements long,
        //remove the smallest element of the PriorityQueue and addd the new element to the queue
        else if ((x.compareTo((T) pq.peek()) > 0 ) && (pq.size()== kLargest)){
            pq.remove();
            pq.add(x);
        }
    }
    
    //This method returns a sorted (smallest to largest) list of the k-largest elements.
    //The main cost in this method lies within the for and while loops
    //Each loop iterators through k elements.
    
    //The for loop performs a poll operation (which has the same log k cost of a remove)
    // as well as adds this element to the LinkedList (O(1) cost).
    //Therefore this first loop has a cost of (K * (log (k) + O(1))) which equals O(k log k)
    
    //The  while loop perfroms an add operation (worst O(log k)) to add an element to the PriorityQueue
    //  as well as uses an iterator to access each element in the linked list (worst O(1))
    //Therefore this while loop has a cost of (K* (log(k) + O(1))) which equals O(k log k)
    
    //The entier method kbest has a runtime of O (k log k + k log k), which totals to worst O(k log k) runtime.
    public List<T> kbest(){
        //create new list to store k-largest items
        LinkedList <T> kList= new LinkedList<>();
        //store the size of the initial PriorityQueue
        int pqSize=pq.size();
        
        //iteratare through the priorityQueue of size k,
        // remove the 0th element of the priorityQueue,
        // add this element to the end of the LinkedList
        for (int i=0; i<pqSize; i++){
            kList.add( pq.poll() );
        }
        
        //refill the priorityQueue with each element in the ArrayList
        //use iterator to iterator through every element of kList,
        //  add this element to the priorityQueue
        Iterator <T> itrL= kList.iterator();
        while (itrL.hasNext()){
            T item=itrL.next();
            pq.add(item);            
        }
        
        return kList;
    }
}

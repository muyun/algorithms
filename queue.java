// queue.java
// queue: the first item inserted is the first to be removed (FIFO)
// This class inclues the insert, remove, peek, isEmpty and isFull methods
//
// Implementation with an item count, if without an item count, it is complex
// Circular queue
import java.io.*;
class queue {
    private int maxSize;
    private int[] queArray;
    private int front;     // front of the queue
    private int rear;      // rear of the queue
    private int nItems;    // number of item in queue
    // this is a circular queque
    
    public queue(int s){    // constructor
        // front and rear pointers assume the same positions 
        // when the queue is full or empty
        maxSize = s;    
        queArray = new int[maxSize];  // request the array
        front = 0;
        rear = -1;
        nItems = 0;                   
    }
    
    public void insert(int i){  //  put item at rear of queue
        
        // the trouble with the above arrangement is pretty that the rear of the queue is at the end
        // of the array. Even if there are empty cells at the beginning og the array.
        // so, rear arrows wrap around to the beginning of the array when the array is full
        // and is below front
        if (rear == maxSize -1)  // deal with wraparound
            rear = -1;
        queArray[++rear] = i;    // increment rear and insert
        
        nItems++;                // one more item
    }
    
    public int remove(){        // take item from front of queue
        // for efficience, it needn't to move all the items in a queue whenever we deleted one 
        // instead keep all the items in the same place and move the front and rear of the queue 
        int temp = queArray[front++];  // get value and incr front
        if(front == maxSize)     // deal with wraparound
            front = 0;
        
        nItems--;                // one less item
        
        return temp;
    }
    
    public int peek(){   //peek at front of queue
        
        return queArray[front];
    }
    
    public boolean isEmpty(){   // true if queue is empty
        
        return ( nItems == 0);
        
    }
    
    public boolean isFull(){   // true if queue is full
        return ( nItems == maxSize);
    }
    
    public int size(){    // number of items
        
       return nItems;
    }
    
}   // end class queue


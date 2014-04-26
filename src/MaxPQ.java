//MaxPQ.java
/*
  java MaxPQ < tobe1.txt
*/
//using an iterator is to allow the client to iterate over the collection of objects
/*
public interface Iterable<T>
{
  Iterator<T> iterator();
}  
*/
import java.util.Iterator;
/*
public interface Comparator<T>
{
   int compare(T o1, T o2);
   boolean equals(Object obj);
}
*/
import java.util.Comparator;
import java.util.NoSuchElementException;

public class MaxPQ<Key> implements Iterable<Key>
{
    private Comparator<Key> comparator;  //optional Comparator

    private Key[] pq; //store items at indices 1 to N
    private int N;    //number of items on priority queue

    //initialize an empty priority queue with the given initial capacity
    public MaxPQ(int initCapacity){
        pq = (Key[]) new Object[initCapacity + 1];
        N = 0;
    }

    public MaxPQ(){
        this(1);
    }

    //initialize an empty priority queue with the given initial capacity,using the given comparator
    public MaxPQ(int initCapacity, Comparator<Key> comparator){
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        N = 0;
    }

    //initialize an empty priority queue using the given comparator
    public MaxPQ(Comparator<Key> comparator){
        this(1, comparator);
    }

    //initialize a priority queue from the array of keys
    public MaxPQ(Key[] keys){
        N = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for(int i = 0; i < N; i++)
            pq[i+1] = keys[i];
        for(int k = N/2; k >= 1; k--)
            sink(k);

        assert isMaxHeap();
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public Key max(){
        if(isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    //swim, bottom-up reheapify
    //moving up the heap until we reach a node with a larger key, or the root;
    //keep in mind that the parent of the node at position k in a heap is at position k/2
    private void swim(int k){
        while(k > 1 && less(k/2, k)){ //the node's key larger than parent's key
            exch(k/2, k);  //exchange the node with its parent
            k = k/2;
        }
    }

    //sink, top-down reheapify
    //moving down the heap until we reach a node with both children smaller(or equal,) or the bottom;
    //the children of the node at position k in a heap are at positions 2k and 2k+1
    private void sink(int k){
        while(2*k <= N){
            int j = 2*k;  //the children of the node
            if (j < N && less(j, j+1)) j++; //find the smaller children
            if (!less(k, j)) break;
            exch(k, j);  //swap the node with the smaller children
            k = j;
        }
    }

    //add a new key to the priority queue
    public void insert(Key x){
        //double size of array if necessary
        if(N >= pq.length -1)
            resize(2 * pq.length);
        
        pq[++N] = x;
        swim(N);  //swim up through the heap

        assert isMaxHeap();
    }

    public Key delMax(){
        if(isEmpty()) throw new NoSuchElementException("Priority queue underflow");

        Key max = pq[1]; //the largest key off the top
        exch(1, N--); //exchange the last one with root
        sink(1); //sink sown through the heap
        pq[N+1] = null; //to avoid loitering and help with garbage collection

        if ((N > 0) && (N == (pq.length -1) / 4))
            resize(pq.length / 2);
                
        assert isMaxHeap();
        return max;
    }
    
//2. compare function
/*
public interface Comparator<T>
{
   int compare(T o1, T o2);
   boolean equals(Object obj);
}

public interface Comparable<T>
{
   int compareTo(T o);
}
*/
private boolean less(int i, int j)
{
    if(comparator == null)
        return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
    else
        return comparator.compare(pq[i], pq[j]) < 0;
}

//helper functions
private void exch(int i, int j)
{
    Key swap = pq[i];
    pq[i] = pq[j];
    pq[j] = swap;
}

// is pq[1..N] a max heap?
private boolean isMaxHeap()
{
    return isMaxHeap(1);
}

//is subtree of pq[1..N] rooted at k a max heap?
private boolean isMaxHeap(int k)
{
    if(k > N) return true;
    int left = 2*k, right = 2*k + 1;
    if(left <= N && less(k, left)) return false;
    if(right <= N && less(k, right)) return false;
    
    return isMaxHeap(left) && isMaxHeap(right);
}

//double he size of the heap array
private void resize(int capacity){
    //3. assert is used to verify the correctness of an invariant in the code
    assert capacity > N;

    Key[] temp = (Key[]) new Object[capacity];
    for(int i = 1; i <= N; i++)
        temp[i] = pq[i];
    
    pq = temp;
}


//1. An implementation of Iterable is one that provides an Iterator of itself
/*
public interface Iterable<T>
{
  Iterator<T> iterator();
}
*/
//returns an iterator that iterates over the keys on the pq
public Iterator<Key> iterator() 
{
    return new HeapIterator();
}

 //An iterator is a simple way of allowing some to loop through a collection
 /*
   public interface Iterator<E>
   {
      boolean hasNext();
      E next();
      void remove();
   }
 */

private class HeapIterator implements Iterator<Key>
{
    //create a new pq
    private MaxPQ<Key> copy;

    //
    public HeapIterator() {
        
    }

    public boolean hasNext() { return !copy.isEmpty(); }
    public void remove() { throw new UnsupportedOperationException(); }
    public Key next(){
        if(!hasNext()) throw new NoSuchElementException();
        return copy.delMax();
    }
}

public static void main(String[] args){
    MaxPQ<String> pq = new MaxPQ<String>();
    while(!StdIn.isEmpty()){
        String item = StdIn.readString();
        if(!item.equals("-"))
            pq.insert(item);
        else if(!pq.isEmpty())
            StdOut.print(pq.delMax() + " ");
    }
    StdOut.println("(" + pq.size() + " left on pq)");
 }
        
}


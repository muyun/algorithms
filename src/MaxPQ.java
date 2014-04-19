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

import java.util.Comparable;

import java.util.NoSuchElementException;

public class MaxPQ<Key> implements Iterable<Key>
{
    private Comparator<Key> comparator;
    
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


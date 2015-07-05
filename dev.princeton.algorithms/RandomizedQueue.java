//RandomizedQueue.java: wenlong
//Description: A randomized queue is similar to a stack or queue, except that the item removed
//             is chosen uniformly at random from items in the data structure
//
//Performance:  each randomized queue operation in constant amortized time
//              space proportional to the number of items currently in the queue
//
// % java RandomizedQueue < tobe.txt
//   6 2 4 5 1 3 
//   1
//   6 2 4 5 3 
//   2
//   6 4 5 3 
//------------------------------------------------------------------------------
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item>
{
    private Item[] a;
    private int N;

    public RandomizedQueue()
    {
        a = (Item[]) new Object[2];
        int N = 0;
        
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    private void resize(int capacity)
    {
        Item[] temp = (Item[]) new Object[capacity];
        for(int i=0; i<N; i++){
            temp[i] = a[i];
        }
        a=temp;
    }
    
    //add the item
    public void enqueue(Item item)
    {
        if(item == null)
            throw new NullPointerException("null item");
        
        if(N == a.length)
            resize(2*N);
        a[N++] = item;
    }

    //delete and return a random item
    public Item dequeue()
    {
        if(isEmpty())
            throw new NoSuchElementException("empty Randomized queue");

        //generate a pseudo-random integer between 0 and N-1
        int r = StdRandom.uniform(N);
        Item item = a[r];
        
        for(int i=r; i<N; i++){
            a[i] = a[i+1];
        }
        a[N-1] = null; 
        N--;
        
        if(N>0 && N == a.length/4)
            resize(a.length/2);
        
        return item;
    }
    
    //return (but do not delete) a random item
    public Item sample()
    {
        if(isEmpty())
            throw new NoSuchElementException();

        //generate a pseudo-random integer between 0 and N-1
        int r = StdRandom.uniform(N);
        
        return a[r];
    }

    public Iterator<Item> iterator()
    {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item>
    {
        private int i;
        public RandomizedQueueIterator()
        {
            i = N;
        }

        public boolean hasNext()
        {
            return i > 0;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }
        
        public Item next()
        {
            if(!hasNext())
                throw new NoSuchElementException();
            return a[--i];
        }
        
    }

    public static void main(String[] args)
    {
        RandomizedQueue<String> rqueue = new RandomizedQueue<String>();

        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            rqueue.enqueue(item);
        }

        Iterator<String> i = rqueue.iterator();
        while(i.hasNext()){
            String str2 = i.next();
            StdOut.print(str2 + " ");
        }
        StdOut.println();

        String str1 = rqueue.dequeue();
        StdOut.println(str1);
        
        for(String s : rqueue){
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
}

// queue.java: wenlong
// queue: the first item inserted is the first to be removed (FIFO)
// This class inclues the insert, remove, peek, isEmpty and size methods
//
//TODO: There are still bugs
//
//to maintain encapsulation, don't want to reveal the internal representation of the queue (array or linked list) to the client
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
//java's Iterable interface
public interface Iterable<Item> 
{
    Iterator<Item> iterator(); 
    
}
*/
public class Queue<Item> { // implement java's Iterable interface
    private class Node<Item>
    {
       private Item item;
       private Node next;
    }
        
    private Node head;     // head of the queue
    private Node last;      // last of the queue
    private int N;    // number of item in queue
    
    public Queue(){    // constructor
        head = null;
        last = null;
        N = 0;                   
    }
    
    //add the item to the queue
    public void insert(Item item){
        Node x = new Node();
        x.item = item;
        
        if (isEmpty()){
            head = x;
            last = x;
        }else{
            last.next = x;
            last = x;
        }

        N++;
    }

    //remove and return the item on the queue least recently added
    public Item remove(){
        if(isEmpty()) throw new RuntimeException("Queue underflow");
        
        Item x = head.item;
        head = head.next;
        N--;

        if(isEmpty())
            last = null; //avoid loitering

        return x;
    }
    
    public Item peek(){   //return the item least recently added to the QUEUE
        if(isEmpty()) throw new RuntimeException("Queue underflow");
        return head.item;
    }
    
    public boolean isEmpty(){   // true if queue is empty
        return head == null;
    }
    
    public int size(){    // number of items
       return N;
    }

    public interface Iterator<Item>
    {
        boolean hasNext();
        Item next();
    }

        /*
    // Java's java.util.Iterator interface
    public interface Iterator<Item>
    {
        boolean hasNext();
        Item next();
        void remove(); //optional
    }
    */
    
    public Iterator iterator()
    {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> 
    {
        Node current = head;
        public boolean hasNext()
        {
            return current != null;
        }

        public Item next()
        {
            if(!hasNext()) throw new NoSuchElementException();
            
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // test client
    public static void main(String[] args)
    {
        Queue<String> queue = new Queue<String>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            queue.insert(item);
        }
        
        Iterator<String> i = queue.iterator();
        while(i.hasNext()){
            String s = i.next();
            StdOut.println(s);
        }
    }
    
}   // end class queue

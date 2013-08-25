// stack.java
// Stack: Last-In-First-Out storage mechanism
// The stack defines a stack class with push, pop, peel and size methods

//  >more tobe.txt
//  to be or not to - be - - that - - - is
//  >java ResizingArrayStack <tobe.txt
//  to be not that or be (2 left on stack)
//
import java.util.Iterator;
import java.util.NoSuchElementException;

// a promise to provide an iterator() method, as specified in the java.lang.Iterable interface
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] stackArray; //array of items
    private int N;        // number of elements on stack

    // create an empty stack
    public ResizingArrayStack(){  //constructor
        // make an Object array with a length of 2
        stackArray = (Item[]) new Object[2]; 
    }

    public boolean isEmpty()
    {
        return N == 0;
        
    }
    public int size()
    {
        return N;
    }
    
    private void resize(int capacity){
        assert capacity >= N;
        Item[] temp = (Item[]) new Object[capacity];
        
        for (int i=0; i<N; i++){
            
             temp[i] = stackArray[i];
        }
        stackArray = temp;
        
    }
    
    public void push(Item item){
        if(N == stackArray.length)
            resize(2 * stackArray.length);
                
        stackArray[N++] = item;   // increment top and insert item
    }
    
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        
        Item item = stackArray[N-1]; // access the item and decrement top
        stackArray[N-1] = null;    // avoid loitering
        N--;
        // shrink size of array if necessary
        if(N>0 && N == stackArray.length/4)
            resize(stackArray.length/2);

        return item;
    }
    
    // implement a method iterator() that returns an object from a class
    // that implements the Iterator interface:
    public Iterator<Item> iterator() 
    {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item> 
    {
        private int i;

        public ReverseArrayIterator(){
            i = N;
        }

        public boolean hasNext()
        {
            return i >0;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }
        
        public Item next() 
        {
            if (!hasNext()) throw new NoSuchElementException();
            return stackArray[--i];
        }
        
    }


    // Test
    public static void main(String[] args)
    {
        ResizingArrayStack<String> s = new ResizingArrayStack<String>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-"))
                s.push(item);
            else if(!s.isEmpty())
                StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
        
    }
    
}  // end class stackx

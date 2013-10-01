//PriorityQueue.java: wenlong
//Description: * the priority queue is maintained in a heap-ordered complete binary tree;
//               heap-ordered if the key in each node >= the keys in the node's two children
//             * heap priority queue
//             *
//
//Performance:
//      the heap algorithms require no more than 1 + lgN compares for insert,
//      no more than 2lgN compares(find the larger child and decide whether the child needs to be promoted) for remove the maximum
//------------------------------------------------------------------------------------------
import java.util.Comparator;
//import java.util.Iterator;
import java.util.NoSuchElementException;

public class PriorityQueue<Key> 
{
    private Key[] pq;  //heap-ordered complete binary tree
    private int N;  //in pq[1..N] with pq[0] unused
    private Comparator<Key> comparator;  // optional comparator
        
    public PriorityQueue(int initCapacity){
        pq =(Key[]) new Object[initCapacity + 1];  //pq[0] unused
        N = 0;
    }

    public PriorityQueue(){
        this(1);
    }
    
    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    //more compact implementations,
    //don't involve passing the array name as a parameter
    public boolean less(int i, int j)
    {
        if(comparator == null){
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        }else{
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }
    
    public void swap(int i, int j)
    {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void resize(int capacity)
    {
        assert capacity > N;

        Key[] temp = (Key[]) new Object[capacity];
        for(int i = 1; i<=N; i++)
            temp[i] = pq[i];

        pq = temp;
    }
        
    //add the new key at the end of the array, and use swim() to restore the heap order
    public void insert(Key v)
    {
        //double size of array
        if(N >= pq.length - 1)
            resize(2 * pq.length);
                
        pq[++N] = v;  //pq[1..N]
        // swim up through the heap with the key to restore the heap condition
        swim(N);   
    }

    //Bottom-up reheapity(swim):if a node's key becomes larger than the node's parent's key,
    //exchange the node with its parent
    public void swim(int k)
    {
        while(k > 1 && less(k/2, k) ){
            swap(k/2, k);
            k = k/2;
        }
    }


    //remove the maximum
    //take the value from pq[1], exchange the end of the heap with root
    //then decrement the size of the heap, and use sink() to restore the heap condition
    public Key delMax()
    {
        if(isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        
        Key max = pq[1];
        swap(1, N--);    //exchange with last iem, move pq[N] to pq[1]
        sink(1);   //sink down through the heap with the key
        pq[N+1] = null;  //avoid loitering

        if((N>0) && (N == (pq.length-1)/4)) //apart from pq[1]
            resize(pq.length/2);
        
        return max;
    }

    //Top-down reheapify(sink): a node's key is smaller than one or both of the node's children's keys,
    //exchange the node with the larger of its two children
    public void sink(int k)
    {
        while( 2*k <= N){
            int j = 2*k;
            if(less(j, j+1) && j < N)
                j++;  //very compact code to get the larger child
            
            //here j has represented the max child between left and right children
            if(!less(k, j)) //whether the child needs to be promoted
                break;

            swap(k, j);
            k = j;  //continue
        }
        
    }

    public static void main(String[] args)
    {
        PriorityQueue<String>  pq = new PriorityQueue<String>();
               
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-"))
                pq.insert(item);
            else if (!pq.isEmpty())
                StdOut.print(pq.delMax() + " ");
        }

        StdOut.println("(" + pq.size() + " left on pq)");
        
    }
            
}

/* BinarySearchST.java
 * 1)Keep keys in an ordered array so that we can use array indexing to dramatically reduce the nmber of compares required for each search, using the known as binary search
             keys[]
       --------------------------------
       0  1  2  3   4   5   6   7  8  9
       to be   this         are is am -
       
   2) a logarithmic search guarantee, Binary search in an ordered array with N keys uses no more than lgN + 1 compares for a search in the worst case
   
   3) but, inserting a new key into an ordered array of size N uses ~2N array accesses in the worst case, so inserting N keys into an initially empty table uses ~N*N array accesses in the worst case

   4) java BinarySearchST < tobe1.txt
       
*/
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.LinkedList;

/*
  // Comparable interface built in Java
  public interface Comparable<Item>
  {
     public int compareTo(Item that);
  }
*/
public class BinarySearchST<Key extends Comparable<Key>, Value>
{
    private static final int INIT_CAPACITY = 2;
    
    private Key[] keys;
    private Value[] vals;
    private int N = 0;

    public BinarySearchST(){
        this(INIT_CAPACITY);
    }

    //with given initial capacity
    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    private void resize(int capacity){
        Key[]  tempk = (Key[]) new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];

        for(int i=0; i < N; i++){
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }

    public int size() { return N; }

    //return the value associated with the given key, or null
    public Value get(Key key){
        if (size() == 0 ) return null;

        int i = rank(key); //return the number of keys in the table
        if(i < N && keys[i].compareTo(key) == 0)
            return vals[i];

        return null;
    }

    //return the number of keys in the table that are smaller than given key
    public int rank(Key key){
        int lo = 0, hi = N-1;
        while(lo <= hi){
            int m = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[m]);
            
            if (cmp < 0) hi = m - 1;
            else if (cmp > 0) lo = m + 1;
            else return m;
        }

        return lo;
    }

    //search for key, update value if found, grow table if new
    public void put(Key key, Value val){
        int i = rank(key);

        // key is already in table
        if (i < N && keys[i].compareTo(key) == 0){
            vals[i] = val;
            return;
        }
        // insert new key-value pair
        if(N == keys.length)
            resize(2 * keys.length);
        
        for(int j = N; j>i; j--){
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Iterable<Key> keys() {
        return keys(keys[0], keys[N-1]);
    }

    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> queue= new LinkedList<Key>();

        if(lo.compareTo(hi) > 0) return queue;
        for(int i = rank(lo); i <= rank(hi); i++)
            queue.add(keys[i]);
        return queue;
        
    }
        

    //Test client
    public static void main(String[] args)
    {
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
        for(int i = 0; !StdIn.isEmpty(); i++){
            String key = StdIn.readString();
            st.put(key, i);
        }
        
        for (String s : st.keys()){
            StdOut.println(s + " " + st.get(s));
        }
        
    }
}

//BST.java: wenlong
//Description:* A BST(binary search tree) is a binary tree where each node has a Comparable key (and the value)
//             and satisfies the tree restriction
//            * combines the flexibility of insertion in a linked list with the efficiency of search in an ordered array
//
//Performance:
//            * TODO: Insertions and serch in a BST built from N random keys require ~2lnN compares on the average
//
//-----------------------------------------------
import java.util.NoSuchElementException;

//assume that Key is an Object because we use it to invoke compareTo() or equals()
public class BST<Key extends Comparable<Key>, value>
{
    private Node root;  // root of BST

    private class Node{
        private Key key;   // sorted by key
        private Value val; //
        private Node left, right;  //left and right subtrees
        private int N;  //number of nodes in subtree

        public Node(Key key, Value val, int N)
        {
            this.key = key;
            this.val = val;
            this.N = N;
        }
        
    }

    public int size()
    {
        // return N;  // N is defined as a element of Node
        return size(root);
    }

    private int size(Node x)
    {
        if(x == null) return 0;
        else return x.N;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    //return value associated with the given key, or null if no such key exists
    public void get(Key key)
    {
        return get(root, key);
    }

    private Value get(Node x, Key key)
    {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            return get(x.left, key);
        else if (cmp > 0)
            return get(x.right, key);
        else
            return x.val;
        
    }
                
    //insert key-value pair into BST, if key already exists, update with new value
    public void put(Key key, Value val)
    {
        root = put(root, key, val);  //the root corresponds to the first partitioning item in quicksort
    }

    //the subtrees are built recursively, corresponding to quicksort's recursive subarray sorts
    private Node put(Node x, Key key, Value val)
    {
        if(x == null)
            return new Node(key, val, 1);  // return the ref to a new node, its left and right is null
        
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            x.left = put(x.left, key, val);  // x.left is null, after new Node, put this ref to the new node into x.left
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else  //cmp == 0
            x.val = val;  //reset the value
        
        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }
        
}

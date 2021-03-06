/*
ArraySort.java: wenlong
Description: bubble sort, selection sort, heap sort
Assume: 1) total order (like v.compareTo(w))
        2) callback = reference to executable code
              * client passes array of objects to sort() function
              * The sort() function calls back object's compareTo() method as needed
                   ---user-defined comparable types implement the comparable interface

Performance: 1) selection Sort improves on the bubble sort by reducing the number of swaps necessary
from O(N*N) to O(N). Unfortunately, the number of comparisons remains O(N*N) .
             2) uses (N-1)+ (N-2)+ ... + 1 + 0 ~ N2/2 compares and N exchanges
             3) Running time is insensitive to input: the process of finding the smallest item on one pass
                through the array doesnot give much information about where the smallest item might be on the next pass
             4) Data movement is minimal: Each of the N exchanges changes the value of two array entries,
                which means that the number of array accesses is a linear function of the array size N.
---------------------------------------------------------------------------------------------------
*/

import java.lang.Comparable;
//this sorting logic must be in same class whose objects are being sorted,
//this is called natural ordering of objects

/*
  // Comparable interface built in Java
  public interface Comparable<Item>
  {
     public int compareTo(Item that);
  }
*/

//bubble sort
class Bubble
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        //find the remaining biggest in every loop
        for(int out=N-1; out>1; out--) // outer loop is backward
            for(int in=0; in<out; in++) // inner loop is forward
                if ( less(a[in+1],a[in]) )
                    swap(a, in, in+1);
    }

    //exchange a[i] and a[j]
    public static void swap(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

}

//Selection Sort
//repeatedly selecting the smallest remaining item and exchange it with the corresponding entry
class Selection
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for(int i=0; i<N; i++){
            //exchange a[i] with smallest entry in a[1+1...N]
            int min = i;
            for(int j=i+1;j<N;j++) //assume i is the min entry
                if(less(a[j],a[min]))
                    min = j;
            swap(a, i, min); //reduce the swap times here compared with Bubble
        }
    }

    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    //exchange a[i] and a[j]
    private static void swap(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void display(Comparable[] a)
    {
        for(int i=0; i<a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a)
    {
        for(int i=0; i<a.length; i++)
            if(less(a[i],a[i-1])) //total order
                return false;
        return true;
    }

    //test
    public static void main(String[] args)
    {
        String[] a = StdIn.readStrings();
        
        sort(a);
        assert isSorted(a);
        display(a);
        
    }
    
}

class Heap 
{
    private Heap() { }

    public static void sort(Comparable[] a)
    {
        int N  = a.length;
        for(int k = N/2; k >= 1; k--)
            sink(a, k, N);

        while (N > 1){
            swap(a, 1, N--);
            sink(a, 1, N);
        }
                
    }

    private static void sink(Comparable[] a, int k, int N)
    {
        while( 2*k <= N ){ //a node's key smaller than one of the node's children's keys
            int j = 2*k;
            if(less(j, j+1) && j < N)
                j++; //get the larger child
            
            if(!less(k, j)) //whether the child needs to be promoted
                break;

            swap(a, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable v, Comparable w )
    {
        return v.compareTo(w) < 0;
    }

    private static void swap(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = temp;
    }

    public static void display(Comparable[] a)
    {
        for(int i=0; i<a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    //test
    public static void main(String[] args)
    {
        String[] pq = StdIn.readStrings();
        display(pq);
        
        Heap.sort(pq);
        display(pq);
    }
}



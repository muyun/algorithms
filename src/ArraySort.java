// ArraySort.java: wenlong
// Description: Selection sort, Insertion sort, shell sort
// Assume: 1) total order (like v.compareTo(w))
//         2)callback= reference to executable code
//              * client passes array of objects to sort() function
//              * The sort() function calls back object's compareTo() method as needed
//                   ---user-defined comparable types implement the comparable interface
//---------------------------------------------------------------------------------------------------
//import java.util.Comparator;
/*
  // Comparable interface built in Java
  public interface Comparable<Item>
  {
     public int compareTo(Item that);
  }
*/

//basic sort methods
class Base 
{
    public static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    //exchange a[i] and a[j]
    public static void swap(Comparable[] a, int i, int j)
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

}

//bubble sort
class Bubble extends Base
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        //find the remaining biggest in every loop
        for(int out=N-1; out>1; out--) // outer loop is backward
            for(int in=0; in<out; in++) // inner loop is forward
                if ( Base.less(a[in+1],a[in]) )
                    Base.swap(a, in, in+1);
    }

}

//Selection Sort
//repeatedly selecting the smallest remaining item and exchange it with the corresponding entry

// Performance: 1) selection Sort improves on the bubble sort by reducing the number of swaps necessary
// from O(N*N) to O(N). Unfortunately, the number of comparisons remains O(N*N) .
//              2) uses (N-1)+ (N-2)+ ... + 1 + 0 ~ N2/2 compares and N exchanges
//
//              3) Running time is insensitive to input: the process of finding the smallest item on one pass
//                 through the array doesnot give much information about where the smallest item might be on the next pass
//              4) Data movement is minimal: Each of the N exchanges changes the value of two array entries,
//                 which means that the number of array accesses is a linear function of the array size N.
// Selection is not stable, long-distance swap might move an item past some equal item
class Selection extends Base
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for(int i=0; i<N; i++){
            //exchange a[i] with smallest entry in a[1+1...N]
            int min = i;
            for(int j=i+1;j<N;j++) //assume i is the min entry
                if(Base.less(a[j],a[min]))
                    min = j;
            Base.swap(a, i, min); //reduce the swap times here compared with Bubble
        }
    }

    //test
    public static void main(String[] args)
    {
        String[] a = StdIn.readStrings();
        
        sort(a);
        assert Base.isSorted(a);
        Base.display(a);
        
    }
    
}

//Insertion Sort
// In iteration i, swap a[i] with each larger entry to its left,then
// Invariants: Entries to the left are in ascending order while entries to the right have not yet been seen
//
// Performance: 1)for randomly ordered array of length N with distince keys, 
//                on the average, Insertion sort uses ~N2/4 compares and ~N2/4 exchanges to sort
//              2)For partially-sorted arrays, insertion sort runs in linear time,
//           Number of exchanges equals the number of inversions (<=cN),
//           Number of inversions(when array in reverse order) <= Number of compares <=( Number of inversions + (N-1)(when array in order) )
//              3) Insertion sort ia an excellent method for partially sorted arrays and is also a fine method for tiny array
//
// Insertion sort is stable, because equal items never move past each other
class Insertion extends Base
{
    public static void sort (Comparable[] a)
    {
        int N  = a.length;
        for(int i=0; i<N; i++)
            for(int j=i; j>0; j--){
                if(Base.less(a[j], a[j-1]))
                    //put a[i] among a[i-1], a[i-2], a[i-3] ...,
                    //each item is immediately determined to be in its proper place in the array in each iterator i
                    Base.swap(a, j, j-1);  
                else
                    break;
            }
        
    }

    //test
    public static void main(String[] args)
    {
        String[] a = StdIn.readStrings();

        sort(a);
        assert Base.isSorted(a);
        Base.display(a);
        
    }
    
}

//Shellsort
// move entries more than one position at a time by h-sorting the array, then
// h-sort array for descreasing sequence of values of h
// like Insertion sort with stride length h
//
// The idea: h-sort the array using insertion sort
//          if the increments are big then the size of the subarrays that we're sorting are pretty small
//           so any sorting method is going to work well; If the increments are small because we've done previous h-sorts
//           for bigger values of h, the array is partially sorted and so insertion sort is to be fast
//
// Proposition: A g-sorted array remains g-sorted after h-sorting it
// Performance: 1) the worst-case number of compares used by shellsort with 3x+1 increments is O(N3/2)
//              2) Accurate model has not yet been discovered
//Shell sort is not stable, it moves keys past other keys that could be equal
class ShellSort extends Base
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;

        int h = 1;
        while( N>3*h)     // there is ~logN/log3 h
            h = 3*h + 1;  // 3x+1 increment sequence

        while(h>=1){
            //h-sort the array using inserting sort with stride length h
            for(int i=h; i<N; i++)
                for(int j=i; j>=h; j-=h){
                    if(Base.less(a[j], a[j-h]))
                        Base.swap(a, j, j-h);
                    else
                        break;
                }
            
            h = h/3;  // next
        }
        
    }
    
}


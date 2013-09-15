// Sort.java: wenlong
// Description: Bubble sort, Selection sort, Insertion sort and ShellSort
//
// Assume: 1) total order (like v.compareTo(w))
//         2)callback= reference to executable code
//              * client passes array of objects to sort() function
//              * The sort() function calls back object's compareTo() method as needed
//                   ---user-defined comparable types implement the comparable interface
//
// bubble sort
//Selection Sort improves on the bubble sort by reducing the number of swaps necessary
// from O(N*N) to O(N). Unfortunately, the number of comparisons remains O(N*N) .
//

//import java.util.Comparator;
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
                if (a[in]>a[in+1])
                    swap(a[in],a[in+1]);
    }

    //exchange a[i] and a[j]
    public static void swap(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}

//Selection Sort
//repeatedly selecting the smallest remaining item and exchange it with the corresponding entry
public class Selection
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for(int i=0; i<N; i++){
            //exchange a[i] with smallest entry in a[1+1...N]
            int min = i
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

    private static void display(Comaprable[] a)
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
    
}



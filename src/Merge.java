//Merge.java: wenlong
//Description: Top-down mergesort is a recursive mergesort implementation
//
//Performance:
//at most NlgN compares and 6NlgN (2N for the copy, 2N for the move back, and at most 2N for compares) array accesses 
//
//---------------------------------------------------------------------
public class Merge
{
    // use static when we want to provide class level access to a method,
    // like the method should be callable without an instance of the class
    public static void sort(Comparable[] a)
    {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
        assert isSorted(a);
        
    }

    // recursive
    //mergesort a[io..hi] using auxiliary array aux[io..hi]
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
    {
        if (hi <= lo) return;
        //TODO: Mergesort has too much overhead for tiny subarrays
        //      use inertion sort for small subarrays
        // if(hi <= lo + CUTOFF -1 ) Insertion.sort(a, lo, hi)
        
        //recursive calls, stack operations
        // push the local variable like mid into the stack of the method implicitly
        int mid = lo + (hi - lo) / 2;
        //StdOut.println(lo + " " + mid + " " + hi);
        
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        //stop if already sorted
        // is biggest item in first half <= smallest item in second half
        if(!less(a[mid+1], a[mid]))
            return;
        merge(a, aux, lo, mid, hi);
        
        //StdOut.println("(" + lo + "," + mid + "," + hi + ")");
        
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
    {
        //precondition
        //Assertion: Statement to test assumptions about your program
        //           helps detect logic bugs and Documents code
        //can enable or disable at runtime
        //java -ea MyProgram --enable assertions
        //java -da MyProgram --diable assertions (default)
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        // copy to aux[]
        //TODO:eliminate the copy to the auxiliary array
        //copy to the auxiliary array used for merging
        //switch the role of the input and auxiliary array
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        // merge back to a[]
        int i = lo, j= mid+1;
        for (int k = lo; k <= hi; k++){
            if (i > mid) //when the elements on the left part are all putted in aux array,
                a[k] = aux[j++]; // put the remaining elements on the right to aux 
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];         
        }

        assert isSorted(a, lo, hi);
        
    }

    // is v < W?
    private static boolean less(Comparable v, Comparable w)
    {
        return (v.compareTo(w) < 0);
        
    }

    private static boolean isSorted(Comparable[] a)
    {
        return isSorted(a, 0, a.length -1);
    }
    

    private static boolean isSorted(Comparable[] a, int lo, int hi)
    {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1]))
                return false;
        return true;
    }

    private static void display(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
    
    // test
    public static void main(String[] args)
    {
        String[] a = StdIn.readStrings();
        Merge.sort(a);
        display(a);
        
    }
    
}


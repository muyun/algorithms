//Quick.java: wenlong
//Description: Quick sort
//
//Performace: 1) * not like mergesort and shellshort, there is no data movement within the inner loops (in the partitioning method)
//               * fewer compares, which depends on how well the partitioning divides the array
//            2) * running time will be 1.39NlgN (probabilistic),
//               * is typically faster than mergesort because it does much less data movement
//            
//--------------------------------------------------------------

public class Quick
{
    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        //TODO: for tiny subarrays, invoking insertion sort will be better
        if(hi <= lo)
            return;
        //put entry a[j] in its final place in the array for some j
        int j = partition(a, lo, hi);
        
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    //partitioning divides a large randomly ordered array into two smaller randomly ordered subarrays
    public static int partition(Comparable[] a, int lo, int hi)
    {
        //partition into a[lo..i-1], a[i], a[i+1..hi]
        int i = lo;   //left scan indices
        int j = hi+1;   //right scan indices
        Comparable v = a[lo];   //partitioning item
        
        while(true){
            //increment i while a[i] is less than v
            while(less(a[++i], v))
                if(i == hi)
                    break;
            //decrement j while a[j] is greater than v
            while(less(v, a[--j]))
                if(j == lo)  //redundant, since the partitioning item is at a[lo] and not less than itself
                    break;

            if(i>j)
                break;
            //then for an exchange to maintain the invariant property
            //no entries to the left of i are greater than v and no entries to the right of j are smaller than v 
            swap(a, i, j);
            
        }

        //put v=a[j] into position with a[lo..j-1] <= a[j] <= a[j+1..hi]
        swap(a, lo, j);

        return j;
    }
    
    public static void swap(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
        
    public static boolean less(Comparable v, Comparable w)
    {
        return (v.compareTo(w) < 0);
    }

    public static void display(Comparable[] a)
    {
        for(int i=0; i<a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
    

    public static void main(String[] args)
    {
        String[] a = StdIn.readStrings();
        
        sort(a);
        display(a);
    }
        
}

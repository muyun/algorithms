//Insertion.java

// Compilation: javac Insertion.java
// Execution:   java Insertion < tobe.txt
//---------------------------------------------
import java.util.Comparator;

public class Insertion 
{
    // use Comparator interface
    public static void sort(Object[] a, Comparator c) 
    {
        int N = a.length;
        for (int i = 0; i < N; i++){
            for (int j = i; j > 0 ; j--){
                if (less(c, a[j], a[j-1]))
                    swap(a, j, j-1);
            }
        }

        assert isSorted(a, c);
        
    }
    /*
    public static void sort(Object[] a) 
    {
        int N = a.length;
        for (int i = 0; i < N; i++){
            for (int j = i; j > 0 ; j--){
                if (less(a[j], a[j-1]))
                    swap(a, j, j-1);
            }
        }

    }
    */
    /*
    // Comparator interface(built in to Java): sort using an alternate order
    public interface Comparator<Key>
    {
        int compare(Key v, Key w); //compare keys v and w
        
    }
    */

    public static boolean less(Comparator c, Object v, Object w)
    {
        return c.compare(v, w) < 0;
    }

    public static void swap(Object[] a, int i, int j)
    {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean isSorted( Object[] a, Comparator c)
    {
        for (int i = 1; i < a.length; i++)
            if(less(c, a[i], a[i-1]))
                return false;
        return true;
        
    }

    public static void display(Object[] a)
    {
        for(int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
    }

    public static void main(String[] args)
    {
        String[] a = StdIn.readStrings();
        
        // Insertion.sort(a);
        display(a);
    }
}


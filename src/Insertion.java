//Insertion.java

// Compilation: javac Insertion.java
// Execution:   java Insertion < input.txt

import  java.util.Comparator;

public class Insertion 
{
    // use natural order and Comparable interface
    public static void sort(Comparable[] a) 
    {
        int N = a.length;
        for (int i = 0; i < N; i++){
            for (int j = i; j > 0 ; j--){
                if (less(a[j], a[j-1]))
                    exch(a, j, j-1);
            }
        }

        assert isSorted(a);
        
    }
    /*
    // Comparable interface(built in to Java)
    public interface Comparable<Item>
    {
        public int compareTo(Item that);
        
    }
    */

    private static boolean less(Comparable v, Comparable w)
    {
        return (v.compareTo(w) < 0);
    }

    private static void exch(Object[] a, int i, int j)
    {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a)
    {
        for (int i = 1; i < a.length; i++)
            if(less(a[i], a[i-1]))
                return false;
        return true;
        
    }

    private static void show(Comparable[] a)
    {
        for(int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
    }

    public static void main(String[] args)
    {
        String[] a = StdIn.readStrings();
        Insertion.sort(a);
        show(a);
        
    }
}


// sort.java
// bubble sort
//Selection Sort improves on the bubble sort by reducing the number of swaps necessary
// from O(N*N) to O(N). Unfortunately, the number of comparisons remains O(N*N)

//Insertion Sort 
class ArraySort
{
    private int[] a;  // ref to array a
    private int num;     // number of item

    public ArraySort(int max)
    {
        a = new int[max]; // create the array
        num = 0;
    }

    public void Insert(int value) //
    {
        a[num] = value;
        num ++;
        
    }

    public void Display()
    {
        for (int i=0; i< num; i++)
            System.out.print(a[i] + " ");
        
        System.out.println("");
    }

    //bubble sort
    //find the remaining biggest in every loop
    public void BubbleSort()
    {
        int out, in;
        //put the smallest item at the beginning of the array(index 0)
        // and the largest item at the end (index num-1)
        for(out=num-1; out>1; out--) // outer loop is backward
            for(in=0; in<out; in++) // inner loop is forward
                if (a[in]>a[in+1])
                    swap(a[in],a[in+1]);
    }

    public void swap(int one, int two)
    {
        int temp=one;
        one = two ;
        two = temp;
    }

    //Selection Sort
    public void SelectionSort()
    {
        int out, in, min;
        for(out=0; out<num-1; out++)
        {
            min = out; // find the minimum
            for (in=out+1; in<num; in++)
                if(a[in]<a[min])
                    min=in;
            swap(a[out],a[min]);
            // less swap comparisons
        }
    }

    // Insertion Sort
    // partially sorted means that they are sorted among themselves,
    // each one is taller than the person to his left.
    // insert the marked player in the appropriate place in the(partially) sorted group
    public void InsertionSort()
    {
        int in, out;
        for (out=1; out<num; out++) // out marks the leftmost unsorted data
        {
            int temp = a[out];   // remove marked item
            in = out;
            while(in>0 && temp <= a[in-1])  // in starts at out and moves left
            {                               // until either temp is smaller than the array element
                                            // or it can't go left any further
                a[in] = a[in-1];
                --in;
            }

            a[in] = temp; //insert marked item
            
        }
        
    }
    
}


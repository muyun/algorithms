// sort.java
// bubble sort
//Selection Sort improves on the bubble sort by reducing the number of swaps necessary
// from O(N*N) to O(N). Unfortunately, the number of comparisons remains O(N*N) .
//
// Insertion Sort does up to max of N*(N-1)/2 times comparisons; The number of copies is
// approximately the same as the number of comparisons. However, a copy isn't as time-consuming as a swap,
// so for random data this algorithm runs twice as fast as the bubble sort and faster than selection sort.

// ShellSort:  There are two many copies in Insertion Sort, ShellSort improve it through moving a smaller item
// many spaces to the left without shifting all the intermediate items individually (bring in gap sequence)

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

    //shellSort
    // ShellSort move a smaller item many spaces to the left without shifting all
    // the intermediate items individually, it makes use of interval sequence or gap sequence to achive this
    public void ShellSort()
    {
        int h = 1;
        while (h <= num/3)   
            h = h*3 + 1;    // get gap sequence ? Why?
        
        int in, out;
        while(h>0)
        {
            for(out=h; out<num; out++)
            {
                int temp = a[out];
                in = out;
                while(in>h-1 && temp< a[in-h])
                {
                    a[in]=a[in-h];
                    in=in-h;
                }

                a[in] = temp;
            }
            
            h = (h-1) / 3;   / next gap
        }
    }
}

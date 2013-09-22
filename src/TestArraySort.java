//ArraySortApp
class ArraySortApp
{
    public static void main(String[] args)
    {
        int max =20;
        ArraySort arr;
        arr = new ArraySort(max);

        arr.Insert(8);
        arr.Insert(3);
        arr.Insert(5);
        arr.Insert(9);
        arr.Insert(7);

        arr.Display();

        arr.InsertionSort();
        
        arr.Display();

        //test ShellSort
        ArraySort arr1;
        arr1 = new ArraySort(max);
        
        for(int i =0; i<max;i++)
        {
            int n = (int)(java.lang.Math.random()*99);
            arr1.Insert(n);
            
        }
        arr1.Display();

        arr1.ShellSort();

        arr1.Display();
        
    }
    
}


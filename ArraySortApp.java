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
        
    }
    
}


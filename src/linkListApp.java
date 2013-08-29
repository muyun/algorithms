//linkListApp.java
class linkListApp
{
    public static void main(String[] args)
    {
        linkList mylist = new linkList();

        mylist.insertFirst(22, 2.99);
        mylist.insertFirst(44, 4.99);
        mylist.insertFirst(66, 6.99);
        mylist.insertFirst(88, 8.99);
        
        mylist.displayList();

        link f = mylist.find(44);
        if (f != null)
            System.out.println("Found link with key " + f.iData);
        else
            System.out.println("Can't find link");

        link d = mylist.delete(66);
        if (d != null)
            System.out.println("Deleted link with key " + d.iData);
        else
            System.out.println("Can't delete link");

        mylist.displayList();
        
    }// end main()
    
}// end class linkListApp


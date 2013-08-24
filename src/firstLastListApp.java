// firstLastListApp.java
class firstLastListApp
{
    public static void main(String[] args)
    {
        firstLastList mylist = new firstLastList();

        mylist.insertFirst(22,2.99); // insert at front
        mylist.insertFirst(44,4.99);
        mylist.insertFirst(66,6.99);

        mylist.insertLast(11,1.99);  // insert at rear
        mylist.insertLast(33,3.99);
        mylist.insertLast(55,5.99);

        mylist.displayList();

        mylist.deleteFirst();   // delete first two items
        mylist.deleteFirst();
        
        mylist.displayList();
                
    }// end main
    
} // end firstLastListApp


//firstLastList.java
// double-ended lists
// one additional feature: a reference to the last link as well as to the first
// which means we can insert a new link directly at the end of the list as well as at the beginning
class firstLastList
{
    private link first;  // ref to the first link
    private link last;   // ref to the last link

    public firstLastList()  // constructor
    {
        first = null;
        last = null;
    }

    public boolean isEmpty()
    {
        return first == null;
        
    }

    public void insertFirst(int id,double dd)  // **insert** at front of list
    {
        link newLink = new link(id, dd);
        
        if ( isEmpty() ){
            last = newLink;    // only one item in the list, so last connects newLink
            
        }
        
        newLink.next = first;  // newLink connect old first
        first = newLink;    // first connect newlink
        
    }

    public void insertLast(int id, double dd) // **insert** at end of listx
    {
        link newLink = new link(id, dd);

        if ( isEmpty() ){
            first = newLink;
        }
        // now we make newLink as the ref to last item
        // newLink is the last item, so the next two is wrong
        //newLink.next = last;  
        //last = newLink;
        last.next = newLink;  // old last next connects to newLink
        last = newLink;       // last connects newLink
        
    }

    public link deleteFirst() // delete first link
    {
        link temp = first;
        if (first.next == null)
            last = null;
        
        first = first.next;  // first.next is null if only one item
        return temp;
        
    }

    public void displayList()
    {
        System.out.print("List (first -->last): ");
        link current = first;   // start at beginning
        while (current != null)
        {
            current.displayLink();
            current = current.next;
            
        }
        System.out.println("");
                
    }
            
}// end class firstLastList

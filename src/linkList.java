//linkList.java
// we have to use relationships between the items to locate it in list
class linkList
{
    private link first;  // reference

    public linkList()  // constructor
    {
        first = null;
        
    }

    public void insertFirst(int id, double dd)  // make new link
    {
        link newLink = new link(id, dd);  // reference newLink to link object
        newLink.next = first;  //
        first = newLink;       // now first ponts to this
                
    }

    public link find(int key)   // find link with given key
    {
        link current = first;   // start at first
        while(current.iData != key){
            if(current.next == null)
                return null;
            else
                current = current.next;   // go to next link
            
        }

        return current;
                
    }

    public link delete(int key)  // delete link with given key
    {
        link current = first;
        link previous = first;

        while(current.iData != key){
            if (current.next  == null)
                return current;
            
            else{
                previous = current;   // go to next link
                current = current.next;
                
            }
                        
        }

        if(current == first)              // if first link,
            first = first.next;           // change first
        else                               // otherwise,
            previous.next = current.next;  // bypass current
        
        return current;
        
    }

    public void displayList()  // display the list
    {
        System.out.print("List (first -->last): ");
        link current = first; // start at beginning of list
        while(current != null){
            current.displayLink();
            current = current.next;
            
        }
        System.out.println("");
        
    }
    
}// end class linkList

// linkStack.java
// a stack implemented by a linked list
// Compared an array, the linked list is faster:
// i) nothing needs to be moved when an item is inserted or deleted
// ii) linked list uses exactly as much memory as it needs, and can expand to
//     fill all of the available memory while the size of an array is fixed
import java.io.*;

class linkStack {
    
    private linkList mylist;
    
    public linkStack(){  //constructor
        mylist = new linkList();
        
    }
    
    public void push(int id, double dd){
        
        mylist.insertFirst(id, dd);
        
    }
    
    public link pop() {
        
        return mylist.deleteFirst();
        
    }
    
    public boolean isEmpty()
    {
        return (mylist.isEmpty());
        
    }
    
    public void displayStack()
    {
        System.out.print("Stack (top --> bottom): ");
        mylist.displayList();
                
    }
    
}  // end class linkStack

//linkStackApp.java
//compile:javac link.java linkList.java linkStack.java linkStackApp.java
import java.io.*;

class linkStackApp
{
    public static void main(String[] args) throws IOException
    {
        linkStack mystack = new linkStack();  // make stack

        mystack.push(20,2.99);  // push items
        mystack.push(40,4.99);

        mystack.displayStack(); // display

        mystack.push(60,6.99);
        mystack.push(80,8.99);

        mystack.displayStack();

        mystack.pop();
        mystack.pop();

        mystack.displayStack();
                
    } // main
    
} // end class linkStackApp



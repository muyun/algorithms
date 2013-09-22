//queueApp.java
import java.io.*;
class queueApp{
    public static void main(String[] args){
        
        queue myQueue = new queue(5);   // hold 5 items
        myQueue.insert(10);
        myQueue.insert(20);
        myQueue.insert(30);
        myQueue.insert(40);
        
        myQueue.remove();   // remove 10, 20,30
        myQueue.remove();   // and rear and front now point 40
        myQueue.remove();
        
        myQueue.insert(50);  //wraps around
        myQueue.insert(60);
        myQueue.insert(70);
        myQueue.insert(80);
        
        
        
        while( !myQueue.isEmpty()){
            
            int n = myQueue.remove();
            System.out.print(n);
            System.out.print(" ");   // 40 50 60 70 80
        }
        
        System.out.println("");
        
    }// end main()
} // end class queueApp
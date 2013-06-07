// stack.java
// Stack: Last-In-First-Out storage mechanism
// The stack defines a stack class with push, pop, peel and size methods
//
import java.io.*;

class stackx {
    private int maxSize;  //size of stack array
    private char[] stackArray;
    private int top;      // top of stack
    
    public stackx(int s){  //constructor
        
        maxSize = s;       //set array size
        stackArray = new char[maxSize];   // create array
        top = -1;          // no items yet
    }
    
    public void push(char j){
        
        stackArray[++top] = j;   // increment top and insert item
    }
    
    public char pop() {
        
        return stackArray[top--]; // access the item and decrement top
    }
    
    public char peek() {// peak at top of stack
        
        return stackArray[top];
    }
    
    public boolean isEmpty() {  //true if empty
        return (top == -1);
    }
    
    public boolean isFull() {    // true if full
        return (top == maxSize - 1);
    }
    
}  // end class stackx

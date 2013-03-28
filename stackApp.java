// application of stack
// reverse the string

import java.io.*;

class reverser {
    private String input;
    private String output;
    
    public reverser (String in){   // constructor
        input = in;
    }
    
    public String doReverse(){
        
        int stackSize = input.length();  // get max stack size
        stackx myStack = new stackx(stackSize);   // make stack
        
        for (int i=0; i<input.length(); i++){
            
            char ch = input.charAt(i);  //get the char from input
            myStack.push(ch);
        }
        
        output = "";
        while( !myStack.isEmpty()){
            
            char ch = myStack.pop();
            output = output + ch;
        }
        
        return output;
    }
} // end class reverser

class reverseApp{
    public static void main(String[] args) throws IOException{
        
        String input, output;
        while(true){
            
            System.out.print("Enter a string: ");
            System.out.flush();
            
            input = getString(); // read a string from keyboard
            if( input.equals("") ) // quit if 'Enter'
                break;
            
            reverser myReverser = new reverser(input);
            output = myReverser.doReverse();
            System.out.println("Reversed: " + output);
        } // end while
    } //end main()
    
    public static String getString() throws IOException{
    
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }    
         
}  // end class reverseApp
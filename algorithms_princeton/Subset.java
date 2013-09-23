//Subset.java: wenlong
//Description: takes a command-line integer k, and prints out excatly k of them, uniformly at random
//
//Performance: use time and space proportional to at most N in the worst case
//
//------------------------------------------------------------------------------------
public class Subset
{
    public static void main(String[] args)
    {
        int k = Integer.parseInt(args[0]);

        RandomizedQueue<String> rqueue = new RandomizedQueue<String>();
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            rqueue.enqueue(s);
        }

        for(int i=0; i<k; i++){
            StdOut.println(rqueue.dequeue());
        }
        
    }
    
}

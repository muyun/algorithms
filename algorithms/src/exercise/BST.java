package exercise;

import java.util.LinkedList;
import java.util.Queue;

//import challenge.BinTreeTraverse;

class BinNode {
	  int data;
	  BinNode left;
	  BinNode right;
	  

	public BinNode(int d){
		  this.data = d;
		  left = null;
		  right = null;
	  }
}

public class BST {
     static BinNode root;
  
     public BST(){
    	 this.root = null;
     }
  
     void Insert(int data){
	     BinNode node = new BinNode(data);
	     if(root == null){
	    	 root = node;
	    	 return;
	     }
	     
	     BinNode current = root;
	     BinNode parent = null;
	     
	     while(true){
	    	 parent = current;
	    	 if(data <= current.data){
	    		 current = current.left; // left node
	    		 
	    		 if(current == null){
	    			 parent.left = node;
	    			 return;
	    		 }
	    		 
	    	 } else {
	    		 current = current.right;
	    		 
	    		 if(current == null){
	    			 parent.right = node;
	    			 return;
	    		 }
	    	 }
	     }
	   
     }

     static void  Display(BinNode root){
    	 if(root != null){
    		 Display(root.left);
    		 System.out.print(" " + root.data);
    		 Display(root.right);
    	 }
     }
     
 	// level order
 	public void DisplaylayerOrder(BinNode localroot){
 		if(localroot == null){
 			return;
 		}
 		
 		/*
 		ArrayList<Node> q = new ArrayList<Node>();
 		q.add(root);
 		*/
 		
 		//use the queue here to print
 		Queue<BinNode> queue = new LinkedList<BinNode>();
 		queue.add(localroot);
 		
 		
 		while(!queue.isEmpty()){
 			BinNode node = queue.poll();
 			// visit the head
 			System.out.print(node.data +  " ");
 			
 			if(node.left != null){ // keep left child in the list
 				queue.add(node.left);
 			}
 			
 			if(node.right != null) // keep right chil in the list
 				queue.add(node.right);
 		}
 		
 		System.out.println();
 	}
     
 	//test
 	public static void main(String[] args){
 		//init
 		int[] data = {8,6,10,5,7,9,11};
 		
 		BST bt = new BST();
 		
 		//build the tree
 		for(int d : data){
 			bt.Insert(d);
 		}
 		
 		//bt.printTree(root);
 		
 		//print the level order
         bt.DisplaylayerOrder(root);	
         
 		System.out.println("Done.");
 	}

}

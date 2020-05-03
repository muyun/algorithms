//package graph.src;
//import java.util.Collection;
import java.util.TreeSet;
import java.util.Iterator;


// an API that defines the fundamental graph operations
// API for an undirected graph
//
public class Graph {
	//
	// vertices
	//private int V;
	// number of edges
	private int E;
	
    // symbol table: key = string vertex, value = set of neighboring vertices  
	private ST<String, SET<String>> st;
	
	public Graph() {
		st = new ST<String, SET<String>>();
	}
	
	/*
	public Graph(String filename, String delimiter) {
		st = new ST<String, SET<String>>();
		
		//StdIn in = new StdIn(filename);	
	}
	*/
	
	public int V() {
		return st.size();
	}
	
	public int E() {
		return E;
	}
	
	public boolean hasVertex(String v) {
        return st.contains(v);
    }
	
	public void addVertex(String v) {
	        if (!hasVertex(v)) st.put(v, new SET<String>());
	    }
	
	public boolean hasEdge(String v, String w) {
        //validateVertex(v);
        //validateVertex(w);
        return st.get(v).contains(w);
    }
	

	
	public void addEdge(String v, String w) {
		if (!hasVertex(v)) addVertex(v);
        if (!hasVertex(w)) addVertex(w);
        if (!hasEdge(v, w)) E++;
		st.get(v).add(w);
		st.get(w).add(v);
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (String v : st) {
			s.append(v + ": ");
			for (String w : st.get(v)) {
				s.append(w + " ");
			}
			s.append('\n');
			
		}
		return s.toString();
	}
	
	// return the vertices in the graph
	public Iterable<String> vertices() {
		return st.keys();
	}
	
	// return the set of vertices adjacent to v in the graph
	public Iterable<String> adjacentTo(String v) {
		return st.get(v);
	}
	
	
	public static void main(String[] args) {
		//create graph
		Graph graph = new Graph();
		while (!StdIn.isEmpty()) {
			String v = StdIn.readString();
			String w = StdIn.readString();
			graph.addEdge(v, w);
		}
		
		//print
		StdOut.println(graph);
		
		//
		for (String v : graph.vertices()) {
			StdOut.print(v + ": ");
			for (String w : graph.adjacentTo(v)) {
				StdOut.print(w + " ");
			}
			StdOut.println();
		}
		
	}
}
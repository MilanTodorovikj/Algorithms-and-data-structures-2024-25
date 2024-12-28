package Aud10.MarixWeightedUndirected;

import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class PrimGraphTester {
	public static void main(String[] args) {
		
		int maximumVertices = 9;
    	
    	AdjacencyMatrixGraph<Integer> g = new AdjacencyMatrixGraph<>(maximumVertices);
    	
    	//adding edges
    	g.addEdge(0, 1, 4);
    	g.addEdge(0, 7, 8);
    	g.addEdge(1, 7, 11);
    	g.addEdge(1, 2, 8);
    	g.addEdge(2, 3, 7);
    	g.addEdge(2, 5, 4);
    	g.addEdge(2, 8, 2);
    	g.addEdge(3, 4, 9);
    	g.addEdge(3, 5, 14);
    	g.addEdge(4, 5, 10);
    	g.addEdge(5, 6, 2);
    	g.addEdge(6, 7, 1);
    	g.addEdge(6, 8, 6);
    	g.addEdge(7, 8, 7);
    	
    	
    	Random r = new Random();
    	
    	int start_index = r.nextInt(maximumVertices);

    	// to ensure to get a result MST for the test put start_index = 0
		List<Edge> mst = g.prim(start_index);
    	
		System.out.println("Minimum Spanning Tree edges gotten with Prim with start vertex "+start_index+" are:");
    	ListIterator<Edge> it = mst.listIterator();
    	while(it.hasNext()){
    		Edge e = it.next();
    		System.out.println ("vertex" + e.getFrom() + " --- vertex" + e.getTo());
    	}
	}

}

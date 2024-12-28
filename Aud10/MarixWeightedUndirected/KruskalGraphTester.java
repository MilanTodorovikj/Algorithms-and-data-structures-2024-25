package Aud10.MarixWeightedUndirected;

import java.util.List;
import java.util.ListIterator;

public class KruskalGraphTester {
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
    	
		List<Edge> mst = g.kruskal();
    	
		System.out.println("Minimum Spanning Tree edges are:");
    	ListIterator<Edge> it = mst.listIterator();
    	while(it.hasNext()){
    		Edge e = it.next();
    		System.out.println ("v" + e.getFrom() + " --- v" + e.getTo());
    	}
		
	}

}

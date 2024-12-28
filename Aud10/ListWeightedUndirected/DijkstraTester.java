package Aud10.ListWeightedUndirected;

import java.util.Map;
import java.util.Random;

public class DijkstraTester {

	public static void main(String[] args) {

		int maximumVertices = 9;

    	AdjacencyListGraph<Integer> g = new AdjacencyListGraph<>();
    	
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
    	
		Map<Integer, Integer> distance = g.shortestPath(start_index);
    	
		System.out.println("Minimum costs with start vertex "+start_index+" are:");
    	for(Integer dest: distance.keySet()){
    		System.out.println ("Cost from vertex" + start_index + " to vertex" + dest + " is " + distance.get(dest));
    	}
	}

}

package Aud09;

import java.util.Random;

public class AdjacencyMatrixGraphTester {

	public static void main(String[] args) {
		AdjacencyMatrixGraph<Character> graph = new AdjacencyMatrixGraph<Character>(10);

		for(int i=0;i<10;i++)
			graph.addVertex(i, (char)((int)'A'+i));
				
		//Adding 15 random edges between nodes
		int x, y;
		Random r = new Random();
		for(int i=0;i<15;i++){
			x = r.nextInt(10);
			y = r.nextInt(10);
			if(x!=y){
				if(!graph.isEdge(x, y)){
					graph.addEdge(x, y);
					System.out.println("Adding edge between "+graph.getVertex(x)+" and "+graph.getVertex(y));
				}
				else
					i--;
			}
			else
				i--;
		}
		System.out.println(graph);
		
		AdjacencyListGraph<Character> adjacencyList = graph.toAdjacencyList();
		
		System.out.println(adjacencyList);
	}

}

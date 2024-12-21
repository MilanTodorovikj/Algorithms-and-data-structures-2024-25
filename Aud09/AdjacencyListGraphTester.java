package Aud09;

public class AdjacencyListGraphTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AdjacencyListGraph<Character> graph = new AdjacencyListGraph<Character>();
		graph.addEdge('A', 'B'); //Adding edge from A to B
		graph.addEdge('B', 'C'); //Adding edge from B to C
		graph.addEdge('C', 'D'); //Adding edge from C to D
		graph.addEdge('D', 'G'); //Adding edge from D to G
		graph.addEdge('G', 'J'); //Adding edge from G to J
		graph.addEdge('B', 'F'); //Adding edge from B to F
		graph.addEdge('F', 'I'); //Adding edge from F to I
		graph.addEdge('A', 'E'); //Adding edge from A to E
		System.out.println(graph);
		System.out.println("Depth First Search Recursive:");
		graph.DFS('A');
		System.out.println("\nDepth First Search Nonrecursive:");
		graph.DFSNonRecursive('A');
		System.out.println("\nBreath First Search:");
		graph.BFS('A');
	}

}

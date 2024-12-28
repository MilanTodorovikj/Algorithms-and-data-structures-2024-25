package Aud10.ListUnweightedDirected;

import java.util.*;

public class AdjacencyListGraph<T> {
	private Map<T, Set<T>> adjacencyList;

	public AdjacencyListGraph() {
		this.adjacencyList = new HashMap<>();
	}

	// Add a vertex to the graph
	public void addVertex(T vertex) {
		if (!adjacencyList.containsKey(vertex)) {
			adjacencyList.put(vertex, new HashSet<>());
		}
	}

	// Remove a vertex from the graph
	public void removeVertex(T vertex) {
		// Remove the vertex from all adjacency lists
		for (Set<T> neighbors : adjacencyList.values()) {
			neighbors.remove(vertex);
		}
		// Remove the vertex's own entry in the adjacency list
		adjacencyList.remove(vertex);
	}

	// Add an edge to the graph
	public void addEdge(T source, T destination) {
		addVertex(source);
		addVertex(destination);

		adjacencyList.get(source).add(destination);
	}

	// Remove an edge from the graph
	public void removeEdge(T source, T destination) {
		if (adjacencyList.containsKey(source)) {
			adjacencyList.get(source).remove(destination);
		}
	}

	// Get all neighbors of a vertex
	public Set<T> getNeighbors(T vertex) {
		return adjacencyList.getOrDefault(vertex, new HashSet<>());
	}
	
	public void DFS(T startVertex) {
		Set<T> visited = new HashSet<>();
		DFSUtil(startVertex, visited);
	}
	
	private void DFSUtil(T vertex, Set<T> visited) {
		// Mark the current node as visited and print it
		visited.add(vertex);
		System.out.print(vertex + " ");
		
		// Recur for all the vertices adjacent to this vertex
		for (T neighbor : getNeighbors(vertex)) {
			if (!visited.contains(neighbor)) {
				DFSUtil(neighbor, visited);
			}
		}
	}


	public void DFSNonRecursive(T startVertex) {
		Set<T> visited = new HashSet<>();
		Stack<T> stack = new Stack<>();
		
		stack.push(startVertex);
		while (!stack.isEmpty()) {
			T vertex = stack.pop();
			if (!visited.contains(vertex)) {
				visited.add(vertex);
				System.out.print(vertex + " ");
				for (T neighbor : getNeighbors(vertex)) {
					if (!visited.contains(neighbor)) {
						stack.push(neighbor);
					}
				}
			}
		}
	}

	public void printPath(T source, T destination) {
		Set<T> visited = new HashSet<>();
		Stack<T> stack = new Stack<>();

		stack.push(source);
		visited.add(source);
		while (!stack.isEmpty() && !stack.peek().equals(destination)) {
			T vertex = stack.peek();

			boolean f = true;
			for(T neighbor: getNeighbors(vertex)) {
				if(!visited.contains(neighbor)) {
					stack.push(neighbor);
					visited.add(neighbor);
					f = false;
					break;
				}
			}

			if(f) {
				stack.pop();
			}
		}

		Stack<T> path = new Stack<>();

		while(!stack.isEmpty()) {
			path.push(stack.pop());
		}

		while(!path.isEmpty()) {
			System.out.print(path.pop() + " ");
		}
	}

	public void BFS(T startVertex) {
		Set<T> visited = new HashSet<>();
		Queue<T> queue = new LinkedList<>();

		visited.add(startVertex);
		queue.add(startVertex);

		while (!queue.isEmpty()) {
			T vertex = queue.poll();
			System.out.print(vertex + " ");

			for (T neighbor : getNeighbors(vertex)) {
				if (!visited.contains(neighbor)) {
					visited.add(neighbor);
					queue.add(neighbor);
				}
			}
		}
	}

	// DFS utility function used for topological sorting
	private void topologicalSortUtil(T vertex, Set<T> visited, Stack<T> stack) {
		visited.add(vertex);
		for (T neighbor : getNeighbors(vertex)) {
			if (!visited.contains(neighbor)) {
				topologicalSortUtil(neighbor, visited, stack);
			}
		}
		stack.push(vertex);
	}

	public List<T> topologicalSort() {
		Stack<T> stack = new Stack<>();
		Set<T> visited = new HashSet<>();

		for (T vertex : adjacencyList.keySet()) {
			if (!visited.contains(vertex)) {
				topologicalSortUtil(vertex, visited, stack);
			}
		}

		List<T> order = new ArrayList<>();
		while (!stack.isEmpty()) {
			order.add(stack.pop());
		}
		return order;
	}


	@Override
	public String toString() {
		String ret = new String();
		for (Map.Entry<T, Set<T>> vertex : adjacencyList.entrySet())
			ret += vertex.getKey() + ": " + vertex.getValue() + "\n";
		return ret;
	}



}
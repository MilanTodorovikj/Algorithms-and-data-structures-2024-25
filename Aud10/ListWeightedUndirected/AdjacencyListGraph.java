package Aud10.ListWeightedUndirected;

import java.util.*;

public class AdjacencyListGraph<T> {
	private Map<T, Map<T, Integer>> adjacencyList;

	public AdjacencyListGraph() {
		this.adjacencyList = new HashMap<>();
	}

	// Add a vertex to the graph
	public void addVertex(T vertex) {
		if (!adjacencyList.containsKey(vertex)) {
			adjacencyList.put(vertex, new HashMap<>());
		}
	}

	// Remove a vertex from the graph
	public void removeVertex(T vertex) {
		// Remove the vertex from all adjacency lists
		for (Map<T, Integer> neighbors : adjacencyList.values()) {
			neighbors.remove(vertex);
		}
		// Remove the vertex's own entry in the adjacency list
		adjacencyList.remove(vertex);
	}

	// Add an edge to the graph
	public void addEdge(T source, T destination, int weight) {
		addVertex(source);
		addVertex(destination);

		adjacencyList.get(source).put(destination, weight);
		adjacencyList.get(destination).put(source, weight); // for undirected graph
	}

	// Remove an edge from the graph
	public void removeEdge(T source, T destination) {
		if (adjacencyList.containsKey(source)) {
			adjacencyList.get(source).remove(destination);
		}
		if (adjacencyList.containsKey(destination)) {
			adjacencyList.get(destination).remove(source); // for undirected graph
		}
	}

	// Get all neighbors of a vertex
	public Map<T, Integer> getNeighbors(T vertex) {
		return adjacencyList.getOrDefault(vertex, new HashMap<>());
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
		for (T neighbor : getNeighbors(vertex).keySet()) {
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
				for (T neighbor : getNeighbors(vertex).keySet()) {
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
			for(T neighbor: getNeighbors(vertex).keySet()) {
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

			for (T neighbor : getNeighbors(vertex).keySet()) {
				if (!visited.contains(neighbor)) {
					visited.add(neighbor);
					queue.add(neighbor);
				}
			}
		}
	}

	public Map<T, Integer> shortestPath(T startVertex) {
		Map<T, Integer> distances = new HashMap<>();
		PriorityQueue<T> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
		Set<T> explored = new HashSet<>();

		// Initialize distances
		for (T vertex : adjacencyList.keySet()) {
			distances.put(vertex, Integer.MAX_VALUE);
		}
		distances.put(startVertex, 0);

		queue.add(startVertex);

		while (!queue.isEmpty()) {
			T current = queue.poll();
			explored.add(current);

			for (Map.Entry<T, Integer> neighborEntry : adjacencyList.get(current).entrySet()) {
				T neighbor = neighborEntry.getKey();
				int newDist = distances.get(current) + neighborEntry.getValue();

				if (newDist < distances.get(neighbor)) {
					distances.put(neighbor, newDist);

					// Update priority queue
					if (!explored.contains(neighbor)) {
						queue.add(neighbor);
					}
				}
			}
		}

		return distances;
	}

	@Override
	public String toString() {
		String ret = new String();
		for (Map.Entry<T, Map<T, Integer>> vertex : adjacencyList.entrySet())
			ret += vertex.getKey() + ": " + vertex.getValue() + "\n";
		return ret;
	}



}
package Aud09;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph<T> {
	private int numVertices;
	private int[][] matrix;
	private T[] vertices;

@SuppressWarnings("unchecked")
	public AdjacencyMatrixGraph(int numVertices) {
	this.numVertices = numVertices;
	matrix = new int[numVertices][numVertices];
	vertices = (T[]) new Object[numVertices];
	}

	public void addVertex(int index, T data) {
		vertices[index] = data;
		}

	public T getVertex(int index) {
		return vertices[index];
	}

	public void addEdge(int source, int destination) {
		matrix[source][destination] = 1;
		matrix[destination][source] = 1; // For undirected graph
		}
	
	public boolean isEdge(int source, int destination) {
		return matrix[source][destination] == 1;
	}
	
	
	public void removeEdge(int source, int destination) {
		matrix[source][destination] = 0;
		matrix[destination][source] = 0; // For undirected graph
	}
	
	@SuppressWarnings("unchecked")
	public void removeVertex(int vertexIndex) {
		if (vertexIndex < 0 || vertexIndex >= numVertices) {
			throw new IndexOutOfBoundsException("Vertex index out of bounds!");
		}
		int[][] newMatrix = new int[numVertices-1][numVertices-1];
		T[] newVertices = (T[]) new Object[numVertices-1];
		// Copy the vertices and matrix excluding the given vertex
		int ni = 0;
		for (int i = 0; i < numVertices; i++) {
			if (i == vertexIndex) continue;
			int nj = 0;
			for (int j = 0; j < numVertices; j++) {
				if (j == vertexIndex) continue;
				newMatrix[ni][nj] = matrix[i][j];
				nj++;
			}
			newVertices[ni] = vertices[i];
			ni++;
		}
		// Replace the old matrix and vertices with the new ones
		matrix = newMatrix;
		vertices = newVertices;
		numVertices--;
	}
	
	public List<T> getNeighbors(int vertexIndex) {
		List<T> neighbors = new ArrayList<>();
		for (int i = 0; i < matrix[vertexIndex].length; i++) {
			if (matrix[vertexIndex][i] == 1) {
				neighbors.add(vertices[i]);
			}
		}
		return neighbors;
	}
	
	
	public AdjacencyListGraph<T> toAdjacencyList() {
		AdjacencyListGraph<T> result = new AdjacencyListGraph<>();

		for(int i=0;i<numVertices;i++) {
			result.addVertex(vertices[i]);
		}

		for(int i=0;i<numVertices;i++) {
			for(int j=0;j<numVertices;j++) {
				if(matrix[i][j] > 0) {
					result.addEdge(vertices[i], vertices[j]);
				}
			}
		}
		return result;
	}

	
	@Override
	public String toString() {
		String ret = "  ";
		for(int i = 0; i < numVertices; i++)
			ret += vertices[i] + " ";
		ret += "\n";
		for(int i = 0; i < numVertices; i++){
			ret += vertices[i] + " ";
			for(int j = 0; j < numVertices; j++)
				ret += matrix[i][j] + " ";
			ret += "\n";
		}
		return ret;
	}
	
}



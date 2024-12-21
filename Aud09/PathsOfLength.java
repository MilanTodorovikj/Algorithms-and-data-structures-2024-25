package Aud09;

import java.util.Scanner;

public class PathsOfLength {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int edges = sc.nextInt();
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<Integer>();
        for (int i = 0; i < edges; i++) {
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }
        Integer start = sc.nextInt();
        int length = sc.nextInt();
        graph.pathsOfLengthN(start, length);
    }
}

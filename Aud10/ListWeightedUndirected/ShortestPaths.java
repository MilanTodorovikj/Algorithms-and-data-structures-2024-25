package Aud10.ListWeightedUndirected;

import java.util.Map;
import java.util.Scanner;

public class ShortestPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        for (int i = 0; i < n; i++){
            graph.addEdge(sc.next(), sc.next(), sc.nextInt());
        }

        Map<String, Integer> paths = graph.shortestPath("Skopje");
        System.out.println(paths.get(sc.next()));

    }

}

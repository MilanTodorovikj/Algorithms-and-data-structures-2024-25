package Aud09;

import java.util.Scanner;

public class ShortestUnweightedPath {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int edges = sc.nextInt();
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<String>();
        for (int i = 0; i < edges; i++){
            String city1 = sc.next();
            String city2 = sc.next();
            graph.addEdge(city1, city2);
        }
        String startCity = sc.next();
        String endCity = sc.next();


        System.out.println("Steps needed to get from " + startCity + " to "
                + endCity + ": " + graph.shortestPath(startCity, endCity));

    }
}

package Aud10.MarixWeightedUndirected;

import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

public class Flood {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int P = sc.nextInt();
        sc.nextLine();

        HashMap<String, Integer> mapping = new HashMap<>();

        AdjacencyMatrixGraph<String> cityNetwork = new AdjacencyMatrixGraph<>(M);

        int trees[] = new int[M];

        for(int i=0;i<M;i++) {
            String city = sc.nextLine();
            mapping.put(city, i);
            cityNetwork.addVertex(i, city);
            trees[i] = i+1;
        }

        for(int i=0;i<N;i++) {
            String line = sc.nextLine();
            String parts[] = line.split(" ");
            cityNetwork.addEdge(mapping.get(parts[0]), mapping.get(parts[1]), Integer.parseInt(parts[2]));
        }

        for(int i=0;i<P;i++) {
            String line = sc.nextLine();
            String parts[] = line.split(" ");
            trees[mapping.get(parts[0])] = 0;
            trees[mapping.get(parts[1])] = 0;
        }

        sc.close();

        List<Edge> resultEdges = cityNetwork.adaptedKruskal(trees);

        float suma = 0;

        for(Edge e : resultEdges) {
            suma+=e.getWeight();
        }

        System.out.println(resultEdges.size() + " " + suma);

        for(Edge e : resultEdges) {
            System.out.println(cityNetwork.getVertex(e.getFrom()) + " " + cityNetwork.getVertex(e.getTo()));
        }
    }
}
package Aud10.ListWeightedUndirected;

import java.util.Map;
import java.util.Scanner;

public class Plumbing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        AdjacencyListGraph<Integer> waterNetwork = new AdjacencyListGraph<>();
        int values[] = new int[n];

        for(int i=0;i<n;i++) {
            int ind = sc.nextInt();
            int val = sc.nextInt();

            waterNetwork.addVertex(ind);
            values[ind] = val;
        }

        int m = sc.nextInt();

        for(int i=0;i<m;i++) {
            waterNetwork.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        int p = sc.nextInt();

        for(int i=0;i<p;i++) {
            int startVertex = sc.nextInt();
            int endVertex = sc.nextInt();
            int increaseFactor = sc.nextInt();
            waterNetwork.addEdge(startVertex, endVertex, waterNetwork.getNeighbors(startVertex).get(endVertex)*increaseFactor);
        }

        sc.close();

        Map<Integer, Integer> shortestPaths = waterNetwork.shortestPath(0);

        for(int i=1;i<n;i++) {
            if(values[i] != 0) {
                if(values[0] - (shortestPaths.get(i) + values[i]) <= 0) {
                    System.out.print(i + " ");
                }
            }
        }

    }
}
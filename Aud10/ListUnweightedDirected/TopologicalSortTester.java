package Aud10.ListUnweightedDirected;

public class TopologicalSortTester {

    public static void main(String[] args) {


        AdjacencyListGraph<Integer> g = new AdjacencyListGraph<>();


        //adding edges
        g.addEdge(0, 1);
        g.addEdge(0, 7);
        g.addEdge(1, 7);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 5);
        g.addEdge(2, 8);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 7);
        g.addEdge(6, 8);
        g.addEdge(10, 0);

        System.out.println(g.topologicalSort());


    }

}

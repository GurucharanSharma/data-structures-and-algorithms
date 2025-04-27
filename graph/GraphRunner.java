package graph;

import graph.common.Graph.AdjacencyList;

public class GraphRunner {

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(5);

        adjacencyList.addEdge(1, 2);
        adjacencyList.addEdge(1, 3);
        adjacencyList.addEdge(3, 2);
        adjacencyList.addEdge(4, 5);

        adjacencyList.printGraph();
    }
}

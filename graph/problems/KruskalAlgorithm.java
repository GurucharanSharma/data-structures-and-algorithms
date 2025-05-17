package graph.problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KruskalAlgorithm {

    public static void main(String[] args) {
        List<List<int[]>> adj = List.of(
            List.of(new int[]{1, 5}, new int[]{2, 1}),
            List.of(new int[]{2, 3})
        );
        int V = 3;
        int E = adj.size();

        System.out.println(Solution.spanningTree(V, E, adj));
    }
}

class Solution {

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        int result = 0;
        DisjointSet disjointSet = new DisjointSet(V);
        PriorityQueue<Edge> pQueue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));

        for (int i = 0; i < E; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int[] edge = adj.get(i).get(j);
                pQueue.add(new Edge(i, edge[0], edge[1]));
                pQueue.add(new Edge(edge[0], i, edge[1]));
            }
        }

        while (!pQueue.isEmpty()) {
            Edge edge = pQueue.remove();

            if (disjointSet.findUltParent(edge.src) != disjointSet.findUltParent(edge.dst)) {
                result += edge.weight;
                disjointSet.unionBySize(edge.src, edge.dst);
            }
        }

        return result;
    }

    private static class Edge {

        int src;
        int dst;
        int weight;

        Edge(int _src, int _dst, int _weight) {
            this.src = _src;
            this.dst = _dst;
            this.weight = _weight;
        }
    }

    private static class DisjointSet {

        Map<Integer, Integer> parents = new HashMap<>();
        Map<Integer, Integer> sizes = new HashMap<>();

        DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                parents.put(i, i);
                sizes.put(i, 0);
            }
        }

        public int findUltParent(int node) {
            if (parents.get(node) == node) {
                return node;
            }

            int uParent = findUltParent(parents.get(node));
            parents.put(node, uParent);

            return uParent;
        }

        public void unionBySize(int u, int v) {
            int uParent = findUltParent(u);
            int vParent = findUltParent(v);

            if (uParent == vParent) {
                return;
            }

            if (sizes.get(uParent) < sizes.get(vParent)) {
                parents.put(uParent, vParent);
                sizes.put(vParent, sizes.get(uParent) + sizes.get(vParent));
            } else {
                parents.put(vParent, uParent);
                sizes.put(uParent, sizes.get(uParent) + sizes.get(vParent));
            }
        }
    }
}

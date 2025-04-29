package graph.problems;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet(7);
        disjointSet.unionByRank(1, 2);
        disjointSet.unionByRank(2, 3);
        disjointSet.unionByRank(4, 5);
        disjointSet.unionByRank(6, 7);
        disjointSet.unionByRank(5, 6);

        if (disjointSet.findUltimateParent(3) == disjointSet.findUltimateParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        disjointSet.unionByRank(3, 7);

        if (disjointSet.findUltimateParent(3) == disjointSet.findUltimateParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }

    Map<Integer, Integer> ranks = new HashMap<>();
    Map<Integer, Integer> parents = new HashMap<>();

    DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            ranks.put(i, 0);
            parents.put(i, i);
        }
    }

    private int findUltimateParent(int node) {
        if (parents.get(node) == node) {
            return node;
        }

        int uParent = findUltimateParent(parents.get(node));
        parents.put(node, uParent);

        return uParent;
    }

    private void unionByRank(int u, int v) {
        int uParentU = findUltimateParent(u);
        int uParentV = findUltimateParent(v);

        if (uParentU == uParentV) {
            return;
        }

        if (ranks.get(uParentU) < ranks.get(uParentV)) {
            parents.put(uParentU, uParentV);
        } else if (ranks.get(uParentU) > ranks.get(uParentV)) {
            parents.put(uParentV, uParentU);
        } else {
            parents.put(uParentV, uParentU);
            ranks.put(uParentU, ranks.get(uParentU) + 1);
        }
    }
}

package tree.binarytree.problems;

import java.util.HashMap;
import java.util.Map;
import tree.BinaryTree.Node;
import tree.TreeFormatter;

public class ConstructBinaryTreeFromParentArray {

  private static final TreeFormatter formatter = new TreeFormatter();
  private static Node root = null;

  public static void main(String[] args) {
    int[] parent = {-1, 0, 0, 1, 1, 3, 5};
//    int[] parent = {2, 0, -1};

    root = createTree(parent);
    formatter.topDown(root);

    root = createTree1(parent);
    formatter.topDown(root);

    root = createTree2(parent);
    formatter.topDown(root);
  }

  // Approach 1: Recursive approach
  private static Node createTree(int[] parent) {
    Node[] created = new Node[parent.length];

    for (int i = 0; i < created.length; i++) {
      createTree(parent, i, created);
    }

    return root;
  }

  private static void createTree(int[] parent, int i, Node[] created) {
    if (created[i] != null) {
      return;
    }

    created[i] = new Node(i);

    if (parent[i] == -1) {
      root = created[i];
      return;
    }

    if (created[parent[i]] == null) {
      createTree(parent, parent[i], created);
    }

    Node p = created[parent[i]];
    if (p.left == null) {
      p.left = created[i];
    } else {
      p.right = created[i];
    }
  }

  // Approach 2: Iterative approach
  private static Node createTree1(int[] parent) {
    Node[] created = new Node[parent.length];
    for (int i = 0; i < created.length; i++) {
      created[i] = new Node(i);
    }

    Node root = null;
    for (int i = 0; i < parent.length; i++) {
      if (parent[i] == -1) {
        root = created[i];
      } else {
        Node p = created[parent[i]];
        if (p.left == null) {
          p.left = created[i];
        } else {
          p.right = created[i];
        }
      }
    }

    return root;
  }

  // Approach 3: Using dictionary/hashmap
  private static Node createTree2(int[] parent) {
    Map<Integer, Node> nodeLookup = new HashMap<>();
    for (int i = 0; i < parent.length; i++) {
      nodeLookup.put(i, new Node(i));
    }

    Node root = null;
    for (int i = 0; i < parent.length; i++) {
      if (parent[i] == -1) {
        root = nodeLookup.get(i);
      } else {
        Node parentNode = nodeLookup.get(parent[i]);
        Node currNode = nodeLookup.get(i);

        if (parentNode.left == null) {
          parentNode.left = currNode;
        } else {
          parentNode.right = currNode;
        }
      }
    }

    return root;
  }
}

package tree.binarytree.lectures;

import java.util.ArrayList;
import tree.BinaryTree.Node;

public class DeserializeBinaryTree {

  private static int index = 0;

  public static Node execute(ArrayList<Integer> arr) {
    if (index > arr.size()) {
      return null;
    }

    int val = arr.get(index++);
    if (val == -1) {
      return null;
    }

    Node node = new Node(val);
    node.left = execute(arr);
    node.right = execute(arr);

    return node;
  }
}

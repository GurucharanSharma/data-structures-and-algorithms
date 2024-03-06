package tree.binarytree.lectures;

import java.util.ArrayList;
import tree.binarytree.BinaryTree.Node;

public class SerializeBinaryTree {

  public static void execute(Node root, ArrayList<Integer> arr) {
    if (root == null) {
      arr.add(-1);
      return;
    }

    arr.add(root.key);
    execute(root.left, arr);
    execute(root.right, arr);
  }
}

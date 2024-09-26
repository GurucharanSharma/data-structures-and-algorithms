package hashing.lectures;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Time Complexity:
 * <ul>
 * <li>Search : O(1+(n/m))</li>
 * <li>Delete : O(1+(n/m))</li>
 * (where n = Total elements in hash table; m = Size of hash table)
 * <li>Here n/m is the Load Factor.</li>
 * <li>Load Factor (∝) must be as small as possible.</li>
 * <li>If load factor increases,then possibility of collision increases.</li>
 * <li>Load factor is trade of space and time .</li>
 * <li>Assume , uniform distribution of keys ,</li>
 * <ul>
 * <li>Expected chain length : O(∝)</li>
 * <li>Expected time to search : O( 1 + ∝ )</li>
 * <li>Expected time to insert/ delete :  O( 1 + ∝ )</li>
 * </ul>
 * </ul>
 * Auxiliary Space: O(1), since no extra space has been taken.
 */
public class StaticChaining {

  private final int bucket;
  private final ArrayList<LinkedList<Integer>> table;

  StaticChaining(int bucket) {
    this.bucket = bucket;
    this.table = new ArrayList<>();

    for (int i = 0; i < bucket; i++) {
      table.add(new LinkedList<>());
    }
  }

  public int hash(int key) {
    return key % bucket;
  }

  public void insert(int key) {
    int index = hash(key);
    table.get(index).add(key);
  }

  public boolean search(int key) {
    int index = hash(key);
    LinkedList<Integer> linkedList = table.get(index);
    return linkedList.contains(key);
  }

  public boolean delete(int key) {
    int index = hash(key);
    LinkedList<Integer> linkedList = table.get(index);

    int keyIndex = -1;
    for (int i = 0; i < linkedList.size(); i++) {
      if (linkedList.get(i) == key) {
        keyIndex = i;
        break;
      }
    }

    if (keyIndex >= 0) {
      linkedList.remove(keyIndex);
      return true;
    } else {
      return false;
    }
  }

  public void printList() {
    for (LinkedList<Integer> list : table) {
      System.out.println(list);
    }
  }
}

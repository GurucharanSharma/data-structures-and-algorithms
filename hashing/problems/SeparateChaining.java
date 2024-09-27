package hashing.problems;

import java.util.ArrayList;

public class SeparateChaining {

  public static void main(String[] args) {
//    int[] arr = {92, 4, 14, 24, 44, 91};
//    int hashSize = 10;

    int[] arr = {12, 45, 36, 87, 11};
    int hashSize = 10;

    System.out.println(separateChaining(arr, arr.length, hashSize));
  }

  //Function to insert elements of array in the hashTable avoiding collisions.
  private static ArrayList<ArrayList<Integer>> separateChaining(int[] arr, int n, int hashSize) {
    ArrayList<ArrayList<Integer>> hashTable = new ArrayList<>();
    for (int i = 0; i < hashSize; i++) {
      hashTable.add(i, new ArrayList<>());
    }

    for (int i = 0; i < n; i++) {
      int hash = arr[i] % hashSize;
      hashTable.get(hash).add(arr[i]);
    }

    return hashTable;
  }
}

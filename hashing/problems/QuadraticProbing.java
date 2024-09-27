package hashing.problems;

import java.util.Arrays;

public class QuadraticProbing {

  public static void main(String[] args) {
//    int[] arr = {21, 10, 32, 43};
//    int hashSize = 11;

//    int[] arr = {880, 995, 647, 172};
//    int hashSize = 11;

    int[] arr = {4, 4, 4, 4};
    int hashSize = 11;

    int[] hash = new int[hashSize];
    quadraticProbing(hash, hashSize, arr, arr.length);
    System.out.println(Arrays.toString(hash));
  }

  //Function to fill the array elements into a hash table
  //using Quadratic Probing to handle collisions.
  private static void quadraticProbing(int[] hash, int hash_size, int[] arr, int N) {
    Arrays.fill(hash, -1);

    for (int i = 0; i < N; i++) {
      int hIndex = arr[i] % hash_size;
      for (int j = 1; j <= hash_size; j++) {
        if (hash[hIndex] == -1 || hash[hIndex] == arr[i]) {
          hash[hIndex] = arr[i];
          break;
        }

        hIndex = (arr[i] + j * j) % hash_size;
      }
    }
  }
}

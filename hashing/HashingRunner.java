package hashing;

import java.util.Arrays;

/**
 * Practice Session
 */
public class HashingRunner {

  public static void main(String[] args) {
    int[] arr = {880, 995, 647, 172};
    int hashSize = 11;

    int[] hash = new int[hashSize];
    quadraticProbing(hash, hashSize, arr, arr.length);
    System.out.println(Arrays.toString(hash));
  }

  //Function to fill the array elements into a hash table
  //using Quadratic Probing to handle collisions.
  static void quadraticProbing(int[] hash, int hash_size, int[] arr, int N) {
    Arrays.fill(hash, -1);

    for (int i = 0; i < N; i++) {
      int index = arr[i] % hash_size;
      if (hash[index] == -1 || hash[index] == arr[i]) {
        hash[index] = arr[i];
      } else {
        for (int j = 1; j < hash_size; j++) {
          index = ((arr[i] % hash_size) + j * j) % hash_size;
          if (hash[index] == -1 || hash[index] == arr[i]) {
            hash[index] = arr[i];
            break;
          }
        }
      }
    }
  }
}

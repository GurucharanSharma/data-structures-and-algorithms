package interviews.wayfair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EncryptedFiles {

  public static void main(String[] args) {
    Result result = new Result();

    List<Integer> encryptedFiles = List.of(7, 4, 3, 5);
    List<Integer> binary = List.of(1, 0, 0, 0);
    int k = 2;

    System.out.println(result.getMaxValueSum(encryptedFiles, binary, k));
  }

  static class Result {

    /*
     * Complete the 'getMaxValueSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY encrypted_file
     *  2. INTEGER_ARRAY binary
     *  3. INTEGER k
     */
    public int getMaxValueSum(List<Integer> encrypted_file, List<Integer> binary, int k) {
      int initialSum = 0;
      List<Integer> decryptableFiles = new ArrayList<>();

      // Calculate initial decrypted sum and collect decryptable files.
      for (int i = 0; i < encrypted_file.size(); i++) {
        if (binary.get(i) == 1) {
          initialSum += encrypted_file.get(i);
        } else {
          decryptableFiles.add(encrypted_file.get(i));
        }
      }

      // Sort the decryptable files in descending order.
      decryptableFiles.sort(Collections.reverseOrder());

      // Add the top k values to the initial sum.
      for (int i = 0; i < Math.min(k, decryptableFiles.size()); i++) {
        initialSum += decryptableFiles.get(i);
      }

      return initialSum;
    }
  }
}

package recursion.lectures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintPermutations {

  public static void main(String[] args) {
    String str = "ABC";

    permute(str, 0);
    System.out.println();
    permute(str);
    System.out.println();
    permute1(str);
  }

  // Approach 1: Iterative approach (Steinhaus–Johnson–Trotter algorithm)
  private static void permute(String str) {
    char[] chars = str.toCharArray();
    Arrays.sort(chars); // Start with the lexicographically smallest permutation

    // Print the first permutation
    // Generate the next permutation until no more permutations are left
    do {
      System.out.print(String.valueOf(chars) + " ");
    } while (nextPermutation(chars));
  }

  // Method to generate the next lexicographical permutation
  private static boolean nextPermutation(char[] chars) {
    // Step 1: Find the largest index 'i' such that chars[i] < chars[i + 1]
    int i = chars.length - 2;
    while (i >= 0 && chars[i] >= chars[i + 1]) {
      i--;
    }

    // If no such index 'i' exists, the permutation is the last one
    if (i < 0) {
      return false;
    }

    // Step 2: Find the largest index 'j' greater than 'i' such that chars[j] > chars[i]
    int j = chars.length - 1;
    while (chars[j] <= chars[i]) {
      j--;
    }

    // Step 3: Swap chars[i] and chars[j]
    swap(chars, i, j);

    // Step 4: Reverse the sequence from chars[i + 1] to the end of the array
    reverse(chars, i + 1);

    return true; // There are more permutations to generate
  }

  // Helper method to reverse the array from index start to the end
  private static void reverse(char[] chars, int start) {
    int end = chars.length - 1;
    while (start < end) {
      swap(chars, start, end);
      start++;
      end--;
    }
  }

  // Helper method to swap characters at indices i and j
  private static void swap(char[] chars, int i, int j) {
    char temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;
  }

  // Approach 2: Recursive approach
  private static void permute(String str, int i) {
    if (i == str.length() - 1) {
      System.out.print(str + " ");
      return;
    }

    for (int j = i; j < str.length(); j++) {
      permute(swapAndReturn(str, i, j), i + 1);
    }
  }

  private static String swapAndReturn(String a, int i, int j) {
    // converting string to array
    char temp;
    char[] charArray = a.toCharArray();

    // swapping
    temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;

    // converting back to string
    return String.valueOf(charArray);
  }

  // Approach 3: Recursive Approach
  private static void permute1(String str) {
    boolean[] freq = new boolean[str.length()];
    generatePermutations(str, new ArrayList<>(), freq);
  }

  private static void generatePermutations(String str, List<Character> list, boolean[] freq) {
    if (list.size() == str.length()) {
      System.out.print(list + " ");
      return;
    }

    for (int i = 0; i < str.length(); i++) {
      if (!freq[i]) {
        freq[i] = true;
        list.add(str.charAt(i));
        generatePermutations(str, list, freq);
        list.remove(list.size() - 1);
        freq[i] = false;
      }
    }
  }
}

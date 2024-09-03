package array.problems;

public class MaximumOccurredInteger {

  public static void main(String[] args) {
    int n = 4;
    int[] l = {1, 4, 3, 1};
    int[] r = {15, 8, 5, 4};
    int maxx = 15;

    System.out.println(maxOccured(n, l, r, maxx));
  }

  // Function to find the maximum occurred integer in all ranges.
  public static int maxOccured(int n, int[] l, int[] r, int maxx) {
    int[] freq = new int[maxx + 2];

    for (int i = 0; i < n; i++) {
      freq[l[i]] += 1;
      freq[r[i] + 1] += -1;
    }

    int maxOccurred = freq[0];
    int index = 0;
    for (int i = 1; i < maxx + 2; i++) {
      freq[i] = Math.max(freq[i] + freq[i - 1], 0);
      if (freq[i] > maxOccurred) {
        index = i;
        maxOccurred = freq[i];
      }
    }

    return index;
  }
}

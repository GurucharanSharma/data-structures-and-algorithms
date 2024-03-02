package searching.problems;

public class CountMoreThanNByKOccurrences {

  public static void main(String[] args) {
    int[] arr = {2,3,3,2};
    System.out.println(countOccurence(arr, arr.length, 4));
  }

  //Function to find all elements in array that appear more than n/k times.
  private static int countOccurence(int[] arr, int n, int k) {
    int max = 1000000;
    int[] hash = new int[max + 1];

    for (int j : arr) {
      hash[j]++;
    }

    int count = 0;
    for (int j : hash) {
      if (j > n / k) {
        count++;
      }
    }

    return count;
  }
}

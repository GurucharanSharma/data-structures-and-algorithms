package array.lectures;

public class MinimumGroupFlipsToMakeSame {

  public static void main(String[] args) {
    int[] array = new int[]{0, 0, 0, 0, 0, 1, 1};
    System.out.println(getMinimumGroupFlips(array)); // This method flips the bits as well.
    System.out.println();

    System.out.println(getMinimumGroupFlips1(array));
    System.out.println();

    System.out.println(getMinimumGroupFlips2(array));
  }

  /**
   * An Efficient Solution is based on the below facts :
   * <ul>
   * <li>There are only two types of groups (groups of 0s and groups of 1s).</li>
   * <li>Either the counts of both groups are same or the difference between counts
   * is at most 1. For example, in {1, 1, 0, 1, 0, 0} there are two groups of 0s and two groups of 1s.  In example, {1, 1, 0, 0, 0, 1, 0, 0, 1, 1},
   * count of groups of 1 is one more than the counts of 0s.</li>
   * </ul>
   * <p>
   * Time Complexity:  O(n) <br>
   * Auxiliary Space:  O(1)
   * </p>
   */
  static int getMinimumGroupFlips(int[] array) {
    int first = array[0];
    int groupFlipCount = 0;

    // We are always checking the first group because if the array ends in first group elements, then the second group flips
    // would be minimum. If the array ends with the second group elements they would be same in worst case. In either case,
    // flipping the second group gives the minimum number of flips.
    for (int i = 1; i < array.length; i++) {
      boolean isFlipped = false;
      while (i < array.length && array[i] != first) {
        isFlipped = true;
        System.out.print(i + " ");
        array[i] = array[i] == 0 ? 1 : 0;
        i++;
      }

      if (isFlipped) {
        groupFlipCount++;
        System.out.println();
      }
    }

    return groupFlipCount;
  }

  static int getMinimumGroupFlips1(int[] arr) {
    int first = arr[0];
    int flips = 0;
    int start;

    for (int i = 0; i < arr.length; i++) {
      while (i < arr.length && arr[i] == first) {
        i++;
      }

      if (i == arr.length) {
        return 0;
      }

      flips++;

      start = i;
      while (i < arr.length && arr[i] != first) {
        i++;
      }

      System.out.println("From " + start + " to " + (i - 1));
    }

    return flips;
  }

  static int getMinimumGroupFlips2(int[] arr) {
    int n = arr.length;
    int start = arr[0];
    int flips = 0;

    for (int i = 0; i < n; i++) {
      if (arr[i] != start) {
        flips++;
        int low = i;
        while (i < n && arr[i] != start) {
          i++;
        }

        System.out.println("From " + low + " to " + (i - 1));
      }
    }

    return flips;
  }
}

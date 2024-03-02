package sorting.lectures;

import java.util.Arrays;

public class MeetingTheMaximumGuests {

  /**
   * <strong>Problem:</strong> Consider a big party where a log register for guest's entry and exit times is maintained. Find the time at which there
   * are maximum guests in the party. Note that entries in register are not in any order.
   *
   * @param args
   */
  public static void main(String[] args) {
    testMaxGuests1();
    testMaxGuests2();
    testMaxGuests3();
    testMaxGuests4();
  }

  private static int maxGuests(int[] arr, int[] dep) {
    int i = 0;
    int j = 0;
    int guests = 0;
    int count = 0;

    Arrays.sort(arr);
    Arrays.sort(dep);

    while (i < arr.length && j < dep.length) {
      if (arr[i] <= dep[j]) {
        i++;
        guests++;
      } else {
        j++;
        guests--;
      }

      count = Math.max(count, guests);
    }

    return count;
  }

  private static void testMaxGuests1() {
    int[] arr = {900, 600, 700};
    int[] dep = {1000, 800, 730};
    System.out.println(maxGuests(arr, dep));
  }

  private static void testMaxGuests2() {
    int[] arr = {900, 940};
    int[] dep = {1000, 1030};
    System.out.println(maxGuests(arr, dep));
  }

  private static void testMaxGuests3() {
    int[] arr = {800, 700, 600, 500};
    int[] dep = {840, 820, 830, 530};
    System.out.println(maxGuests(arr, dep));
  }

  private static void testMaxGuests4() {
    int[] arr = {900, 940, 950, 1100, 1500, 1800};
    int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
    System.out.println(maxGuests(arr, dep));
  }

}

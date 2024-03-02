package sorting.problems;

public class CountingSort {

  public static void main(String[] args) {
    testCountSort1();
    testCountSort2();
  }

  //Function to arrange all letters of a string in lexicographical
  //order using Counting Sort.
  private static String countSort(String arr) {
    // code here
    char[] charArray = arr.toCharArray();

    int[] count = new int[26];
    for (char c : charArray) {
      count[c - 97]++;
    }

    for (int i = 1; i < count.length; i++) {
      count[i] = count[i] + count[i - 1];
    }

    char[] output = new char[charArray.length];
    for (char c : charArray) {
      output[count[c - 97] - 1] = c;
      count[c - 97]--;
    }

    System.arraycopy(output, 0, charArray, 0, output.length);
    return String.valueOf(charArray);
  }

  private static void testCountSort1() {
    String str = "edsab";
    System.out.println(countSort(str));
  }

  private static void testCountSort2() {
    String str = "geeksfzorgeeks";
    System.out.println(countSort(str));
  }
}

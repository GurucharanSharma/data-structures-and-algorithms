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

  //Function to arrange all letters of a string in lexicographical
  //order using Counting Sort.
  public static String countSort1(String arr) {
    int[] freq = new int[26];

    for (int i = 0; i < arr.length(); i++) {
      freq[arr.charAt(i) - 'a']++;
    }

    for (int i = 1; i < freq.length; i++) {
      freq[i] = freq[i] + freq[i - 1];
    }

    char[] output = new char[arr.length()];

    for (int i = arr.length() - 1; i >= 0; i--) {
      output[freq[arr.charAt(i) - 'a'] - 1] = arr.charAt(i);
      freq[arr.charAt(i) - 'a']--;
    }

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < output.length; i++) {
      builder.append(output[i]);
    }

    // System.out.println(Arrays.toString(output));
    return builder.toString();
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

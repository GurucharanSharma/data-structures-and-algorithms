package strings.problems;

public class BinaryString {

  public static void main(String[] args) {
//    String str = "00100101";
    String str = "1111";
//    String str = "01101";

    System.out.println(binarySubstring(str.length(), str));
    System.out.println();
    System.out.println(binarySubstring1(str.length(), str));
  }

  // Function to count the number of substrings that start and end with 1.
  // Naive approach: Counting all the possible combinations
  // Time Complexity: O(n^2)
  public static int binarySubstring(int a, String str) {
    int result = 0;
    for (int i = 0; i < a; i++) {
      if (str.charAt(i) == '1') {
        for (int j = i + 1; j < a; j++) {
          if (str.charAt(j) == '1') {
            result++;
          }
        }
      }
    }

    return result;
  }

  // Efficient approach: Using formulae
  // Time Complexity: O(n)
  public static int binarySubstring1(int a, String str) {
    int count = 0;
    for (int i = 0; i < a; i++) {
      if (str.charAt(i) == '1') {
        count++;
      }
    }

    return count * (count - 1) / 2;
  }
}

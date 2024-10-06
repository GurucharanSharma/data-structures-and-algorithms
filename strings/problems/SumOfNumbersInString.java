package strings.problems;

public class SumOfNumbersInString {

  public static void main(String[] args) {
//    String str = "1abc23";
//    String str = "geeks4geeks";
    String str = "sdfsdfsdf";
//    String str = "1234";

    System.out.println(findSum(str));
    System.out.println();
    System.out.println(findSum1(str));
    System.out.println();
    System.out.println(findSum2(str, 0, str.length()));
  }

  //Function to calculate sum of all numbers present in a string.
  public static long findSum(String str) {
    int result = 0;
    for (int i = 0; i < str.length(); i++) {
      int start = -1;
      if (Character.isDigit(str.charAt(i))) {
        start = i;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
          i++;
        }
      }

      if (start != -1) {
        result += Integer.parseInt(str.substring(start, i));
      }
    }

    return result;
  }

  //Function to calculate sum of all numbers present in a string.
  public static long findSum1(String str) {
    StringBuilder temp = new StringBuilder("0");
    int sum = 0;

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (Character.isDigit(ch)) {
        temp.append(ch);
      } else {
        sum += Integer.parseInt(temp.toString());
        temp = new StringBuilder("0");
      }
    }

    return sum + Integer.parseInt(temp.toString());
  }

  // Using recursion
  public static long findSum2(String str, int i, int n) {
    if (i >= n) {
      return 0;
    }

    if (i == n - 1) {
      if (Character.isDigit(str.charAt(i))) {
        return str.charAt(i) - '0';
      } else {
        return 0;
      }
    }

    if (Character.isDigit(str.charAt(i))) {
      StringBuilder builder = new StringBuilder("0");
      int j = i;

      while (j < n) {
        if (Character.isDigit(str.charAt(j))) {
          builder.append(str.charAt(j));
        } else {
          break;
        }

        j++;
      }

      return Integer.parseInt(builder.toString()) + findSum2(str, j, n);
    } else {
      return findSum2(str, i + 1, n);
    }
  }
}


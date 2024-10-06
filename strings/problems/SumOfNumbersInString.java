package strings.problems;

public class SumOfNumbersInString {

  public static void main(String[] args) {
//    String str = "1abc23";
//    String str = "geeks4geeks";
//    String str = "sdfsdfsdf";
    String str = "1234";

    System.out.println(findSum(str));
    System.out.println();
    System.out.println(findSum1(str));
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
}


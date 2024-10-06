package strings.problems;

public class ReverseWords {

  public static void main(String[] args) {
//    String str = "i.like.this.program.very.much";
    String str = "pqr.mno";

    System.out.println(reverseWords(str));
  }

  // Function to reverse words in a given string.
  private static String reverseWords(String str) {
    int start = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '.') {
        str = reverse(str, start, i - 1);
        start = i + 1;
      }
    }

    str = reverse(str, start, str.length() - 1);
    str = reverse(str, 0, str.length() - 1);

    return str;
  }

  private static String reverse(String input, int start, int end) {
    char[] inputArr = input.toCharArray();

    while (start < end) {
      char temp = inputArr[start];
      inputArr[start] = inputArr[end];
      inputArr[end] = temp;

      start++;
      end--;
    }

    return String.valueOf(inputArr);
  }

}

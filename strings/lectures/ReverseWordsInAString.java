package strings.lectures;

public class ReverseWordsInAString {

  // Approach 1: using character array representation of the string
  private static String reverseWords(String str) {
    int start = 0;
    char[] strArr = str.toCharArray();

    for (int end = 0; end < strArr.length; end++) {
      if (strArr[end] == ' ') {
        reverse(strArr, start, end - 1);
        start = end + 1;
      }
    }

    reverse(strArr, start, strArr.length - 1);
    reverse(strArr, 0, strArr.length - 1);

    return new String(strArr);
  }

  private static void reverse(char[] str, int start, int end) {
    while (start <= end) {
      swap(str, start, end);
      start++;
      end--;
    }
  }

  // Approach 2: Using strings
  private static String reverseWords1(String input) {
    int start = 0;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == ' ') {
        input = reverse(input, start, i - 1);
        start = i + 1;
      }
    }

    input = reverse(input, start, input.length() - 1);
    input = reverse(input, 0, input.length() - 1);

    return input;
  }

  private static String reverse(String input, int start, int end) {
    char[] charArray = input.toCharArray();

    while (start < end) {
      char temp = charArray[start];
      charArray[start] = charArray[end];
      charArray[end] = temp;

      start++;
      end--;
    }

    return String.valueOf(charArray);
  }

  private static void swap(char[] str, int start, int end) {
    char temp = str[start];
    str[start] = str[end];
    str[end] = temp;
  }

  public static void main(String[] args) {
    testReverseWords();
    testReverseWords1();
  }

  private static void testReverseWords() {
    String str = "Welcome to GFG";
    System.out.println(reverseWords(str));
    System.out.println();
    System.out.println(reverseWords1(str));
  }

  private static void testReverseWords1() {
    String str = "Hi! How are you?";
    System.out.println(reverseWords(str));
    System.out.println();
    System.out.println(reverseWords1(str));
  }
}

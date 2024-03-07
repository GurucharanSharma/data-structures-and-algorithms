package strings.lectures;

public class ReverseWordsInAString {

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
  }

  private static void testReverseWords1() {
    String str = "Hi! How are you?";
    System.out.println(reverseWords(str));
  }
}

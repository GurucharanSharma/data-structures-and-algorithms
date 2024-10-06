package strings.problems;

public class ModifiedString {

  public static void main(String[] args) {
    String S = "aabbbcc";
//    String S = "aaaaa";

    System.out.println(modified(S));
    System.out.println();
    System.out.println(modified1(S));
  }

  //Function to find minimum number of characters which Ishaan must insert
  //such that string doesn't have three consecutive same characters.
  public static long modified(String a) {
    int i = 1;
    int count = 1;
    long result = 0;
    while (i < a.length()) {
      if (a.charAt(i) == a.charAt(i - 1)) {
        count++;
      } else {
        count = 1;
      }

      if (count == 3) {
        result++;
        count = 0;
      } else {
        i++;
      }
    }

    return result;
  }

  //Function to find minimum number of characters which Ishaan must insert
  //such that string doesn't have three consecutive same characters.
  public static long modified1(String a) {
    int i = 0;
    int count = 0;
    long result = 0;
    while (i < a.length() - 1) {
      if (a.charAt(i) == a.charAt(i + 1)) {
        count++;
      } else {
        count = 1;
      }

      if (count == 3) {
        result++;
        count = 1;
      } else {
        i++;
      }
    }

    return result;
  }
}

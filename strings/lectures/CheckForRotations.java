package strings.lectures;

public class CheckForRotations {

  public static void main(String[] args) {
//    String input = "ABCD";
//    String pattern = "CDAB";

//    String input = "ABAAA";
//    String pattern = "BAAAA";

    String input = "ABAB";
    String pattern = "ABBA";

    System.out.println(isRotation(input, pattern));
  }

  private static boolean isRotation(String input, String pattern) {
    return (input + input).contains(pattern);
  }
}

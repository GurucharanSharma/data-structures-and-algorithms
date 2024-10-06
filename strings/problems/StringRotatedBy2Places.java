package strings.problems;

public class StringRotatedBy2Places {

  public static void main(String[] args) {
    String a = "amazon";
//    String b = "azonam";
    String b = "onamaz";

//    String a = "geeksforgeeks";
//    String b = "geeksgeeksfor";

    System.out.println(isRotated(a, b));
  }

  //Function to check if a string can be obtained by rotating
  //another string by exactly 2 places.
  public static boolean isRotated(String str1, String str2) {
    if (str1.length() < 2) {
      return false;
    }

    return (str1.substring(2) + str1.substring(0, 2)).matches(str2) ||
        (str1.substring(str1.length() - 2) + str1.substring(0, str1.length() - 2)).matches(str2);
  }
}

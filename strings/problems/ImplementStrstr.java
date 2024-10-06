package strings.problems;

public class ImplementStrstr {

  public static void main(String[] args) {
//    String s = "GeeksForGeeks";
//    String x = "Fr";

//    String s = "GeeksForGeeks";
//    String x = "For";

    String s = "VKQjmhXrsWOHmJrBtjyPFPkVFsnhlVpV";
    String x = "VViF";

    System.out.println(strstr(s, x));
  }

  //Function to locate the occurrence of the string x in the string s.
  private static int strstr(String s, String x) {
    int i = 0;
    while (i <= (s.length() - x.length())) {
      boolean matches = true;
      int j = 0;
      while (j < x.length()) {
        if (s.charAt(i + j) != x.charAt(j)) {
          matches = false;
          break;
        }

        j++;
      }

      if (matches) {
        return i;
      }

      if (j == 0) {
        i++;
      } else {
        i = i + j;
      }
    }

    return -1;
  }
}

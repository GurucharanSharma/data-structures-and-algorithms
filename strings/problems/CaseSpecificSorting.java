package strings.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CaseSpecificSorting {

  public static void main(String[] args) {
//    String str = "defRTSersUXI";
    String str = "srbDKi";

    System.out.println(caseSort(str));
  }

  //Function to perform case-specific sorting of strings.
  public static String caseSort(String str) {
    List<Character> lower = new ArrayList<>();
    List<Character> upper = new ArrayList<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (Character.isUpperCase(ch)) {
        upper.add(ch);
      } else if (Character.isLowerCase(ch)) {
        lower.add(ch);
      }
    }

    Collections.sort(lower);
    Collections.sort(upper);

    StringBuilder builder = new StringBuilder();

    int l = 0;
    int u = 0;
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (Character.isLowerCase(ch)) {
        builder.append(lower.get(l++));
      } else if (Character.isUpperCase(ch)) {
        builder.append(upper.get(u++));
      } else {
        builder.append(ch);
      }
    }

    return builder.toString();
  }
}

package strings.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CaseSpecificSorting {

  public static void main(String[] args) {
//    String str = "defRTSersUXI";
    String str = "srbDKi";

    System.out.println(caseSort(str));
    System.out.println();
    System.out.println(caseSort1(str));
  }

  // Function to perform case-specific sorting of strings.
  // Using List
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

  // Function to perform case-specific sorting of strings.
  // Using arrays
  public static String caseSort1(String str) {
    int[] lower = new int[26];
    int[] upper = new int[26];

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (Character.isLowerCase(ch)) {
        lower[ch - 'a']++;
      } else if (Character.isUpperCase(ch)) {
        upper[ch - 'A']++;
      }
    }

    int l = 0;
    int u = 0;
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (Character.isLowerCase(ch)) {
        if (l < 26 && lower[l] > 0) {
          builder.append((char) (l + 'a'));
          lower[l]--;
        } else {
          while (l < 26 && lower[l] == 0) {
            l++;
          }

          if (l < 26) {
            builder.append((char) (l + 'a'));
            lower[l]--;
          }
        }
      } else if (Character.isUpperCase(ch)) {
        if (u < 26 && upper[u] > 0) {
          builder.append((char) (u + 'A'));
          upper[u]--;
        } else {
          while (u < 26 && upper[u] == 0) {
            u++;
          }

          if (u < 26) {
            builder.append((char) (u + 'A'));
            upper[u]--;
          }
        }
      } else {
        builder.append(ch);
      }
    }

    return builder.toString();
  }
}

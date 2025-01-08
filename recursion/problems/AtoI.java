package recursion.problems;

public class AtoI {

  public static void main(String[] args) {
    //    String str = "42";
//    String str = " -042";
//    String str = "1337c0d3";
//    String str = "0-1";
//    String str = "words and 987";
//    String str = "-91283472332";
    String str = "-2147483647";

    System.out.println(atoi(str));
    System.out.println();
    System.out.println(atoi1(str));
  }

  // Recursive Approach
  public static int atoi(String str) {
    str = str.trim();
    if (str.charAt(0) == '-') {
      return -1 * myAtoI(str.replaceFirst("-", ""), 0, 0, true);
    } else if (str.charAt(0) == '+') {
      return myAtoI(str.replaceFirst("\\+", ""), 0, 0, false);
    } else {
      return myAtoI(str, 0, 0, false);
    }
  }

  private static int myAtoI(String str, int i, int num, boolean negative) {
    if (i == str.length() || !Character.isDigit(str.charAt(i))) {
      return num;
    }

    int digit = Integer.parseInt(String.valueOf(str.charAt(i)));
    if (negative) {
      if (-num < (Integer.MIN_VALUE + digit) / 10) {
        return Integer.MIN_VALUE;
      }
    } else {
      if (num > (Integer.MAX_VALUE - digit) / 10) {
        return Integer.MAX_VALUE;
      }
    }

    num = num * 10 + digit;
    return myAtoI(str, i + 1, num, negative);
  }

  // Iterative Approach
  public static int atoi1(String s) {
    int n = s.length();
    int res = 0, sign = 1;
    boolean flag = false, breach = false;

    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);

      if (!Character.isDigit(ch)) {
        if (!flag && (ch == ' ' || ch == '0')) {
          continue;
        }

        if (ch == '-' || ch == '+') {
          if (!flag) {
            if (ch == '-') {
              sign = -sign;
            }

            flag = true;
          } else {
            break;
          }
        } else {
          break;
        }
      } else {
        flag = true;
        if (res > (Integer.MAX_VALUE - (ch - '0')) / 10) {
          res = Integer.MAX_VALUE;
          breach = true;
        } else {
          res = (10 * res) + (ch - '0');
        }
      }
    }

    if (breach && sign == -1) {
      return Integer.MIN_VALUE;
    } else {
      return sign * res;
    }
  }
}

package strings.problems;

public class StringCompression {

  public static void main(String[] args) {
//    char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
//    char[] chars = {'a'};
    char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};

    Solution solution = new Solution();
    int size = solution.compress(chars);
    System.out.println(size);
    for (int i = 0; i < size; i++) {
      System.out.print(chars[i]);
    }
    System.out.println();
  }

  static class Solution {

    public int compress(char[] chars) {
      int index = 0;

      for (int i = 0; i < chars.length; i++) {
        int count = 1;
        while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
          count++;
          i++;
        }

        chars[index] = chars[i];
        if (count > 1) {
          if (count >= 10) {
            String cntStr = String.valueOf(count);
            for (int j = 0; j < cntStr.length(); j++) {
              chars[++index] = cntStr.charAt(j);
            }
          } else {
            chars[++index] = (char) (count + '0');
          }
        }

        index += 1;
      }

      return index;
    }
  }
}

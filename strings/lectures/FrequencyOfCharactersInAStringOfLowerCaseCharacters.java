package strings.lectures;

public class FrequencyOfCharactersInAStringOfLowerCaseCharacters {

  public static void main(String[] args) {
    testFindFrequency();
  }

  private static void findFrequency(String str) {
    int[] count = new int[26];

    for (int i = 0; i < str.length(); i++) {
      count[str.charAt(i) - 'a']++;
    }

    for (int j : count) {
      if (j > 0) {
        System.out.println(((char) (j + 'a')) + " " + j);
      }
    }
  }

  private static void testFindFrequency() {
    String str = "geeksforgeeks";
    findFrequency(str);
  }
}

package strings.problems;

public class PanagramChecking {

  public static void main(String[] args) {
//    String s = "Bawds jog, flick quartz, vex nymph";
    String s = "sdfs";

    System.out.println(checkPangram(s));
  }

  //Function to check if a string is Pangram or not.
  public static boolean checkPangram(String s) {
    int[] freqLookup = new int[26];

    for (int i = 0; i < s.length(); i++) {
      int index = Character.toLowerCase(s.charAt(i)) - 'a';
      if (index >= 0 && index < 26) {
        freqLookup[index]++;
      }
    }

    for (int freq : freqLookup) {
      if (freq == 0) {
        return false;
      }
    }

    return true;
  }
}

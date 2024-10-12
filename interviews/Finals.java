package interviews;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Finals {

  public static void main(String[] args) {
    String[] A = {"a:Essendon", "b:East Coast", "c:Swans", "d:Tigers"};
    String[] B = {"a:b", "a:c", "a:d", "b:a", "b:c", "b:d", "c:a", "c:b", "c:d", "d:a", "d:b", "d:c"};
    String[] C = {"37:35", "44:50", "111:88", "102:42", "112:81", "81:36", "72:39", "38:64", "57:53", "46:65", "37:73", "95:62"};

    System.out.println(Arrays.toString(solution(A, B, C)));
  }

  public static String[] solution(String[] A, String[] B, String[] C) {
    if (A.length == 0 || B.length == 0 || C.length == 0) {
      return new String[2];
    }

    if (B.length != C.length) {
      return new String[2];
    }

    Map<String, String> teamLookup = new HashMap<>();
    for (String s : A) {
      String[] split = s.split(":");
      teamLookup.put(split[0], split[1]);
    }

    Map<String, Integer> scoreLookup = getScoreMap(B, C);

    int max = -1;
    int secondMax = -1;
    String winner = null;
    String runner = null;
    for (Entry<String, Integer> entry : scoreLookup.entrySet()) {
      if (entry.getValue() > max) {
        secondMax = max;
        max = entry.getValue();
        runner = winner;
        winner = entry.getKey();
      } else {
        if (secondMax == -1 || (entry.getValue() > secondMax)) {
          secondMax = entry.getValue();
          runner = entry.getKey();
        }
      }
    }

    if (winner == null || runner == null) {
      return new String[2];
    } else {
      return new String[]{teamLookup.get(winner), teamLookup.get(runner)};
    }
  }

  private static Map<String, Integer> getScoreMap(String[] B, String[] C) {
    Map<String, Integer> scoreLookup = new HashMap<>();

    for (int i = 0; i < B.length; i++) {
      String[] fixtureSplit = B[i].split(":");
      String team1 = fixtureSplit[0];
      String team2 = fixtureSplit[1];

      String[] scoreSplit = C[i].split(":");
      String team1Score = scoreSplit[0];
      String team2Score = scoreSplit[1];

      scoreLookup.put(team1, scoreLookup.getOrDefault(team1, 0) + Integer.parseInt(team1Score));
      scoreLookup.put(team2, scoreLookup.getOrDefault(team2, 0) + Integer.parseInt(team2Score));
    }

    return scoreLookup;
  }
}

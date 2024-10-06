package strings.problems;

public class Isogram {

  public static void main(String[] args) {
//    String data = "geeks";
    String data = "machine";

    System.out.println(isIsogram(data));
  }

  //Function to check if a string is Isogram or not.
  static boolean isIsogram(String data) {
    boolean[] visited = new boolean[256];
    for (int i = 0; i < data.length(); i++) {
      if (visited[data.charAt(i)]) {
        return false;
      } else {
        visited[data.charAt(i)] = true;
      }
    }

    return true;
  }
}

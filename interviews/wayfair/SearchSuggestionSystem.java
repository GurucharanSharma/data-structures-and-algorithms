package interviews.wayfair;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionSystem {

  public static void main(String[] args) {
    Result result = new Result();

    List<String> products = List.of("camera", "cat", "car", "cast", "crate", "cause");
    String pattern = "camera";

    System.out.println(result.suggestResult(products, pattern));

    // TODO: Do using trie data structure
  }

  static class Result {

    private List<List<String>> suggestResult(List<String> products, String search) {
      List<List<String>> list = new ArrayList<>();
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < search.length(); i++) {
        String pattern = builder.append(search.charAt(i)).toString();
        list.add(getStrings(products, pattern));
      }

      return list;
    }

    private List<String> getStrings(List<String> products, String pattern) {
      return products.stream().filter(s -> s.startsWith(pattern)).sorted().limit(3).toList();
    }
  }
}

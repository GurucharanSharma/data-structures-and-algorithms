package hashing.problems;

import java.util.List;

public class AccountMerge {

  public static void main(String[] args) {
    List<List<String>> accounts = List.of(
        List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
        List.of("Mary", "mary@mail.com"),
        List.of("John", "johnnybravo@mail.com")
    );

    System.out.println(accountsMerge(accounts));
  }

  static List<List<String>> accountsMerge(List<List<String>> accounts) {
    // TODO
    return null;
  }
}

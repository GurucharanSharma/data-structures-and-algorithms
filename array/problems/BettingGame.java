package array.problems;

public class BettingGame {

  public static void main(String[] args) {
//    String result = "WL";
//    String result = "WLWLLLWWLW";
    String result = "WLWLLWLLWWLWWW";

    System.out.println(betBalance(result));
  }

  static int betBalance(String result) {
    int balance = 4;
    int betAmount = 1;

    for (int i = 0; i < result.length(); i++) {
      if (balance < 0 || betAmount > balance) {
        return -1;
      }

      if (result.charAt(i) == 'W') {
        balance = balance + betAmount;
        betAmount = 1;
      } else {
        balance = balance - betAmount;
        betAmount = betAmount * 2;
      }
    }

    return balance;
  }
}

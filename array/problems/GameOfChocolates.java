package array.problems;

/**
 * Bunty and Dolly are playing a game, described as follows: There are two boxes having A and B number of chocolates respectively. Both can eat L (L
 * >= 1) chocolates from any one box or L chocolates from both boxes in one move. They play the game alternatively and the last one to eat the
 * chocolate will be the winner.
 * <p>
 * You have to help Bunty in deciding who should play first such that Dolly is always the winner. Assume that both players play optimally.
 * <p>
 * Note: This game is also known as Wythoff’s Game.
 */
public class GameOfChocolates {

  public static void main(String[] args) {
    int a = 1;
    int b = 2;

    System.out.println(game(a, b) ? "Dolly" : "Bunty");
  }

  static boolean game(int a, int b) {
    double phi = (1 + Math.sqrt(5)) / 2;
    int n = (int) (phi * (Math.abs(a - b)));

    return n != Math.min(a, b);
  }
}

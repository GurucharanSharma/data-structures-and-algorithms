package mathematics.lectures;

public class ComputingPower {

  public static void main(String[] args) {
    int x = 3;
    int n = 5;

    System.out.println(computingPower(x, n));
  }

  private static int computingPower(int x, int y) {
    if (y == 0) {
      return 1;
    }

    int temp = computingPower(x, y / 2);

    if (y % 2 == 0) {
      return temp * temp;
    } else {
      return x * temp * temp;
    }
  }
}

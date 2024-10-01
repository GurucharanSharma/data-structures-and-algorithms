package mathematics;

public class MathematicsRunner {

  public static void main(String[] args) {
    int num = 100;

    System.out.println(computingPower(10, 4));
  }

  private static int computingPower(int n, int p) {
    if (p == 1) {
      return n;
    }

    int temp = computingPower(n, p / 2);

    if (p % 2 == 0) {
      return temp * temp;
    } else {
      return n * temp * temp;
    }
  }

}

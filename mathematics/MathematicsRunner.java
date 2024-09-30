package mathematics;

public class MathematicsRunner {

  public static void main(String[] args) {
    int num = 177;

//    System.out.println(gcd(20, 28));
//    System.out.println(gcd1(20, 28));
    printPrimeFactors(num);
  }

  private static void printPrimeFactors(int n) {
    if (n <= 1) {
      return;
    }

    while (n % 2 == 0) {
      System.out.print(2 + " ");
      n = n / 2;
    }

    while (n % 3 == 0) {
      System.out.print(3 + " ");
      n = n / 3;
    }

    while (n % 5 == 0) {
      System.out.print(5 + " ");
      n = n / 5;
    }

    while (n % 7 == 0) {
      System.out.print(7 + " ");
      n = n / 7;
    }

    for (int i = 11; i < Math.sqrt(n); i = i + 6) {
      while (n % i == 0) {
        System.out.print(i + " ");
        n = n / i;
      }

      while (n % (i + 2) == 0) {
        System.out.print((i + 2) + " ");
        n = n / (i + 2);
      }
    }

    if (n > 7) {
      System.out.println(n);
    }
  }
}

package strings.problems;

public class NthNumberMadeOfPrimeDigits {

  public static void main(String[] args) {
//    int n = 10;
    int n = 21;

    System.out.println(primeDigits(n));
  }

  // Function to find nth number made of only prime digits.
  public static int primeDigits(int n) {
    int count = 0;
    int num = 2;

    while (count < n) {
      int temp = num;
      boolean isPrime = true;

      while (temp > 0) {
        int digit = temp % 10;
        if (!isPrimeDigit(digit)) {
          isPrime = false;
          break;
        }

        temp = temp / 10;
      }

      if (isPrime) {
        count++;
      }

      num++;
    }

    return num - 1;
  }

  private static boolean isPrimeDigit(int digit) {
    if (digit == 1 || digit == 0) {
      return false;
    }

    return digit == 2 || digit == 3 || digit == 5 || digit == 7;
  }
}

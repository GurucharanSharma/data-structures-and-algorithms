package mathematics.lectures;

public class BinaryRepresentation {

  public static void main(String[] args) {
    int n = 10;

    System.out.println(binaryRepresentation(n));
    System.out.println();
    binaryRepresentation1(n);
  }

  private static String binaryRepresentation(int n) {
    StringBuilder reverseBinary = new StringBuilder();
    while (n > 0) {
      reverseBinary.append(n % 2);
      n = n / 2; // shifts the bits of the number 1 position to the right (towards 0)
    }

    reverseBinary.reverse();
    return reverseBinary.toString();
  }

  private static void binaryRepresentation1(int n) {
    if (n == 0) {
      return;
    }

    binaryRepresentation1(n / 2);
    System.out.print(n % 2);
  }
}
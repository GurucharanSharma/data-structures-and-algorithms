package recursion.lectures;

public class BinaryRepresentation {

  public static void main(String[] args) {
    convertToBinary(10);
  }

  static void convertToBinary(int n) {
      if (n <= 0) {
          return;
      }

    convertToBinary(n / 2);
    System.out.print(n % 2 + " ");
  }
}
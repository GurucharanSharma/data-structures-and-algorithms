package mathematics;

public class MathematicsRunner {

  public static void main(String[] args) {
    int n = 10; // 1342177280

    System.out.println(reverseBits(n));
  }

  private static long reverseBits(int n) {
    long reverse = 0;
    for (int i = 0; i < 32; i++) {
      reverse += (n & (1 << i)) > 0 ? (1 << 31 - i) : 0;
    }

    return reverse;
  }
}

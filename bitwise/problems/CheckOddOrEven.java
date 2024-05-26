package bitwise.problems;

public class CheckOddOrEven {

    public static String oddEven(int N) {
        return (N & 1) == 0 ? "even" : "odd";
    }
}

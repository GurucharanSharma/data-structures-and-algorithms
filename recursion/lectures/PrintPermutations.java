package recursion.lectures;

public class PrintPermutations {

    public static void main(String[] args) {
        String str = "ABC";
        permute(str, 0);
    }

    private static void permute(String str, int i) {
        if (i == str.length() - 1) {
            System.out.println(str);
            return;
        }

        for (int j = i; j < str.length(); j++) {
            permute(swap(str, i, j), i + 1);
        }
    }

    private static String swap(String a, int i, int j) {
        // converting string to array
        char temp;
        char[] charArray = a.toCharArray();

        // swapping
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;

        // converting back to string
        return String.valueOf(charArray);
    }
}

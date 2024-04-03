package recursion.lectures;

public class Palindrome {
    public static void main(String[] args) {
        String str = "";
        System.out.println(checkPalindrome(str, 0, str.length() - 1));
    }

    static boolean checkPalindrome(String str, int start, int end) {
        if (start >= end) return true;
        return ((str.charAt(start) == str.charAt(end)) && checkPalindrome(str, start + 1, end - 1));
    }
}

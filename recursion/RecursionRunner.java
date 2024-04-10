package recursion;

import recursion.problems.AtoI;
import recursion.problems.GoodNumbers;
import recursion.problems.PossibleWords;

public class RecursionRunner {

    public static void main(String[] args) {
//        System.out.println(FactorialNumbers.factorialNumbers(7));
//
//        int[] nums = {5, 7, 8, 1, 6, 3};
//        System.out.println(Arrays.toString(ReverseArray.reverseArray(nums.length, nums)));

//        System.out.println(PowerOfNumbers.power(2, 2));
//        System.out.println(PowerOfNumbers.power(12, 21));

//        System.out.println(LuckyNumbers.isLucky(5));
//        System.out.println(LuckyNumbers.isLucky1(5));
//
//        System.out.println(LuckyNumbers.isLucky(19));
//        System.out.println(LuckyNumbers.isLucky1(19));
//
//        System.out.println(LuckyNumbers.isLucky(217));
//        System.out.println(LuckyNumbers.isLucky1(217));

//        int n = 3;
//        int[] a = {2, 3, 4};
//        System.out.println(PossibleWords.possibleWords(a, n));

//        System.out.println(AtoI.atoi("-546+er"));
//        System.out.println(AtoI.atoi("-ban23"));
//        System.out.println(AtoI.atoi("45rohit12"));
//        System.out.println(AtoI.atoi(" +9743764253581200415067431L"));

        System.out.println(GoodNumbers.goodNumbers(840, 850, 6));
        System.out.println(GoodNumbers.goodNumbers(20, 45, 1));

        System.out.println(GoodNumbers.goodNumbers1(840, 850, 6));
        System.out.println(GoodNumbers.goodNumbers1(20, 45, 1));
    }
}

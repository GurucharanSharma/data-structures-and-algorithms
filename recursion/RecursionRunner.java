package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import recursion.problems.CombinationSum;
import recursion.problems.CombinationSumII;

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

//        System.out.println(GoodNumbers.goodNumbers(840, 850, 6));
//        System.out.println(GoodNumbers.goodNumbers(20, 45, 1));
//
//        System.out.println(GoodNumbers.goodNumbers1(840, 850, 6));
//        System.out.println(GoodNumbers.goodNumbers1(20, 45, 1));

//        Stack<Integer> stack = new Stack<>();
//        stack.push(11);
//        stack.push(22);
//        stack.push(33);
//        stack.push(44);
//        stack.push(55);
//
//        System.out.println(stack);
//        ReverseStack.reverseStack(stack);
//        System.out.println(stack);

//        Stack<Integer> stack = new Stack<>();
//        stack.push(30);
//        stack.push(-5);
//        stack.push(18);
//        stack.push(14);
//        stack.push(-3);
//
//        System.out.println("Original Stack: " + stack);
//        SortStack.sortStack(stack);
//        System.out.println("Sorted Stack: " + stack);

//        List<String> list = GenerateBinaryStrings.generateString(3);
//        System.out.println(list);

//        List<String> list = GenerateParenthesis.validParenthesis(3);
//        System.out.println(list);

//        System.out.println(MoreSubsequence.moreSubsequence(3, 4, "abc", "dddd"));

//        long k = 3;
//        int[] a = {1, 2, 3, 1, 1, 1};
//        System.out.println(SubsequencesWithGivenSum.subarraysWithSumK(a, k));

//        int k = 84;
//        int[] a = {22, 17, 19, 46, 48, 27, 22, 39, 20, 13, 18, 50, 36, 45, 4, 12, 23, 34, 24, 15, 42, 12, 4, 19, 48, 45, 13, 8, 38, 10, 24, 42, 30, 29, 17, 36, 41, 43, 39, 7, 41, 43, 15, 49, 47, 6, 41, 30, 21, 1, 7, 2, 44, 49, 30, 24, 35, 5, 7, 41, 17, 27, 32, 9, 45, 40, 27, 24, 38, 39, 19, 33, 30, 42, 34, 16, 40, 9, 5, 31, 28, 7, 24, 37, 22, 46, 25, 23, 21, 30, 28, 24, 48, 13};
//        System.out.println(SubsetSum.isSubsetPresent(a.length, k, a));

//        int B = 14;
//        int[] ARR = {13, 3, 2, 17};
//        System.out.println(CombinationSum.combSum(ARR, B));
//        System.out.println(CombinationSum.combinationSum(ARR, B));

        List<Integer> arr = Arrays.asList(10, 1, 2, 7, 6, 1, 5);
        int target = 8;
//        System.out.println(CombinationSumII.combinationSum2(new ArrayList<Integer>(arr), arr.size(), target));
        System.out.println(CombinationSumII.combinationSum2_1(new ArrayList<Integer>(arr), arr.size(), target));
    }
}

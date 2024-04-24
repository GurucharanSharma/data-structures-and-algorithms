package bitwise;

import bitwise.problems.CountTotalSetBits;
import bitwise.problems.FindFirstSetBit;
import bitwise.problems.RightmostDifferentBit;

public class BitwiseRunner {

    public static void main(String[] args) {
//        System.out.println(FindFirstSetBit.getFirstSetBit(18));
//        System.out.println(FindFirstSetBit.getFirstSetBit(12));

//        System.out.println(CountTotalSetBits.countSetBits(4));
//        System.out.println(CountTotalSetBits.countSetBits1(4));
//        System.out.println(CountTotalSetBits.countSetBits2(4));
//        System.out.println();
//
//        System.out.println(CountTotalSetBits.countSetBits(17));
//        System.out.println(CountTotalSetBits.countSetBits1(17));
//        System.out.println(CountTotalSetBits.countSetBits2(17));
//        System.out.println();

        System.out.println(RightmostDifferentBit.posOfRightMostDiffBit(11, 9));
        System.out.println(RightmostDifferentBit.posOfRightMostDiffBit(52, 4));
        System.out.println(RightmostDifferentBit.posOfRightMostDiffBit(15, 3));
    }
}

package mathematics;

import mathematics.lectures.CountDigits;
import mathematics.problems.ModulerMultiplicativeInverse;
import mathematics.problems.PalindromeNumber;
import mathematics.problems.ReverseBits;

public class MathematicsRunner {

    public static void main(String[] args) {
        // Problems.AbsoluteValue absoluteValue = new Problems.AbsoluteValue();
        // System.out.println(absoluteValue.absolute(-32));

        // Problems.QuadraticEquationRoots rQuadraticEquationRoots = new
        // Problems.QuadraticEquationRoots();
        // System.out.println(rQuadraticEquationRoots.quadraticRoots(752, 904, 164));

        // Problems.Factorial factorial = new Problems.Factorial();
        // System.out.println(factorial.factorial(42));

        // Problems.DigitsInFactorial digitsInFactorial = new Problems.DigitsInFactorial();
        // System.out.println(digitsInFactorial.digitsInFactorial(42));

        // Problems.Exactly3Divisors exactly3Divisors = new Problems.Exactly3Divisors();
        // System.out.println(exactly3Divisors.exactly3Divisors(999999));

        // Problems.GPTerm gpTerm = new Problems.GPTerm();
        // System.out.println(gpTerm.termOfGP(2, 3, 1));

//        ModulerMultiplicativeInverse modulerMultiplicativeInverse = new ModulerMultiplicativeInverse();
//        System.out.println(modulerMultiplicativeInverse.modInverse(10, 17));
//
//        System.out.println(CountDigits.countDigitsIterative(121));
//        System.out.println(CountDigits.countDigitsRecursive(121));

//        System.out.println(ReverseBits.reverseBits(0));
//        System.out.println(ReverseBits.reverseBits(12));
//        System.out.println(ReverseBits.reverseBits(6));
//        System.out.println(ReverseBits.reverseBits(4));

//        System.out.println(PalindromeNumber.palindromeNumber(51415));
        System.out.println(PalindromeNumber.palindromeNumber2(51415));
//        System.out.println(PalindromeNumber.palindromeNumber(1032));
        System.out.println(PalindromeNumber.palindromeNumber2(1032));
//        System.out.println(PalindromeNumber.palindromeNumber(121));
        System.out.println(PalindromeNumber.palindromeNumber2(121));
    }
}

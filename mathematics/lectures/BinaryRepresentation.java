package mathematics.lectures;

import java.lang.*;
import java.io.*;
import java.util.*;

public class BinaryRepresentation {
    public static void main(String[] args) {
        int x =10;
        String reverseBinaery = "";

        while (x > 0) {
            if (x % 2 != 0) {
                reverseBinaery += 1;
            } else {
                reverseBinaery += 0;
            }

            x = x / 2; // shifts the bits of the number 1 position to the right (towards 0)
        }

        StringBuffer input = new StringBuffer(reverseBinaery);
        System.out.println(input.reverse());

        int[] arr = new int[4];
        System.out.println(Arrays.toString(arr));
    }
}
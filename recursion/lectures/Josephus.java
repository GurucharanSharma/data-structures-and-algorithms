package recursion.lectures;

import java.util.ArrayList;

public class Josephus {

    public static void main(String[] args) {
        int n = 10;
        int k = 3;

        System.out.println(josephus(n, k)); // If indexes being with 0
        System.out.println(josephus(n, k) + 1); // If indexes being with 1

        // Iterative approach
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        System.out.println(josephus1(list, (k - 1), 0));
    }

    static int josephus(int n, int k) {
        if (n == 1) {
            return 0;
        }

        // Recursive case: If there are more than one person left (n > 1),
        // the function recursively calls itself with n - 1 people and the same value of k. The returned value
        // represents the position of the last remaining person in the smaller circle. Since we're looking for
        // the position in the original circle of size n, we need to adjust the position by adding k and taking
        // modulo n.
        return (josephus(n - 1, k) + k) % n;
    }

    // Iterative approach using list
    static int josephus1(ArrayList<Integer> list, int k, int index) {
        if (list.size() == 1) {
            return list.get(0);
        }

        // Identify the member to kill. Circle back to the beginning if the next
        // member of out of the bound of the array size.
        index = (index + k) % list.size();

        // Remove the dead member
        list.remove(index);

        return josephus1(list, k, index);
    }
}

package recursion.lectures;

import java.util.ArrayList;

public class Josephus {
    public static void main(String[] args) {
        int n = 16;
        int k = 3;

        System.out.println(josephus(n, k)); // If indexes being with 0
        System.out.println(josephus(n, k) + 1); // If indexes being with 1

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        System.out.println(josephus_1(list, (k - 1), 0));
    }

    static int josephus(int n, int k) {
        if (n == 1) return 0;
        return (josephus(n - 1, k) + k) % n;
    }

    // Iterative approach using list
    static int josephus_1(ArrayList<Integer> arr, int k, int index) {
        if (arr.size() == 1) return arr.get(0);

        // Identify the member to kill. Circle back to the beginning if the next
        // member of out of the bound of the array size.
        index = (index + k) % arr.size();

        // Remove the dead member
        arr.remove(index);

        return josephus_1(arr, k, index);
    }
}

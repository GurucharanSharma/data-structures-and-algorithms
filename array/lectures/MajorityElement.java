package array.lectures;

public class MajorityElement {
    public static void main(String[] args) {
        int[] array = new int[] { 8, 8, 6, 6, 6, 7, 6 };
        System.out.println(getMajorityElement(array));
    }

    static int getMajorityElement(int[] array) {
        int n = array.length;
        int count = 1;
        int res = 0;

        for (int i = 1; i < n; i++) {
            if (array[i] == array[res])
                count++;
            else
                count--;

            if (count == 0) {
                res = i;
                count = 1;
            }
        }

        count = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] == array[res])
                count++;
        }

        if (count > n / 2)
            return array[res];
        else
            return -1;
    }
}

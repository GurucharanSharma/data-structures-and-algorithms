package array.lectures;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] array = new int[] { 5, 0, 6, 2, 3 };
        System.out.println(getWater_1(array));
        System.out.println(getWater_2(array));
    }

    static int getWater_1(int array[]) {
        int n = array.length;
        int res = 0;

        for (int i = 1; i < n - 1; i++) {
            int lMax = array[i];
            for (int j = 0; j < i; j++) {
                lMax = Math.max(lMax, array[j]);
            }

            int rMax = array[i];
            for (int j = i + 1; j < n; j++) {
                rMax = Math.max(rMax, array[j]);
            }

            res += Math.min(rMax, lMax) - array[i];
        }

        return res;
    }

    static int getWater_2(int array[]) {
        int n = array.length;
        int res = 0;
        int[] lMax = new int[n];
        int[] rMax = new int[n];

        lMax[0] = array[0];
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(array[i], lMax[i - 1]);
        }

        rMax[n - 1] = array[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], array[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            res += Math.min(rMax[i], lMax[i]) - array[i]; 
        }

        return res;
    }
}

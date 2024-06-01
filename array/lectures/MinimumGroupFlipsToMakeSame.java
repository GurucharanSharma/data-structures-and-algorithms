package array.lectures;

public class MinimumGroupFlipsToMakeSame {
    public static void main(String[] args) {
        int[] array = new int[] { 0, 0, 0, 0, 0, 1, 1 };
        System.out.println(getMinimumGroupFlips(array));
    }

    static int getMinimumGroupFlips(int[] array) {
        int first = array[0];
        int groupFlipCount = 0;

        for (int i = 1; i < array.length; i++) {
            boolean isFlipped = false;
            while (i < array.length && array[i] != first) {
                isFlipped = true;
                System.out.print(i + " ");
                array[i] = array[i] == 0 ? 1 : 0;
                i++;
            }

            if (isFlipped) {
                groupFlipCount++;
                System.out.println();
            }
        }

        return groupFlipCount;
    }
}

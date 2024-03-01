package array;

public class LeaderInArray {
    public static void main(String[] args) {
        int[] array = new int[] { 7, 10, 4, 10, 6, 5, 2 };
        printLeaders(array);
    }

    static void printLeaders(int[] array) {
        int n = array.length;
        int currentLeader = array[n - 1];
        System.out.println(currentLeader);

        for (int i = n - 2; i >= 0; i--) {
            if (currentLeader < array[i]) {
                currentLeader = array[i];
                System.out.println(currentLeader);
            }
        }
    }
}

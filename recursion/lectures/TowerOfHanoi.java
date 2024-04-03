package recursion.lectures;

public class TowerOfHanoi {
    public static void main(String[] args) {
        moveDisc(5, 1, 2, 3);
    }

    static void moveDisc(int disk, int a, int b, int c) {
        if (disk == 1) {
            System.out.println("Move disk 1 from " + a + " to " + c);
            return;
        }

        moveDisc(disk - 1, a, c, b);
        System.out.println("Move disk " + disk + " from " + a + " to " + c);
        moveDisc(disk - 1, b, a, c);
    }
}

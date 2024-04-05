package recursion.lectures;

/**
 * Tower of Hanoi is a mathematical puzzle where we have three rods (A, B, and C) and N disks. Initially, all the disks are stacked in decreasing
 * value of diameter i.e., the smallest disk is placed on the top and they are on rod A. The objective of the puzzle is to move the entire stack to
 * another rod (here considered C), obeying the following simple rules:
 * <ul>
 * <li>Only one disk can be moved at a time.</li>
 * <li>Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack
 * i.e. a disk can only be moved if it is the uppermost disk on a stack.</li>
 * <li>No disk may be placed on top of a smaller disk.</li>
 * </ul>
 * <p>
 * The idea is to use the helper node to reach the destination using recursion. Below is the pattern for this problem:
 * <ul>
 * <li>Shift ‘N-1’ disks from ‘A’ to ‘B’, using C.</li>
 * <li>Shift last disk from ‘A’ to ‘C’.</li>
 * <li>Shift ‘N-1’ disks from ‘B’ to ‘C’, using A.</li>
 * </ul>
 */
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

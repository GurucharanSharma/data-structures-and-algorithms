package mathematics.problems;

import java.util.ArrayList;
import java.util.Collections;

public class QuadraticEquationRoots {

    public ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        ArrayList<Integer> roots = new ArrayList<>();
        if ((b * b) - (4 * a * c) < 0) {
            roots.add(-1);
        } else {
            roots.add((int) Math.floor(((-1 * b) + Math.sqrt((b * b) - (4 * a * c))) / (2 * a)));
            roots.add((int) Math.floor(((-1 * b) - Math.sqrt((b * b) - (4 * a * c))) / (2 * a)));
        }

        Collections.sort(roots, Collections.reverseOrder());
        return roots;
    }
}

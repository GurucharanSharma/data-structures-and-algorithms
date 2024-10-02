package mathematics.problems;

import java.util.ArrayList;
import java.util.Collections;

public class QuadraticEquationRoots {

  public ArrayList<Integer> quadraticRoots(int a, int b, int c) {
    ArrayList<Integer> roots = new ArrayList<>();
    int discriminant = (b * b) - (4 * a * c);
    if (discriminant < 0) {
      roots.add(-1);
    } else {
      roots.add((int) Math.floor(((-1 * b) + Math.sqrt(discriminant)) / (2 * a)));
      roots.add((int) Math.floor(((-1 * b) - Math.sqrt(discriminant)) / (2 * a)));
    }

    roots.sort(Collections.reverseOrder());
    return roots;
  }
}

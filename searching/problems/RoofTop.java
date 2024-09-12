package searching.problems;

public class RoofTop {

  public static void main(String[] args) {
    int[] arr = {18, 10, 5, 10, 3, 14, 7, 6, 5};

    System.out.println(maxStep(arr));
  }

  // Function to find maximum number of consecutive steps
  // to gain an increase in altitude with each step.
  static int maxStep(int[] arr) {
    int res = 0;
    int curr = 0;
    int start = -1;
    int steps = 0;

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > arr[i - 1]) {
        if (start == -1) {
          start = i;
        }

        curr = curr + (arr[i] - arr[start]);
        res = Math.max(curr, res);
        steps = Math.max(steps, i - start + 1);
      } else {
        start = -1;
        curr = 0;
      }
    }

    return steps;
  }
}

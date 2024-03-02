package searching.problems;

public class MaximumWaterBetweenTwoBuildings {

  public static void main(String[] args) {

    int[] height1 = {2, 1, 3, 4, 6, 5};
    System.out.println(maxWater(height1, height1.length));

    int[] height2 = {2, 1};
    System.out.println(maxWater(height2, height2.length));
  }

  //Function to return the maximum water that can be stored.
  private static int maxWater(int[] height, int n) {
    int start = 0;
    int end = n - 1;
    int max = 0;

    while (start < end) {
      int capacity = Math.min(height[start], height[end]) * (end - start - 1);
      max = Math.max(max, capacity);

      if (height[start] <= height[end]) {
        start++;
      } else {
        end--;
      }
    }

    return max;
  }
}

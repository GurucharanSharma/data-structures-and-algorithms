package array.problems;

import java.util.Arrays;

public class MergeSortedArray {

  public static void main(String[] args) {
    int[] nums1 = {-1, 1, 0, 0, 0, 0, 0, 0};
    int[] nums2 = {-1, 0, 1, 1, 2, 3};

    Solution solution = new Solution();
    solution.merge(nums1, 2, nums2, nums2.length);
    System.out.println(Arrays.toString(nums1));
  }


  static class Solution {

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
      int i = m - 1;
      int j = 0;

      while (i >= 0 && j < n) {
        if (nums1[i] > nums2[j]) {
          int temp = nums1[i];
          nums1[i] = nums2[j];
          nums2[j] = temp;
        } else {
          break;
        }

        i--;
        j++;
      }

      Arrays.sort(nums1, 0, m);
      Arrays.sort(nums2, 0, n);

      i = 0;
      for (; i < (m + n); i++) {
        if (i < m) {
          nums1[i] = nums1[i];
        } else {
          nums1[i] = nums2[i - m];
        }
      }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
      int offset = 1000007;

      int i = 0;
      int j = 0;
      int index = 0;

      while (i < m || j < n) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        if (i < m) {
          a = nums1[i] % offset;
        }

        if (j < n) {
          b = nums2[j];
        }

        if (a <= b) {
          nums1[index] = nums1[index] + (a % offset) * offset;
          index++;
          i++;
        } else {
          nums1[index] = nums1[index] + (b % offset) * offset;
          index++;
          j++;
        }
      }

      i = 0;
      for (; i < (m + n); i++) {
        nums1[i] = nums1[i] / offset;
      }
    }
  }
}

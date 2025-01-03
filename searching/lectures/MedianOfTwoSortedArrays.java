package searching.lectures;

public class MedianOfTwoSortedArrays {

  /**
   * <strong>Explanation</strong>
   * <p>
   * The getMedian method calculates the median of two sorted arrays, arr1 and arr2, by employing a binary search-like approach. It initializes start1
   * as the start index for the first array and end1 as the end index for the first array, covering the entire arr1. The method enters a while loop
   * that continues as long as start1 is less than or equal to end1. Inside the loop, it calculates mid1 as the middle index of the first array and
   * mid2 as the corresponding middle index for the second array. The values min1, max1, min2, and max2 are determined based on the elements in the
   * arrays. The variables maxLeft and minRight are used to calculate the maximum value on the left side and the minimum value on the right side of
   * the potential median. If maxLeft is less than or equal to minRight, it indicates that a median is found. Depending on whether the combined arrays
   * have an even or odd length, the method calculates and returns the median. If max2 is greater than min1, the search range for the first array is
   * adjusted to the right. Otherwise, it's adjusted to the left to continue the binary search. If no median is found in the search, the method
   * returns -1. This approach efficiently calculates the median for two sorted arrays by partitioning the arrays based on the potential median and
   * comparing the values around it.
   */
  public static void main(String[] args) {
    int[] arr1 = new int[]{9, 40, 90, 170, 194, 271, 370, 447, 452, 457, 568, 681, 772, 779, 794, 825, 834, 887, 1130, 1154, 1334, 1443, 1565, 1676,
        2050, 2081, 2085, 2111, 2193, 2461, 2534, 2547, 2616, 2633, 2661, 2768, 2798, 2896, 2917, 2934, 2975, 3064, 3091, 3297, 3309, 3369, 3579,
        3625, 3646, 3752, 3864, 4150, 4162, 4198, 4242, 4253, 4260, 4293, 4398, 4461, 4519, 4932, 5026, 5115, 5135, 5194, 5499, 5530, 5541, 5741,
        5759, 5889, 6013, 6074, 6223, 6226, 6521, 6589, 6594, 6634, 6759, 6875, 6895, 7138, 7190, 7204, 7397, 7413, 7459, 7514, 7527, 7616, 7664,
        7755, 7804, 7940, 8034, 8068, 8101, 8124, 8158, 8178, 8334, 8343, 8407, 8463, 8484, 8506, 8591, 8718, 8790, 8923, 9000, 9005, 9011, 9048,
        9080, 9096, 9125, 9174, 9223, 9378, 9471, 9532, 9544, 9623, 9631, 9854, 9871, 9994, 10007, 10055, 10064, 10410, 10418, 10458, 10482, 10484,
        10609, 10640, 10654, 10693, 10870, 10937, 10972, 10977, 10992, 11405, 11569, 11613, 11705, 11716, 11907, 11992, 12023, 12113, 12131, 12253,
        12346, 12582, 12844, 12850, 12925, 12953, 12968, 13095, 13108, 13279, 13348, 13410, 13502, 13515, 13567, 13606, 13614, 13650, 13775, 13801,
        13837, 13854, 14031, 14056, 14135, 14211, 14292, 14298, 14335, 14515, 14578, 14646, 14755, 14758, 14765, 14766, 14850, 14925, 15064, 15066,
        15083, 15126, 15195, 15228, 15300, 15329, 15572, 15625, 15918, 15924, 16032, 16046, 16106, 16683, 16913, 16988, 17016, 17213, 17239, 17296,
        17346, 17351, 17453, 17495, 17496, 17510, 17515, 17631, 17650, 17700, 17916, 18023, 18075, 18197, 18210, 18362, 18424, 18557, 18659, 18728,
        18732, 18763, 18914, 18917, 18921, 19084, 19216, 19539, 19612, 19656, 19684, 19766, 19928, 19946, 19976, 20284, 20685, 20839, 20957, 21042,
        21140, 21255, 21305, 21437, 21471, 21506, 21514, 21526, 21536, 21569, 21730, 21766, 21981, 22214, 22255, 22284, 22407, 22471, 22518, 22519,
        22585, 22610, 22955, 23023, 23028, 23055, 23152, 23182, 23224, 23278, 23299, 23443, 23566, 23679, 23871, 23941, 24043, 24086, 24428, 24450,
        24482, 24581, 24588, 24589, 24641, 24726, 24862, 24883, 24952, 24995, 25096, 25110, 25301, 25322, 25322, 25400, 25404, 25408, 25515, 25532,
        25602, 25617, 25824, 25894, 26065, 26070, 26146, 26188, 26204, 26264, 26471, 26551, 26609, 26680, 26718, 26874, 26946, 27004, 27062, 27150,
        27282, 27402, 27652, 27784, 27836, 27994, 28006, 28013, 28108, 28140, 28197, 28231, 28247, 28260, 28294, 28295, 28371, 28409, 28477, 28574,
        28658, 28694, 28713, 28716, 28860, 28950, 28961, 28962, 29013, 29020, 29062, 29156, 29188, 29244, 29275, 29353, 29361, 29407, 29465, 29470,
        29500, 29676, 29683, 29755, 29837, 29956, 29956, 29999, 30017, 30093, 30140, 30164, 30377, 30570, 30890, 30899, 31001, 31059, 31198, 31204,
        31243, 31368, 31416, 31444, 31708, 31852, 31942, 32028, 32069, 32072, 32404, 32414, 32444, 32502, 32598, 32743, 32766};
    int[] arr2 = new int[]{6, 19, 83, 112, 130, 193, 253, 324, 324, 407, 623, 631, 766, 922, 936, 976, 1004, 1006, 1036, 1087, 1092, 1145, 1309, 1335,
        1355, 1549, 1560, 1583, 1670, 1707, 1731, 1780, 1844, 1845, 1861, 1908, 1984, 2001, 2005, 2132, 2185, 2261, 2284, 2287, 2457, 2513, 2600,
        2656, 2660, 2740, 2777, 2817, 2830, 2844, 2882, 2932, 2962, 3084, 3103, 3138, 3231, 3236, 3540, 3582, 3619, 3694, 3698, 3935, 4081, 4103,
        4108, 4188, 4206, 4225, 4229, 4436, 4492, 4626, 4633, 4712, 4784, 4813, 4866, 4874, 4920, 5001, 5012, 5128, 5136, 5138, 5219, 5220, 5319,
        5325, 5348, 5417, 5459, 5554, 5567, 5575, 5594, 5677, 5749, 5756, 5764, 5811, 5861, 5896, 5900, 5950, 6009, 6009, 6011, 6059, 6095, 6110,
        6607, 6659, 6667, 6742, 6771, 6773, 6804, 6846, 6868, 6983, 7000, 7017, 7074, 7126, 7179, 7185, 7262, 7268, 7271, 7284, 7342, 7343, 7405,
        7500, 7507, 7615, 7658, 7752, 7775, 7798, 7818, 7837, 7905, 7918, 7919, 8005, 8034, 8060, 8075, 8140, 8298, 8372, 8516, 8537, 8684, 8718,
        8736, 8749, 8836, 8839, 8850, 8905, 8928, 9039, 9060, 9104, 9120, 9226, 9349, 9362, 9401, 9410, 9413, 9501, 9510, 9617, 9723, 9797, 9846,
        9851, 9888, 9931, 10000, 10000, 10043, 10074, 10093, 10100, 10227, 10250, 10299, 10435, 10458, 10500, 10574, 10584, 10586, 10593, 10616,
        10791, 10826, 10846, 10968, 10982, 11056, 11076, 11098, 11132, 11178, 11182, 11277, 11413, 11445, 11457, 11513, 11544, 11561, 11568, 11614,
        11648, 11689, 11827, 11842, 11870, 11977, 12133, 12156, 12193, 12220, 12295, 12307, 12328, 12353, 12369, 12499, 12655, 12906, 12916, 12981,
        13027, 13064, 13122, 13351, 13361, 13362, 13372, 13575, 13617, 13713, 13718, 13727, 13758, 13810, 13844, 13850, 13947, 14044, 14069, 14173,
        14213, 14300, 14350, 14550, 14564, 14572, 14575, 14696, 14714, 14733, 14757, 14782, 14789, 14855, 14860, 14864, 14889, 14983, 15045, 15114,
        15122, 15269, 15280, 15309, 15391, 15429, 15474, 15555, 15620, 15674, 15698, 15731, 15779, 15907, 15937, 15995, 16132, 16162, 16247, 16366,
        16375, 16384, 16503, 16505, 16547, 16578, 16622, 16643, 16665, 16788, 16802, 16856, 16858, 16897, 17008, 17017, 17026, 17028, 17081, 17087,
        17110, 17137, 17169, 17348, 17392, 17439, 17455, 17460, 17475, 17570, 17689, 17769, 17893, 17958, 17965, 17966, 17975, 18095, 18150, 18186,
        18191, 18252, 18351, 18525, 18540, 18755, 18817, 18949, 18956, 18960, 19034, 19052, 19158, 19179, 19180, 19185, 19396, 19477, 19516, 19589,
        19610, 19751, 19754, 19883, 19919, 20072, 20238, 20242, 20258, 20259, 20283, 20304, 20305, 20311, 20319, 20356, 20369, 20438, 20448, 20460,
        20465, 20481, 20563, 20579, 20665, 20680, 20717, 20752, 20766, 20818, 20919, 21072, 21120, 21123, 21131, 21274, 21313, 21398, 21452, 21525,
        21553, 21593, 21624, 21647, 21731, 21750, 21757, 21837, 21975, 21986, 22006, 22060, 22062, 22216, 22302, 22404, 22415, 22423, 22464, 22470,
        22494, 22641, 22653, 22677, 22739, 22812, 22813, 22842, 22854, 22856, 22921, 22937, 23048, 23110, 23272, 23276, 23312, 23323, 23335, 23367,
        23451, 23518, 23525, 23554, 23563, 23565, 23566, 23644, 23684, 23731, 23808, 24029, 24078, 24209, 24260, 24380, 24385, 24521, 24525, 24544,
        24583, 24595, 24654, 24660, 24763, 24855, 24857, 24897, 24999, 25012, 25133, 25144, 25189, 25216, 25235, 25312, 25357, 25368, 25403, 25423,
        25451, 25477, 25579, 25602, 25608, 25612, 25762, 25786, 25801, 25824, 25854, 25873, 25888, 25906, 25908, 25919, 25977, 26066, 26219, 26250,
        26259, 26303, 26321, 26353, 26383, 26458, 26468, 26529, 26544, 26565, 26586, 26595, 26630, 26651, 26659, 26665, 26682, 26819, 26822, 26830,
        26851, 26978, 26996, 27111, 27127, 27139, 27173, 27270, 27350, 27511, 27698, 27757, 28039, 28080, 28117, 28144, 28198, 28211, 28234, 28251,
        28260, 28280, 28329, 28433, 28493, 28532, 28633, 28771, 28822, 28846, 28887, 28888, 28908, 28909, 28953, 28977, 28992, 28999, 29155, 29167,
        29189, 29190, 29221, 29257, 29293, 29347, 29362, 29426, 29549, 29565, 29630, 29720, 29820, 30100, 30107, 30165, 30176, 30227, 30239, 30292,
        30319, 30325, 30359, 30414, 30507, 30543, 30584, 30690, 30691, 30757, 30783, 30850, 31004, 31014, 31086, 31144, 31222, 31284, 31377, 31400,
        31489, 31514, 31532, 31541, 31666, 31682, 31728, 31859, 31865, 31937, 31951, 32012, 32059, 32098, 32130, 32182, 32184, 32206, 32206, 32223,
        32307, 32346, 32412, 32474, 32584, 32612, 32632, 32668, 32701, 32718};

    System.out.println(getMedian(arr1, arr2));
  }

  /**
   * Calculates the median of two sorted arrays using a binary search approach.
   *
   * @param arr1 The first sorted array.
   * @param arr2 The second sorted array.
   * @return The median of the combined arrays or -1 if not found.
   */
  static double getMedian(int[] arr1, int[] arr2) {
    int start1 = 0;                    // Initialize the start index for the first array.
    int end1 = arr1.length;        // Initialize the end index for the first array.

    // Continue searching as long as the start index for the first array is less than or equal to the end index.
    while (start1 <= end1) {
      int mid1 = (start1 + end1) / 2; // Calculate the middle index for the first array.
      int mid2 = (arr1.length + arr2.length + 1) / 2 - mid1; // Calculate the corresponding middle index for the second array.

      int min1 = mid1 == arr1.length ? Integer.MAX_VALUE : arr1[mid1];  // Get the minimum value on the right side of the first array.
      int max1 = mid1 == 0 ? Integer.MIN_VALUE : arr1[mid1 - 1]; // Get the maximum value on the left side of the first array.

      int min2 = mid2 == arr2.length ? Integer.MAX_VALUE : arr2[mid2];  // Get the minimum value on the right side of the second array.
      int max2 = mid2 == 0 ? Integer.MIN_VALUE : arr2[mid2 - 1]; // Get the maximum value on the left side of the second array.

      // If the maximum value on the left is less than or equal to the minimum value on the right, a median is found.
      if (max2 <= min1 && max1 <= min2) {
        if ((arr1.length + arr2.length) % 2 == 0) {
          // If the combined arrays have an even length, calculate and return the average of maxLeft and minRight.
          return ((double) Math.max(max1, max2) + Math.min(min1, min2)) / 2;
        } else {
          // If the combined arrays have an odd length, return the maxLeft as the median.
          return Math.max(max1, max2);
        }
      } else if (max2 > min1) {
        // If max2 is greater than min1, adjust the search range for the first array to the right.
        start1 = mid1 + 1;
      } else {
        // If max2 is not greater than min1, adjust the search range for the first array to the left.
        end1 = mid1 - 1;
      }
    }

    return -1; // Return -1 if the median is not found.
  }

  // Naive Approach: Without using extra space
  public double getMedian1(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int count = 0;
    int i = 0, j = 0;
    int idx1 = (m + n) / 2 - 1, idx2 = (m + n) / 2;
    int item1 = -1, item2 = -1;

    while (i < m && j < n) {
      if (nums1[i] <= nums2[j]) {
        if (count == idx1) {
          item1 = nums1[i];
        }

        if (count == idx2) {
          item2 = nums1[i];
        }

        i++;
      } else {
        if (count == idx1) {
          item1 = nums2[j];
        }

        if (count == idx2) {
          item2 = nums2[j];
        }

        j++;
      }

      count++;
    }

    while (i < m) {
      if (count == idx1) {
        item1 = nums1[i];
      }

      if (count == idx2) {
        item2 = nums1[i];
      }

      i++;
      count++;
    }

    while (j < n) {
      if (count == idx1) {
        item1 = nums2[j];
      }

      if (count == idx2) {
        item2 = nums2[j];
      }

      j++;
      count++;
    }

    if ((m + n) % 2 == 0) {
      return (item1 + item2) / 2.0;
    } else {
      return item2;
    }
  }
}

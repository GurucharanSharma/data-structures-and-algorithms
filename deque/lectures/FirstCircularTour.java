package deque.lectures;

/**
 * Given information about N petrol pumps (say arr[]) that are present in a circular path. The information consists of the distance of the next petrol
 * pump from the current one (in arr[i][1]) and the amount of petrol stored in that petrol pump (in arr[i][0]). Consider a truck with infinite
 * capacity that consumes 1 unit of petrol to travel 1 unit distance. The task is to find the index of the first starting point such that the truck
 * can visit all the petrol pumps and come back to that starting point.
 */
public class FirstCircularTour {

  /**
   * Naive Approach
   */
  public static int execute(int[] petrol, int[] distance) {
    if (petrol.length != distance.length) {
      return -1;
    }

    for (int i = 0; i < petrol.length; i++) {
      int currPetrol = 0;
      for (int j = i; j < i + petrol.length; j++) {
        currPetrol += (petrol[j % petrol.length] - distance[j % petrol.length]);
        if (currPetrol < 0) {
          break;
        }
      }

      if (currPetrol >= 0) {
        return i + 1;
      }
    }

    return -1;
  }

  public static int execute1(int[] petrol, int[] distance) {
    if (petrol.length != distance.length) {
      return -1;
    }

    int start = 0;
    int prevPetrol = 0;
    int currPetrol = 0;
    for (int i = 0; i < petrol.length; i++) {
      currPetrol += (petrol[i] - distance[i]);
      if (currPetrol < 0) {
        start = i + 1;
        prevPetrol += currPetrol;
        currPetrol = 0;
      }
    }

    return (currPetrol + prevPetrol >= 0) ? start + 1 : -1;
  }

  /**
   * The function returns starting point if there is a possible solution, otherwise returns -1
   */
  public static int execute2(int[] petrol, int[] distance) {
    if (petrol.length != distance.length) {
      return -1;
    }

    int start = 0;
    int end = 1;
    int currPetrol = (petrol[start] - distance[start]);

    // If current amount of petrol in truck becomes less than 0, then
    // remove the starting petrol pump from tour
    while (start != end || currPetrol < 0) {
      // If current amount of petrol in truck becomes less than 0, then
      // remove the starting petrol pump from tour
      while (currPetrol < 0 && start != end) {
        // Remove starting petrol pump. Change start
        currPetrol = currPetrol - (petrol[start] - distance[start]);
        start = (start + 1) % petrol.length;

        // If 0 is being considered as start again, then there is no
        // possible solution
        if (start == 0) {
          return -1;
        }
      }

      // Add a petrol pump to current tour
      currPetrol += (petrol[end] - distance[end]);
      end = (end + 1) % petrol.length;
    }

    // Return starting point
    return start + 1;
  }
}

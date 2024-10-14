package deque.lectures;

/**
 * Given information about N petrol pumps (say arr[]) that are present in a circular path. The information consists of the distance of the next petrol
 * pump from the current one (in arr[i][1]) and the amount of petrol stored in that petrol pump (in arr[i][0]). Consider a truck with infinite
 * capacity that consumes 1 unit of petrol to travel 1 unit distance. The task is to find the index of the first starting point such that the truck
 * can visit all the petrol pumps and come back to that starting point.
 */
public class FirstCircularTour {

  public static void main(String[] args) {
    int[] petrol = {4, 6, 7, 4};
    int[] distance = {6, 5, 3, 5};

//    int[] petrol = {6, 3, 7};
//    int[] distance = {4, 6, 3};

    System.out.println(FirstCircularTour.execute(petrol, distance));
    System.out.println(FirstCircularTour.execute1(petrol, distance));
    System.out.println(FirstCircularTour.execute2(petrol, distance));
    System.out.println(FirstCircularTour.execute3(petrol, distance));
  }

  // Naive Approach 1
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
        return i + 1;     // 1-based index
      }
    }

    return -1;
  }

  // Naive approach 2
  public static int execute1(int[] petrol, int[] distances) {
    if (petrol.length != distances.length) {
      return -1;
    }

    for (int i = 0; i < petrol.length; i++) {
      int j = i;
      int currPetrol = 0;

      while (true) {
        currPetrol += (petrol[j] - distances[j]);
        if (currPetrol < 0) {
          break;
        }

        j = (j + 1) % petrol.length;
        if (j == i) {
          return i + 1;     // 1-based index
        }
      }
    }

    return -1;
  }

  // Better Approach: First Circular Tour Using Queue
  // Instead of building a separate queue, we can use start and end pointers to make our array behave like a queue.
  // Note: Each petrol pump will be added in the queue at most twice and will be removed at most once.
  // The function returns starting point if there is a possible solution, otherwise returns -1.
  public static int execute2(int[] petrol, int[] distance) {
    if (petrol.length != distance.length) {
      return -1;
    }

    int start = 0;
    int end = 1;
    int currPetrol = (petrol[start] - distance[start]);

    // If current amount of petrol in truck becomes less than 0, then remove the starting petrol pump from tour
    while (start != end || currPetrol < 0) {
      while (currPetrol < 0 && start != end) {
        // Remove starting petrol pump. Change start
        currPetrol = currPetrol - (petrol[start] - distance[start]);
        start = (start + 1) % petrol.length;

        // If 0 is being considered as start again, then there is no possible solution
        if (start == 0) {
          return -1;
        }
      }

      // Add a petrol pump to current tour
      currPetrol += (petrol[end] - distance[end]);
      end = (end + 1) % petrol.length;
    }

    // Return starting point
    return start + 1;     // 1-based index
  }

  // Efficient Solution
  public static int execute3(int[] petrol, int[] distance) {
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

    return (currPetrol + prevPetrol >= 0) ? start + 1 : -1;   // 1-based index
  }
}

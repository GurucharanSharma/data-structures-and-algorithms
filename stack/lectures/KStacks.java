package stack.lectures;

import java.util.Arrays;

public class KStacks {

  private final int[] arr;
  private final int[] next;
  private final int[] top;
  private final int size;
  private int freeTop;

  public KStacks(int size, int stacks) {
    this.size = size;
    this.freeTop = 0;

    this.arr = new int[size];

    this.next = new int[size];
    for (int i = 0; i < next.length - 1; i++) {
      next[i] = i + 1;
    }
    next[next.length - 1] = -1;

    this.top = new int[stacks];
    Arrays.fill(top, -1);
  }

  public boolean push(int stack, int val) {
    if (freeTop == -1) {
      System.out.printf("Stack %s is full\n", stack);
      return false;
    }

    int index = freeTop;
    arr[index] = val;
    freeTop = next[index];
    next[index] = top[stack - 1];
    top[stack - 1] = index;

    return true;
  }

  public Integer pop(int stack) {
    if (top[stack - 1] == -1) {
      System.out.printf("Stack %s is empty\n", stack);
      return null;
    }

    int index = top[stack - 1];
    top[stack - 1] = next[index];
    next[index] = freeTop;
    freeTop = index;

    return arr[index];
  }

  public boolean isEmpty(int stack) {
    return top[stack - 1] == -1;
  }

  public Integer peek(int stack) {
    if (top[stack - 1] == -1) {
      System.out.printf("Stack %s is empty\n", stack);
      return null;
    }

    int index = top[stack - 1];
    return arr[index];
  }
}

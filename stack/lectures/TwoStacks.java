package stack.lectures;

public class TwoStacks {

  public static class Stack {

    private final int[] arr;
    private int top_1, top_2;
    private final int size;

    public Stack(int size) {
      this.size = size;
      this.arr = new int[size];

      this.top_1 = -1;
      this.top_2 = size;
    }

    public boolean push(int stack, int val) {
      if (stack == 1) {
        if (top_1 < top_2 - 1) {
          arr[++top_1] = val;
          return true;
        } else {
          System.out.println("First stack is full");
          return false;
        }
      } else if (stack == 2) {
        if (top_2 > top_1 + 1) {
          arr[--top_2] = val;
          return true;
        } else {
          System.out.println("Second stack is full");
          return false;
        }
      } else {
        System.out.println("Invalid stack number");
        return false;
      }
    }

    public Integer pop(int stack) {
      if (stack == 1) {
        if (top_1 == -1) {
          System.out.println("First stack is empty");
          return null;
        } else {
          return arr[top_1--];
        }
      } else if (stack == 2) {
        if (top_2 == size) {
          System.out.println("Second stack is empty");
          return null;
        } else {
          return arr[top_2++];
        }
      } else {
        System.out.println("Invalid stack number");
        return null;
      }
    }

    public boolean isEmpty(int stack) {
      return (stack == 1 && top_1 == -1) || (stack == 2 && top_2 == size);
    }

    public int getSize(int stack) {
      return (stack == 1) ? (top_1 + 1) : (stack == 2 ? (size - top_2) : -1);
    }
  }
}

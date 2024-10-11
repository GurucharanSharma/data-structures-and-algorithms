package stack;

import stack.lectures.BalancedParenthesis;
import stack.lectures.GetMinInStack.ConstantMinStack;
import stack.lectures.GetMinInStack.MinStack;
import stack.lectures.GetMinInStack.PositiveMinStack;
import stack.lectures.InfixToPostfix;
import stack.lectures.InfixToPrefix;
import stack.lectures.KStacks;
import stack.lectures.LargestRectangularArea;
import stack.lectures.NextGreaterElement;
import stack.lectures.NextSmallerElement;
import stack.lectures.PostfixEvaluation;
import stack.lectures.PrefixEvaluation;
import stack.lectures.PreviousGreaterElement;
import stack.lectures.PreviousSmallerElement;
import stack.lectures.StockSpan;
import stack.lectures.TwoStacks;

public class StaticStack {

  public static void main(String[] args) {
    Stack stack = new Stack(5);

    stack.push(10);
    stack.push(20);
    stack.push(30);

    System.out.println(stack.peek());
    System.out.println(stack.size());
    System.out.println(stack.isEmpty());

    stack.push(40);
    stack.push(50);

    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.size());
    System.out.println(stack.isEmpty());

    stack.push(60);
    stack.push(70);

    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.size());
    System.out.println(stack.isEmpty());

    // BalancedParenthesis
    System.out.println("\nBalancedParenthesis => ");
    System.out.println(BalancedParenthesis.execute("[()]{}{[()()]()}"));
    System.out.println(BalancedParenthesis.execute("[(])"));

    // TwoStacks
    System.out.println("\nTwoStacks => ");
    TwoStacks.Stack twoStack = new TwoStacks.Stack(5);
    System.out.println(twoStack.push(1, 10));
    System.out.println(twoStack.push(1, 20));
    System.out.println(twoStack.push(1, 30));
    System.out.println(twoStack.push(1, 40));
    System.out.println(twoStack.push(1, 50));
    System.out.println(twoStack.push(1, 60));
    System.out.println(twoStack.push(2, 100));
    System.out.println(twoStack.pop(2));
    System.out.println(twoStack.pop(1));
    System.out.println(twoStack.pop(1));
    System.out.println(twoStack.pop(1));
    System.out.println(twoStack.push(2, 100));

    // KStacks
    System.out.println("\nKStacks => ");
    KStacks kStack = new KStacks(10, 3);

    kStack.push(3, 15);
    kStack.push(3, 45);

    kStack.push(2, 17);
    kStack.push(2, 49);
    kStack.push(2, 39);

    kStack.push(1, 11);
    kStack.push(1, 9);
    kStack.push(1, 7);

    System.out.println("Popped element from stack 2 is " + kStack.pop(3));
    System.out.println("Popped element from stack 1 is " + kStack.pop(2));
    System.out.println("Popped element from stack 0 is " + kStack.pop(1));

    // StockSpan
    System.out.println("\nStockSpan => ");
    int[] price = { 10, 4, 5, 90, 120, 80 };
    System.out.println(StockSpan.execute(price));
    System.out.println(StockSpan.execute1(price));

    // PreviousGreaterElement
    System.out.println("\n PreviousGreaterElement => ");
    int[] pgeArr = { 10, 4, 2, 20, 40, 12, 30 };
    System.out.println(PreviousGreaterElement.execute(pgeArr));

    // NextGreaterElement
    System.out.println("\n NextGreaterElement => ");
    int[] ngeArr = { 6, 8, 0, 1, 3 };
    System.out.println(NextGreaterElement.execute(ngeArr));

    // PreviousSmallerElement
    System.out.println("\nPreviousSmallerElement => ");
    int[] pseArr = { 6, 2, 5, 4, 5, 1, 6 };
    System.out.println(PreviousSmallerElement.execute(pseArr));

    // NextSmallerElement
    System.out.println("\nNextSmallerElement => ");
    int[] nseArr = { 10, 4, 2, 20, 40, 12, 30, 10, 2 };
    System.out.println(NextSmallerElement.execute(nseArr));

    // LargestRectangularArea
    System.out.println("\nLargestRectangularArea => ");
    int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
    System.out.println(LargestRectangularArea.execute(hist));
    System.out.println(LargestRectangularArea.execute1(hist));
    System.out.println(LargestRectangularArea.execute2(hist));

    // GetMinInStack
    System.out.println("\nGetMinInStack => ");
    MinStack sMinStack = new MinStack();
    sMinStack.push(10);
    sMinStack.push(5);
    sMinStack.push(7);
    System.out.println(sMinStack.getMin());

    sMinStack.push(3);
    System.out.println(sMinStack.getMin());

    sMinStack.pop();
    System.out.println(sMinStack.getMin());

    System.out.println("\nGetMinInStack (+ve numbers) => ");
    PositiveMinStack pMinStack = new PositiveMinStack();
    pMinStack.push(10);
    pMinStack.push(5);
    pMinStack.push(7);
    System.out.println(pMinStack.getMin());

    pMinStack.push(3);
    System.out.println(pMinStack.getMin());

    pMinStack.pop();
    System.out.println(pMinStack.getMin());

    System.out.println("\nGetMinInStack O(1) space and O(1) time => ");
    ConstantMinStack cMinStack = new ConstantMinStack();
    cMinStack.push(10);
    cMinStack.push(5);
    cMinStack.push(7);
    System.out.println(cMinStack.getMin());

    cMinStack.push(3);
    System.out.println(cMinStack.getMin());

    cMinStack.pop();
    System.out.println(cMinStack.getMin());

    // InfixToPostfix
    System.out.println("\nInfixToPostfix => ");
    String expString = "a+b*(c^d-e)^(f+g*h)-i";
    System.out.println(InfixToPostfix.execute(expString));

    // EvaluationOfPostfix
    System.out.println("\nEvaluationOfPostfix => ");
    String postfix = "231*+9-";
    System.out.println(PostfixEvaluation.execute(postfix));

    // InfixToPrefix
    System.out.println("\nInfixToPrefix => ");
    String preString = ("x+y*z/w+u");
    System.out.println(InfixToPrefix.execute(preString));

    // PrefixEvaluation
    System.out.println("\nPrefixEvaluation => ");
    String prefix = "+9*26";
    System.out.println(PrefixEvaluation.execute(prefix));
  }

  // Implemented using arrays
  static class Stack {

    private final int[] arr;
    private final int size;
    private int top;

    Stack(int size) {
      this.size = size;
      this.arr = new int[size];
      this.top = -1;
    }

    public void push(int val) {
      if (top + 1 == size) {
        System.out.println("Stack overflow");
        return;
      }

      top++;
      arr[top] = val;
    }

    public int pop() {
      if (top == -1) {
        System.out.println("Stack empty");
        return -1;
      }

      return arr[top--];
    }

    public int peek() {
      if (top == -1) {
        System.out.println("Stack empty");
        return -1;
      }

      return arr[top];
    }

    public int size() {
      return top + 1;
    }

    public boolean isEmpty() {
      return (top == -1);
    }
  }
}

package array;

import java.util.*;

public class Problems {
    private static int result;

    public static void main(String[] args) {
        // Problem 1
        // int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        // rangeSum(array, 2, 7);

        // Problem 2: Array insert at index
        // int[] arr = new int[6];

        // System.out.println("Before insertion");
        // for (int i = 0; i < arr.length - 2; i++) {
        // arr[i] = i;
        // System.out.print(i + " ");
        // }
        // System.out.println();

        // insertAtIndex(arr, arr.length, 2, 90);

        // System.out.println("After insertion");
        // for (int i = 0; i < arr.length - 1; i++) {
        // System.out.print(arr[i] + " ");
        // }

        // Problem 3: Maximum Index Differnce
        // int A[] = {1, 10};
        // System.out.println(maxIndexDiff(A, 2));

        // Problem 4: Max and Second Max
        // int arr[] = {1,2,3,4,5};
        // System.out.println(largestAndSecondLargest(arr.length, arr));

        // Problem 5: Mean and Median of Array

        // Problem 6: Check if array is sorted and rotated
        // int arr[] = {10, 20, 14};
        // System.out.println(checkRotatedAndSorted(arr, arr.length));

        // Problem 7: Reverse array in groups
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5,6,8,9));
        // for (int i = 0; i < arr.size(); i++) {
        //     System.out.print(arr.get(i) + " ");
        // }
        // System.out.println();

        // reverseInGroups(arr, arr.size(), 3);

        // for (int i = 0; i < arr.size(); i++) {
        //     System.out.print(arr.get(i) + " ");
        // }
        // System.out.println();

        // Problem 8: Rearrange an array with O(1) extra space
        // long arr[] = {1l, 0l};
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();

        // arrange(arr, arr.length);

        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();

        // Problem 9: Leaders in an array
        // int A[] = {1,2,3,4,0};
        // System.out.println(leaders(A, A.length));

        // Problem 10: Rearrange array alternately
        // long arr[] = {1,2,3,4,5,6};
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();

        // rearrange(arr, arr.length);

        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();

        // Problem 11: Smallest positive missing number
        // int arr[] = {0, 1};
        // System.out.println(missingNumber(arr, arr.length));
        // System.out.println(missingNumber_1(arr, arr.length));

        // Problem 12: Frequencies of limited range array elements
        // int arr[] = {4,5,6,7,8};
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();

        // frequencyCount(arr, arr.length, Integer.parseInt(args[0]));

        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();

        // Problem 13: Stock buy and sell
        // int A[] = {4,3,2,1};
        // System.out.println(stockBuySell(A, A.length));

        // Problem 14: Trapping rain water
        // int arr[] = {6,9,9};
        // System.out.println(trappingWater(arr, arr.length));

        // Problem 15: Number game
        // System.out.println(numGame(Long.parseLong(args[0])));

        // Problem 16: Kedane's Algorithm
        // int arr[] = {-1,-2,-3,-4};
        // System.out.println(maxSubarraySum(arr, arr.length));

        // Problem 17: Max circular subarray sum
        // int arr[] = {10,-3,-4,7,6,5,-4,-1};
        // System.out.println(circularSubarraySum(arr, arr.length));

        // Problem 18: Minimum adjacent difference in a circular array
        // int arr[] = {10,-3,-4,7,6,5,-4,-1};
        // System.out.println(minAdjDiff(arr, arr.length));

        // Problem 19: Wave Array
        // int arr[] = {2,4,7,8,9,10};
        
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();

        // convertToWave(arr.length, arr);

        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();

        // Problem 20: Who has the majority
        // int arr[] = {5, 22, 29, 12, 32, 69, 1, 75};
        // System.out.println(majorityWins(arr, arr.length, Integer.parseInt(args[0]), Integer.parseInt(args[1])));

        // Problem 21: Find the Safe Position
        // See the josephus problem solution in Recursion

        // Problem 22: Fraction Trouble
        // int res[] = LargestFraction(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        // System.out.println(res[0] + " " + res[1]);

        // int res_1[] = LargestFraction_1(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        // System.out.println(res_1[0] + " " + res_1[1]);

        // Problem 23: Pattern searching
        // System.out.println(searchPattern(args[0], args[1]));

        // Problem 24: Print Pattern
        // System.out.println(pattern(Integer.parseInt(args[0])));

        // Problem 25: Longest Subarray Of Evens And Odds
        // int arr[] = {4,6};
        // System.out.println(maxEvenOdd(arr, arr.length));

        // Problem 26: Betting game
        // System.out.println(betBalance(args[0]));

        // Problem 27: Equilibrium Point
        // long arr[] = {1};
        // System.out.println(equilibriumPoint(arr, arr.length));

        // Problem 28: Strongest Neighbour
        // int arr[] = {5, 5};
        // maximumAdjacent(arr.length, arr);

        // Problem 29: Game of Chocolates
        System.out.println(game(Integer.parseInt(args[0]), Integer.parseInt(args[1])) ? "Dolly" : "Bunty");
    }

    // Function to find the winning player
    static boolean game(int a, int b){
        // Code Here
        double phi = (1 + Math.sqrt(5)) / 2;
        int n = (int) (phi * (Math.abs(A - B)));

        if (n == Math.min(A, B)) return false;
        else return true;
    }

    // Function to find maximum for every adjacent pairs in the array.
    static void maximumAdjacent(int sizeOfArray, int arr[]) {
       for (int i = 1; i < sizeOfArray; i++) {
            System.out.print(Math.max(arr[i], arr[i - 1]) + " ");
       }
    }

    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {
        // Your code here
        long[] prefixSum = new long[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        long[] suffixSum = new long[n];
        suffixSum[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + arr[i];
        }

        for (int i = 0; i < n; i++) {
            if (prefixSum[i] == suffixSum[i]) return i + 1;
        }

        return -1;
    }

    // Function to calculate the betting balance
    static int betBalance(String result) {
        // code here
        int betBalance = 4;
        int betAmount = 1;
        for (int i = 0; i < result.length(); i++) {
            if (betBalance < 0 || betAmount > betBalance) return -1;

            if (result.charAt(i) == 'W') {
                betBalance = betBalance + betAmount;
                betAmount = 1;
            } else {
                betBalance = betBalance - betAmount;
                betAmount = 2 * betAmount;
            }
        }
        
        return betBalance;
    }

    // arr[]: input array
    // n: size of array
    // Function to find the length of longest subarray of even and odd numbers.
    public static int maxEvenOdd(int arr[], int n) {
        // your code here
        int length = 1;
        int result = 1;
        for (int i = 1; i < n; i++) {
            if ((isEven(arr[i-1]) && !isEven(arr[i])) || (!isEven(arr[i-1]) && isEven(arr[i]))) {
                length++;
                result = Math.max(result, length);
            } else {
                length = 1;
            }
        }

        return result;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    // Function to print pattern
    public static List<Integer> pattern(int N) {
        // code here
        result = N;
        ArrayList<Integer> list = new ArrayList<>();
        printPattern(list, N, 1);

        return list;
    }

    public static void printPattern(List<Integer> list, int n, int flipper) {
        list.add(n);
        n = n - 5 * flipper;

        if (n <= 0) flipper = -1;

        if (n == result) {
            list.add(n);
            return;
        } else {
            printPattern(list, n, flipper);
        }
    }

    // Function to search pattern
    public static boolean searchPattern(String str, String pat) {
        // code here
        int end = str.length() - 1;
        for (int i = pat.length(); i <= str.length(); i++) {
            if (str.substring(i - pat.length(), i).equals(pat)) return true;
        }

        return false;
    }

    // Function to find the largest fraction
    public static int[] LargestFraction(int n, int d) {
        // code here
        int num   = 0;
        int denom = 1;

        for (int q = d + 1; q <= 10000; q++) {
            int p = (n * q - 1) / d;
            //System.out.println(p + " " + q);
            if (gcd (p, q) == 1 && ((1.0 * p / q) > (1.0 * num / denom))) {
                num = p;
                denom = q;
            }
        }

        return new int[]{num, denom};
    }

    public static int[] LargestFraction_1(int n, int d) {
        // code here       
        int num   = 0;
        int denom = 1;

        for (int q = 10000; q > 1; q--) {
            // Below is done for the scenarios where n == d.
            int p = (n * q - 1) / d;
            //System.out.println(p + " " + q);
            if (gcd (p, q) == 1 && ((1.0 * p / q) > (1.0 * num / denom))) {
                num = p;
                denom = q;
            }
        }

        return new int[]{num, denom};
    }

    // Function to find element with more appearances between two elements in an
    // array.
    public static int majorityWins(int arr[], int n, int x, int y) {
        int countX = 0;
        int countY = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) countX++;
            if (arr[i] == y) countY++;
        }

        if (countX == countY) {
            return (x < y) ? (x) : (y);
        } else {
            return (countX > countY) ? x : y;
        }
    }

    public static void convertToWave(int n, int[] a) {
        // code here
        for (int i = 1; i < n; i = i + 2) {
            int temp = a[i];
            a[i] = a[i - 1];
            a[i - 1] = temp;
        }
    }

    //Function to find minimum adjacent difference in a circular array.
    // arr[]: input array
    // n: size of array
    public static int minAdjDiff(int arr[], int n) {
        // Your code here
        int difference = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            difference = Math.min(difference, Math.abs(arr[i] - arr[(i + 1) % n]));
        }

        return difference;
    }

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        // Your code here
        int normalSum = (int) maxSubarraySum(a, n);
        if (normalSum < 0) return normalSum;

        int arraySum = 0;
        for (int i = 0; i < n; i++) {
            arraySum += a[i];
            a[i] = -1 * a[i];
        }

        int circularSum = arraySum + (int) maxSubarraySum(a, n);
        return Math.max(circularSum, normalSum);
    }

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    static long maxSubarraySum(int arr[], int n) {
        // Your code here
        long res = arr[0];
        long sum = arr[0];
        for (int i = 1; i < n; i++) {
            sum = Math.max(arr[i], arr[i] + sum);
            res = Math.max(res, sum);
        }

        return res;
    }

    static Long numGame(Long n) {
        // code here
        long num = 1;
        for (int i = 1; i <= n; i++) {
            num = (num * i) / gcd(num, i) % 100000007;
        }

        return num;
    }

    public static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b%a, a);
    }

    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
        int leftMax[] = new int[n];
        leftMax[0] = arr[0];
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i - 1]);
        }

        int rightMax[] = new int[n];
        rightMax[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(arr[i], rightMax[i + 1]);
        }

        long total = 0;
        for (int i = 1; i < n - 1; i++) {
            total = total + Math.min(leftMax[i], rightMax[i]) - arr[i];
        }

        return total;
    }

                
    //Function to find the days of buying and selling stock for max profit.
    static ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        // code here
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> subList = new ArrayList<>();
            int buy = i - 1;
            while (i < n && A[i] > A[i - 1]) i++;
            int sell = i - 1;

            if (buy < sell) {
                subList.add(buy);
                subList.add(sell);
                finalList.add(subList);
            }
        }

        return finalList;
    }

    //Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P) {
        // code here
        for (int i = 0; i < N; i++) {
            arr[i] = arr[i] - 1;
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] % (P + 1) < N)
                arr[arr[i] % (P + 1)] = arr[arr[i] % (P + 1)] + (P + 1);
        }

        for (int i = 0; i < N; i++) {
            arr[i] = arr[i] / (P + 1);
        }
    }

    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size) {
        // Your code here
        int min = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
                min++;
            }
        }

        // for (int i = 0; i < size; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();

        // System.out.println("Min: " + min + " | Max: " + max);

        for (int i = min; i < size; i++) {
            if ((min + Math.abs(arr[i]) - 1) < size) {
                arr[min + Math.abs(arr[i]) - 1] = -1 * arr[min + Math.abs(arr[i]) - 1];
            }
        }

        // for (int i = 0; i < size; i++) {
        //     System.out.print(arr[i] + " ");
        // }
                
        // System.out.println();

        for (int i = 0; i < size; i++) {
            if (arr[i] > 0) return i + 1 - min;
        }

        return size - min + 1;
    }

    //Function to find the smallest positive number missing from the array.
    static int missingNumber_1(int arr[], int size) {
        // Your code here
        for (int i = 0; i < size; i++) {
            int index = arr[i] - 1;
            while (index >= 0 && index < size && arr[index] != arr[i]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index = arr[i] - 1;
            }
        }

        for (int i = 0; i < size; i++) {
            if (arr[i] != (i + 1)) return i + 1;
        }

                
        return size + 1;
    }

    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public static void rearrange(long arr[], int n) {
        // Your code here
        int min = 0;
        int max = n - 1;
                
        long divisor = arr[max] + 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i] + (arr[max] % divisor) * divisor;
                max--;
            } else {
                arr[i] = arr[i] + (arr[min] % divisor) * divisor;
                min++;
            }
        }

        // for (int i = 0; i < n; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / divisor;
        }
    }

    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> leaders = new ArrayList<>();
        leaders.add(arr[n - 1]);

        int max = arr[n - 1];
        // Your code here
        for (int i = n - 2; i >= 0; i--) {

            max = Math.max(arr[i], max);
            if (arr[i] == max) {
                leaders.add(arr[i]);
            }
        }

        Collections.reverse(leaders);
        return leaders;
    }

    // arr: input array
    // n: size of array
    //Function to rearrange an array so that arr[i] becomes arr[arr[i]]
    //with O(1) extra space.
    static void arrange(long arr[], int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] + (arr[(int) arr[i]] % n) * n;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = (int) (arr[i] / n);
        }
    }
                

    //Function to reverse every sub-array group of size k.
    static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here

        for (int i = 0; i < n; i++) {
            // int startCounter = start;
            int end = i + (k - 1) >= n ? n - 1 : (i + (k - 1));
            int counter = end;

            while (i < counter) {
                int temp = arr.get(i);
                arr.set(i, arr.get(counter));
                arr.set(counter, temp);
                i++;
                counter--;
            }

            i = end;
        }
    }

    // arr[]: input array
    // num: size of array
    // Function to check if array is sorted and rotated
    public static boolean checkRotatedAndSorted(int arr[], int num) {
        // Your code here
        int min = arr[0];
        int flippingPoint = -1;

        if (arr[num - 1] < arr[0]) {
            for (int i = 1; i < num; i++) {
                if (arr[i] < arr[i - 1]) {
                    if (flippingPoint == -1) flippingPoint = i;
                    else return false;
                }
            }
        } else {
            for (int i = 1; i < num; i++) {
                if (arr[i] > arr[i - 1]) {
                    if (flippingPoint == -1) flippingPoint = i;
                    else return false;
                }
            }
        }

        return !(flippingPoint == -1);
    }

    // Function to find median of the array elements.
    public int median(int A[], int N) {

        Arrays.sort(A);

        // Your code here
        // If median is fraction then conver it to integer and return
        return (int) ((N % 2 == 0) ? (A[N/2] + A[N/2 - 1]) / 2 : A[(int) N/2]);
    }

    // Function to find median of the array elements.
    public int mean(int A[], int N) {
        // Your code here

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
        }

        return (int) sum / N;
    }

    // Function to find largest and second largest element in the array
    public static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int arr[]) {
        // code here.
        int max = arr[0];
        int secondMax = -1;

        for (int i = 1; i < sizeOfArray; i++) {
            if (arr[i] > max) {
                secondMax = max;
                
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] < max) {
                secondMax = arr[i];
            }
        }

        return new ArrayList<>(Arrays.asList(max, secondMax));
    }

    static int matchGame(Long N) {
        // code here
        return (int) ((N % 5 == 0) ? -1 : (N % 5));
    }

                
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int A[], int N) {
        int prefixMin[] = new int[N];
        int suffixMax[] = new int[N];

        prefixMin[0] = A[0];
        suffixMax[N - 1] = A[N - 1];
        for (int i = 1; i < N; i++) {
            prefixMin[i] = Math.min(A[i], prefixMin[i - 1]);
            suffixMax[N - (i + 1)] = Math.max(suffixMax[N - i], A[N - (i + 1)]);
        }

        // for (int i = 0; i < N; i++) {
        // System.out.print(prefixMin[i] + " ");
        // }
        // System.out.println();

        // for (int i = 0; i < N; i++) {
        // System.out.print(suffixMax[i] + " ");
        // }
        // System.out.println();

        int i = 0;
        int j = 0;
        int difference = 0;
        while (true) {
            if (i >= N || j >= N)
                break;

            // System.out.print(i + " " + j + "\n");

            if (prefixMin[i] > suffixMax[j]) {
                i++;
            } else {
                difference = (j - i) > difference ? (j - i) : difference;
                j++;
            }
                
        }

        return difference;
    }

    static int rangeSum(int[] array, int start, int end) {

        int[] sum = new int[array.length];
        sum[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            sum[i] = sum[i - 1] + sum[i];
        }

        return -1;
    }

                
    static void insertAtIndex(int arr[], int sizeOfArray, int index, int element) {
        for (int i = sizeOfArray - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = element;
    }
}

                
/*
https://practice.geeksforgeeks.org/problems/maximum-index/0
https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
 */


import java.util.Arrays;

public class MaximumIndex {
    /* Utility Functions to get max and minimum of two integers */
    int max(int x, int y) {
        return x > y ? x : y;
    }

    int min(int x, int y) {
        return x < y ? x : y;
    }

    /* For a given array arr[], returns the maximum j-i such that
       arr[j] > arr[i] */
    int maxIndexDiff(int arr[], int n) {
        int maxDiff;
        int i, j;

        int RMax[] = new int[n];
        int LMin[] = new int[n];

        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            LMin[i] = min(arr[i], LMin[i - 1]);

        System.out.println("LMin=");
        Arrays.stream(LMin).forEach( x-> System.out.print(x + " "));

        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            RMax[j] = max(arr[j], RMax[j + 1]);

        System.out.println("\nRMax=");
        Arrays.stream(RMax).forEach( x-> System.out.print(x + " "));

        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
        i = 0;
        j = 0;
        maxDiff = -1;
        System.out.println();
        while (j < n && i < n) {
            if (LMin[i] < RMax[j]) {
                maxDiff = max(maxDiff, j - i);
                j = j + 1;
                System.out.println("j="+j);
            } else {
                i = i + 1;
                System.out.println("i="+i);
            }
        }

        return maxDiff;
    }

    /* Driver program to test the above functions */
    public static void main(String[] args) {
        MaximumIndex max = new MaximumIndex();
        int arr[] = {20, 6, 18, 4, 5, 3 , 7, 8, 2, 1};
        int n = arr.length;
        int maxDiff = max.maxIndexDiff(arr, n);
        System.out.println("\nMaxDiff="+ maxDiff);
    }
}


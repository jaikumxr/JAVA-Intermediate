
// { Driver Code Starts
import java.util.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking count of testcases
        int t = sc.nextInt();
        while (t-- > 0) {

            // taking count of houses
            int n = sc.nextInt();
            int arr[] = new int[n];

            // inserting money present in
            // each house in the array
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt();

            // calling method FindMaxSum() of class solve
            System.out.println(new MaxSumNo2Adjacent().FindMaxSum(arr, n));
        }
    }
}// } Driver Code Ends

class MaxSumNo2Adjacent {
    // Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n) {
        int res = 0;
        int[] dp = new int[n];
        if(n<3){
            for (int i = 1; i < n; i++) {
                res = Math.max(arr[i], res);
            }
            return res;
        }
        if(n==3){
            return Math.max(arr[0]+arr[2], arr[1]);
        }

        dp[0] = arr[0];
        dp[1] = arr[1];
        dp[2] = arr[2]+arr[0];

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3]) + arr[i];
        }

        for (int i : dp) {
            res = Math.max(i, res);
        }
        return res;
    }
}
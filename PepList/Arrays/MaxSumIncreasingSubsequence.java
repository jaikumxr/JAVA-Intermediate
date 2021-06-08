// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int Arr[] = new int[n];
            for (int i = 0; i < n; i++)
                Arr[i] = sc.nextInt();
            MaxSumIncreasingSubsequence ob = new MaxSumIncreasingSubsequence();
            System.out.println(ob.maxSumIS(Arr, n));
        }
    }
} // } Driver Code Ends

// User function Template for Java

class MaxSumIncreasingSubsequence {
    public int maxSumIS(int arr[], int n) {
        int[] dp = new int[n];
        dp[0] = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j] && dp[j]+arr[i]>dp[i]){
                    dp[i] = dp[j] + arr[i];
                }
            }
            if(dp[i]>maxSum){
                maxSum = dp[i];
            }
        }
        return maxSum;

    }
}
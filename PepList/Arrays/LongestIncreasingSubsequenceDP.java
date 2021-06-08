
// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();
        while (t > 0) {

            // taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];

            // inserting elements in the array
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }

            // creating an object of class Solution
            LongestIncreasingSubsequenceDP ob = new LongestIncreasingSubsequenceDP();

            // calling longestSubsequence() method of class
            // Solution
            System.out.println(ob.longestSubsequence(n, array));
            t--;
        }
    }
} // } Driver Code Ends

class LongestIncreasingSubsequenceDP {

    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[]) {
        int[] dp = new int[size];
        dp[0] = 1;
        int omax= 0;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max+1;
            if(dp[i]>omax){
                omax = dp[i];
            }
        }
        return omax;
    }
}
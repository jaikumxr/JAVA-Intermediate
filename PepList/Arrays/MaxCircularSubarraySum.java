
// { Driver Code Starts
import java.io.*;
import java.util.*;

class MaxCircularSubarraySum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());// input size of array
            int arr[] = new int[n];
            String inputLine2[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
            }

            Solution obj = new Solution();

            System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
        }
    }
}

// } Driver Code Ends

class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        int maxStraightSum = Integer.MIN_VALUE;
        int tempMaxSum = 0;
        int arSum = 0;
        int minStraightSum = Integer.MAX_VALUE;
        int tempMinSum = 0;

        for (int i = 0; i < a.length; i++) {
            arSum += a[i];
            tempMaxSum += a[i];
            if (tempMaxSum > maxStraightSum) {
                maxStraightSum = tempMaxSum;
            }
            if (tempMaxSum < 0) {
                tempMaxSum = 0;
            }

            tempMinSum += a[i];
            if (tempMinSum < minStraightSum) {
                minStraightSum = tempMinSum;
            }
            if (tempMinSum > 0) {
                tempMinSum = 0;
            }
        }

        if(arSum==minStraightSum){
            return maxStraightSum;
        }
        return Integer.max(maxStraightSum, arSum-minStraightSum);
    }

}

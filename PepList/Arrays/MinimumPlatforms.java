// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG5 {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);

            int arr[] = new int[n];
            int dep[] = new int[n];

            str = read.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);

            System.out.println(new MinimumPlatforms().findPlatform(arr, dep, n));
        }
    }

}

// } Driver Code Ends

// User function Template for Java

class MinimumPlatforms {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n) {
        int i = 0;
        int j = 0;
        int plats = 0;
        int max = plats;
        while (i < arr.length && j < arr.length) {
            if (arr[i] <= dep[j]) {
                i++;
                plats++;
            } else {
                j++;
                plats--;
            }
            max = Math.max(max, plats);
        }
        return max;
    }

}

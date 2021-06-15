// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class LongestBitonicSubarray {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Soluchan().bitonic(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Soluchan {
    int bitonic(int[] arr, int n) {
        int max = 0;
        int[] lis = new int[n];
        int[] lds = new int[n];
        lis[0] = 1;
        lds[n - 1] = 1;
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] <= arr[i]) {
                lis[i] = lis[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i + 1] < arr[i]) {
                lds[i] = lis[i + 1] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(lis[i] + lds[i] - 1, max);
        }

        return max;
    }

}
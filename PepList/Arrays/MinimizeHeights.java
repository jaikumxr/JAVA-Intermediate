// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class MinimizeHeights {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new MinimizeHeights2().getMinDiff(arr, n, k);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends

// User function Template for Java

class MinimizeHeights2 {
    int getMinDiff(int[] arr, int n, int k) {
        int[] minArr = new int[n];
        int[] maxArr = new int[n];

        for (int i=0; i<n; i++) {
            minArr[i] = (arr[i]-k)<0 ? arr[i]+k : arr[i]-k;
            maxArr[i] = arr[i]+k;
        }

        Arrays.sort(minArr);
        Arrays.sort(maxArr);

        for (int i : maxArr) {
            System.out.print(i+" ");
        }
        System.out.println();

        for (int i : minArr) {
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println(maxArr[n-1]+" "+minArr[n-1]+" "+maxArr[0]+" "+minArr[0]);

        int maxdiff = Math.min(maxArr[n-1], minArr[n-1]) - Math.max(minArr[0],maxArr[0]);

        return maxdiff;
    }
}

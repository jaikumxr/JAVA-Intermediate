
// { Driver Code Starts
import java.io.*;
import java.util.*;

public class MaxProductSubarray {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solushan().maxProduct(arr, n));
        }
    }
}
// } Driver Code Ends

class Solushan {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        long maxp = arr[0];
        long maxpsf = arr[0];
        long minpsf = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > 0) {
                maxp = Math.max(maxp, Math.max(maxpsf * arr[i], arr[i]));
            } else if (arr[i] < 0) {
                maxp = Math.max(maxp, Math.max(minpsf * arr[i], arr[i]));
            } else {
                maxpsf = 0;
                minpsf = 0;
                // System.out.println(arr[i] + " " + maxp + " " + maxpsf + " " + minpsf);
                continue;
            }
            if (maxpsf == 0 && minpsf == 0) {
                maxpsf = arr[i];
                minpsf = arr[i];
                // System.out.println(arr[i] + " " + maxp + " " + maxpsf + " " + minpsf);
                continue;
            }
            long tempmax = maxpsf;
            maxpsf = Math.max(arr[i], Math.max(maxpsf * arr[i], minpsf * arr[i]));
            minpsf = Math.min(arr[i], Math.min(minpsf * arr[i], tempmax * arr[i]));
            // System.out.println(arr[i] + " " + maxp + " " + maxpsf + " " + minpsf);
        }
        return maxp;
    }
}
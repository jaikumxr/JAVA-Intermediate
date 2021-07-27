// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Hlo3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int A[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(inputLine[i]);
            }

            BuySellStockTwoTransaction obj = new BuySellStockTwoTransaction();
            ArrayList<Integer> ans = obj.solve(A, n);
            if (ans.size() == 0)
                System.out.print("No Profit");
            else {
                System.out.println(A[ans.get(1)] - A[ans.get(0)]);
            }
            System.out.println();
        }
    }
}// } Driver Code Ends

// User function Template for Java

class BuySellStockTwoTransaction {
    // Function to find the days of buying and selling stock for max profit.
    ArrayList<Integer> solve(int A[], int n) {
        ArrayList<Integer> res = new ArrayList<>();

        int cmin = 0;
        int cmax = 0;
        int maxp = Integer.MIN_VALUE;
        int tmax = 0;
        int tmin = 0;

        for (int i = 1; i < n; i++) {
            if (A[i] < A[cmin]) {
                cmin = i;
            } else if (A[i] > A[cmax]) {
                cmax = i;
                if (A[cmax] - A[cmin] > maxp) {
                    tmax = cmax;
                    tmin = cmin;
                    maxp = A[tmax] - A[tmin];
                }
            }
        }

        res.add(tmin);
        res.add(tmax);

        return res;
    }
}

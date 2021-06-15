// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Hlo {
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
            int p = 0;
            for (int i = 0; i < n - 1; i++)
                p += Math.max(0, A[i + 1] - A[i]);

            StockBuySell obj = new StockBuySell();
            ArrayList<ArrayList<Integer>> ans = obj.stockBuySell(A, n);
            if (ans.size() == 0)
                System.out.print("No Profit");
            else {
                int c = 0;
                for (int i = 0; i < ans.size(); i++)
                    c += A[ans.get(i).get(1)] - A[ans.get(i).get(0)];

                if (c == p)
                    System.out.print(1);
                else
                    System.out.print(0);
            }
            System.out.println();
        }
    }
}// } Driver Code Ends

// User function Template for Java

class StockBuySell {
    // Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        int lmin = 0; //local minima
        int lmax = 0; //local maxima
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (A[i] >= A[lmax]) {
                //continue if current element greater than A[lmax] and change lmax to i
                lmax = i;
            } else {
                //if i=1 then no need to add arraylist since first element was greater than second - base case
                if(i>1 && A[lmax]>A[lmin]){
                    ArrayList<Integer> ar = new ArrayList<>();
                    ar.add(lmin);
                    ar.add(lmax);
                    res.add(ar);
                }
                lmax = i;
                lmin = i;
            }
        }
        //base case: if final element is a local maxima, add new list to res.
        if(lmax==n-1){
            ArrayList<Integer> ar = new ArrayList<>();
            ar.add(lmin);
            ar.add(lmax);
            res.add(ar);
        }

        //just for checking the lists inside res.

        for (ArrayList<Integer> ar : res) {
            System.out.println(ar.get(0)+" "+ar.get(1));
        }

        return res;
    }
}

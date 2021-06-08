// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            ArrayList<Long> arr = new ArrayList<Long>();
            for (int i = 0; i < n; i++) {
                long x = sc.nextInt();
                arr.add(x);
            }
            long m = sc.nextLong();

            ChocolateProblem ob = new ChocolateProblem();

            System.out.println(ob.findMinDiff(arr, n, m));
        }

    }
}// } Driver Code Ends

// User function Template for Java

class ChocolateProblem {
    public long findMinDiff(ArrayList<Long> a, long n, long m) {
        Collections.sort(a);
        int i = 0;
        int j = (int) m-1;
        long min = Long.MAX_VALUE;
        while(j!=n){
            if(a.get(j)-a.get(i)<min){
                min = a.get(j)-a.get(i);
            }
        }
        return min;
    }
}
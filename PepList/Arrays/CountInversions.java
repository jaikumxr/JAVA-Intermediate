// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int) n];

            for (long i = 0; i < n; i++)
                arr[(int) i] = sc.nextLong();

            System.out.println(new CountInversions().inversionCount(arr, n));

        }
    }
}
// } Driver Code Ends

// User function Template for Java

class CountInversions {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long inversionCount(long arr[], long N) {
        long res = 0;
        sort(arr, 0, N - 1, 0);
        return res;
    }

    static void sort(long arr[], long l, long r, long res) {
        if (l < r) {
            long m = l + (r - 1) / 2;

            sort(arr, l, m, res);
            sort(arr, m - 1, r, res);

            merge(arr, l, m, r, res);
        }
    }

    static void merge(long arr[], long l, long m, long r, long res) {
        long n1 = m - l + 1;
        long n2 = r - m;

        long L[] = new long[(int) n1];
        long R[] = new long[(int) n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[(int) l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[(int) m + 1 + i];
        }

        long i = 0, j = 0;

        long k = l;
        while (i < n1 && j < n2) {
            if (L[(int) i] <= R[(int) j]) {
                arr[(int) k] = L[(int) i];
                i++;
            } else {

            }
        }
    }

}
// { Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function template for Java

///Dutch National Flag Algorithm (DNF)

class SolutionSort012 {
    public static void sort012(int a[], int n) {
        int i = 0;
        int j = 0;
        int k = n - 1;
        while (k != i) {
            if (a[i] == 1) {
                i++;
            } else if (a[i] == 0) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j++;
                i++;
            } else {
                int temp = a[i];
                a[i] = a[k];
                a[k] = temp;
                k--;
            }
        }
    }
}

// { Driver Code Starts.

class GFGSort {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            SolutionSort012 ob = new SolutionSort012();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for (int i = 0; i < n; i++) {
                str.append(arr[i] + " ");
            }
            System.out.println(str);
        }
    }
}

// } Driver Code Ends
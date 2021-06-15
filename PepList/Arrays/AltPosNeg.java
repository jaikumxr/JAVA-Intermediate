// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class AltPosNeg {

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

            new Solution1().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java

// Given an unsorted array Arr of N positive and negative numbers. Your task is
// to create an
// array of alternate positive and negative numbers without changing the
// relative
// order of positive and negative numbers.

//Time O(n) and Space O(n) allowed

class Solution1 {
    void rearrange(int arr[], int n) {
        ArrayDeque<Integer> pos = new ArrayDeque<>();
        ArrayDeque<Integer> neg = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                pos.add(arr[i]);
            } else {
                neg.add(arr[i]);
            }
        }
        boolean flag = true;
        int i = 0;
        while (i < n && pos.size() > 0 && neg.size() > 0) {
            if (flag) {
                arr[i] = pos.remove();
            } else {
                arr[i] = neg.remove();
            }
            i++;
            flag = !flag;
        }
        while (pos.size() > 0) {
            arr[i] = pos.remove();
            i++;
        }
        while (neg.size() > 0) {
            arr[i] = neg.remove();
            i++;
        }
    }
}
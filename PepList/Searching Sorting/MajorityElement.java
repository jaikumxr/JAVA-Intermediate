// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.println(MajorityElement.majorityElement(arr, n));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class MajorityElement {
    static int majorityElement(int a[], int size) {
        int res = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if(!hm.containsKey(a[i])){
                hm.put(a[i], 1);
                res = Math.max(res, 1);
            } else {
                hm.replace(a[i], hm.get(a[i])+1);
                res = Math.max(res, hm.get(a[i]));
            }
        }

        if(res>=size/2){
            return res;
        }
        return -1;
    }
}
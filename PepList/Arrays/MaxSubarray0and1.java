
// { Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.util.HashMap;

class Largest_Subarray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++)
                a[i] = sc.nextInt();

            MaxSubarray0and1 g = new MaxSubarray0and1();
            int n = g.maxLen(a, a.length);

            System.out.println(n);

            T--;
        }
    }
}
// } Driver Code Ends

class MaxSubarray0and1 {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array

    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] arr, int N) {
        int max = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int csum = 0;
        if (arr[0] == 0) {
            hm.put(-1, 0);
            csum--;
        } else {
            hm.put(1, 0);
            csum++;
        }
        for (int i = 1; i < N; i++) {
            if (arr[i] == 0) {
                csum--;
                if (hm.containsKey(csum)) {
                    max = Math.max(i - hm.get(csum), max);
                    continue;
                }
                hm.put(csum, i);
            } else {
                csum++;
                if (hm.containsKey(csum)) {
                    max = Math.max(i - hm.get(csum), max);
                    continue;
                }
                hm.put(csum, i);
            }
        }
        return max;
    }
}

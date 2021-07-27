import java.io.*;
import java.util.*;

public class SubsetProduct {

    public static int solve(int[] arr, int n) {
        int res = 0;
        int[] primes = new int[31];
        int[] headcount = new int[31];
        for (int i = 0; i < headcount.length; i++) {
            
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] sarr = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sarr[i]);
        }
        System.out.println(solve(arr, n));
    }
}

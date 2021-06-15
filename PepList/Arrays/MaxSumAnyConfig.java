
// { Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.println(new MaxSumAnyConfig().max_sum(arr, n));

            t--;
        }
    }

}
// } Driver Code Ends

class MaxSumAnyConfig {
    int max_sum(int A[], int n) {
        int maxsum = 0;
        int arsum = 0;
        for (int i = 0; i < n; i++) {
            maxsum += i * A[i];
            arsum += A[i];
        }
        int csum = maxsum;
        for (int i = n - 1; i >= 0; i--) {
            csum = csum + arsum - n * A[i];
            maxsum = Math.max(csum, maxsum);
        }
        return maxsum;
    }
}

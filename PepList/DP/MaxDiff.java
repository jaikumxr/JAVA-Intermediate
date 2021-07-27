
// { Driver Code Starts
import java.util.*;

class GFGp {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            MaxDiff ob = new MaxDiff();
            System.out.println(ob.findMaxDiff(a, n));
            t--;
        }
    }
}// } Driver Code Ends

class MaxDiff {
    int findMaxDiff(int a[], int n) {
        int maxdif = Integer.MIN_VALUE;
        int lmin = a[0];
        for (int i = 1; i < n; i++) {
            if(a[i]<lmin){
                lmin = a[i];
            } else {
                maxdif = Math.max(a[i]-lmin, maxdif);
            }
        }
        return maxdif; 
    }
}
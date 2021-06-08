
// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }

            SubarrayWithGivenSum obj = new SubarrayWithGivenSum();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for (int ii = 0; ii < res.size(); ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends

class SubarrayWithGivenSum {
    // Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> res = new ArrayList<>();
        int l = 0;
        int r = 0;
        int sum = arr[0];

        while(l!=arr.length-1){
            if(sum<s){
                r++;
                sum+=arr[r];
            } else if(sum>s) {
                sum-=arr[l];
                l++;  
            }
            if (sum==s){
                res.add(l+1); //as program requires the natural number index i.e. 1,2,3, etc
                res.add(r+1);
                return res;
            }
        }

        res.add(-1);
        return res;
    }
}
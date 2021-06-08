
// { Driver Code Starts
import java.io.*;
import java.util.*;

class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            // taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            EquilibriumPoint ob = new EquilibriumPoint();

            // calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}// } Driver Code Ends

// Equilibrium point is when the sum of elements before the point is equal to
// the sum of elements after it

class EquilibriumPoint {

    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {
        long rsum = getSum(arr);
        long lsum = 0;
        for (int i = 0; i < arr.length; i++) {
            rsum-=arr[i];
            if(rsum==lsum){
                return i;
            } else {
                lsum+=arr[i];
            }
        }
        return -1;
    }

    public static long getSum(long arr[]) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}

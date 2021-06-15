
// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class Hello {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            // size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            TrappingRainWater obj = new TrappingRainWater();

            // calling trappingWater() function
            System.out.println(obj.trappingWater(arr, n));
        }
    }
}

// } Driver Code Ends

class TrappingRainWater {

    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static int trappingWater(int arr[], int n) {
        int[] mleft = new int[n];
        int[] mright = new int[n];
        int maxleft = arr[0];
        int maxright = arr[n-1];
        mleft[0] = 0;
        mright[n-1] = 0;
        for (int i = 1; i < mleft.length; i++) {
            mleft[i] = maxleft;
            maxleft = Math.max(maxleft, arr[i]);
        }
        for (int i = n-2; i >= 0; i--) {
            mright[i] = maxright;
            maxright = Math.max(maxright, arr[i]);
        }

        int water = 0;
        for (int i = 1; i < mright.length-1; i++) {
            if(arr[i]<Math.min(mleft[i], mright[i])){
                water+=(Math.min(mleft[i], mright[i])-arr[i]);
            }
        }

        return water;
    }
}

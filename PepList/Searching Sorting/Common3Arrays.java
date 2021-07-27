// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();
        while (t-- > 0) {
            // taking total count-1 of elements
            int n = sc.nextInt();

            // Declaring and Initializing an ArrayList-1
            ArrayList<Integer> v1 = new ArrayList<>();

            // adding elements to the ArrayList-1
            for (int i = 0; i < n; i++) {
                v1.add(sc.nextInt());
            }

            // taking total count-2 of elements
            int m = sc.nextInt();

            // Declaring and Initializing an ArrayList-2
            ArrayList<Integer> v2 = new ArrayList<>();

            // adding elements to the ArrayList-2
            for (int i = 0; i < m; i++) {
                v2.add(sc.nextInt());
            }
            Common3Arrays ob = new Common3Arrays();
            // calling the method common_element
            // and passing ArrayList 1, 2 as arguments
            // and storing the results in a new ArrayList
            ArrayList<Integer> ans = ob.common_element(v1, v2);

            // printing the elements of the new ArrayList
            for (int i : ans)
                System.out.print(i + " ");

            System.out.println();
        }
    }
}// } Driver Code Ends

// User function Template for Java

// In pepcoding's list, it shows 3 arrays but the question on GFG is only of 2
// arrays. Regardless,
// I am using the same two pointer approach.

class Common3Arrays {
    public static ArrayList<Integer> common_element(ArrayList<Integer> v1, ArrayList<Integer> v2) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        Collections.sort(v1);
        Collections.sort(v2);
        while (i < v1.size() && j < v2.size()) {
            if (v1.get(i) == v2.get(j)) {
                res.add(v1.get(i));
                i++;
                j++;
            } else if (v1.get(i) > v2.get(j)) {
                j++;
            } else {
                i++;
            }
        }
        return res;
    }
}
// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> res = ob.generate_binary_string(s);
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution {

    public void solve(ArrayList<String> res, String s, int idx){
        for (int i = idx; i < s.length(); i++) {
            if(s.charAt(i)=='?'){
                String s1 = s.substring(0, i)+'0'+s.substring(i+1, s.length());
                System.out.println(s1);
                solve(res, s1, i+1);
                String s2 = s.substring(0, i)+'1'+s.substring(i+1, s.length());
                System.out.println(s2);
                solve(res, s2, i+1);
                return;
            }
        }
        res.add(s);
    }

    public ArrayList<String> generate_binary_string(String s) {
        ArrayList<String> res = new ArrayList<>();
        solve(res, s, 0);
        return res;
    }
}
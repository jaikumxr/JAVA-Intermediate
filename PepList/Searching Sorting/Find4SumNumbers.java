// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Find4SumNumbers sln = new Find4SumNumbers();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}// } Driver Code Ends

// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Pair {
    int p;
    int q;

    public Pair(int p, int q) {
        this.p = p;
        this.q = q;
    }
}

class Find4SumNumbers {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);

        HashMap<Integer, ArrayList<Pair>> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (hm.containsKey(arr[i] + arr[j])) {
                    for (Pair pr : hm.get(arr[i] + arr[j])) {
                        if(arr[i]==arr[pr.p] || arr[i]==arr[pr.q]){
                            continue;
                        }
                    }
                    ArrayList<Pair> ar = hm.get(arr[i] + arr[j]);
                    ar.add(new Pair(i, j));
                    hm.replace(arr[i] + arr[j], ar);
                }
                ArrayList<Pair> ar = new ArrayList<>();
                ar.add(new Pair(i, j));
                hm.put(arr[i] + arr[j], ar);
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (hm.containsKey(k - sum)) {

                    ArrayList<Pair> ar = hm.get(k - sum);

                    for (Pair pair : ar) {
                        if (pair.p == i || pair.p == j || pair.q == i || pair.q == j) {
                            continue;
                        }
                        ArrayList<Integer> toAdd = new ArrayList<>();
                        toAdd.add(arr[pair.p]);
                        toAdd.add(arr[pair.q]);
                        toAdd.add(arr[i]);
                        toAdd.add(arr[j]);
                        Collections.sort(toAdd);
                        res.add(toAdd);
                    }
                }
            }
        }

        return res;
    }
}
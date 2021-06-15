import java.io.*;
import java.util.*;

public class KPairsSmallestSum {

    public static class Pair implements Comparable<Pair> {
        int idx1;
        int idx2;
        int sum;

        Pair(int idx1, int idx2, int sum) {
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.sum = sum;
        }

        public int compareTo(Pair o) {
            return this.sum - o.sum;
        }
    }

    public static ArrayList<ArrayList<Integer>> kPairs(int[] arr1, int n1, int[] arr2, int n2, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(k>n1*n2){
            System.out.println("K pairs don't exist");
            return res;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, arr1[0]+arr2[0]));
        while(pq.size()>0 && k>0){
            Pair rem = pq.remove();
            ArrayList<Integer> ar = new ArrayList<>();
            ar.add(rem.idx1);
            ar.add(rem.idx2);
            res.add(ar);
            if(rem.idx1<n1-1){
                pq.add(new Pair(rem.idx1+1, rem.idx2, arr1[rem.idx1+1]+arr2[rem.idx2]));
            }
            if(rem.idx2<n2-1){
                pq.add(new Pair(rem.idx1, rem.idx2+1, arr1[rem.idx1]+arr2[rem.idx2+1]));
            }
            k--;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());
        int ar1[] = new int[n1];
        int ar2[] = new int[n2];
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < n1; i++) {
            ar1[i] = Integer.parseInt(s1[i]);
        }
        for (int i = 0; i < n2; i++) {
            ar2[i] = Integer.parseInt(s2[i]);
        }
        int k = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> ans = kPairs(ar1, n1, ar2, n2, k);
        for (ArrayList<Integer> list : ans) {
            System.out.println(ar1[list.get(0)] + " " + ar2[list.get(1)]);
        }

    }

}
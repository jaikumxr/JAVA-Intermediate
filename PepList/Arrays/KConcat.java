import java.io.*;
import java.util.*;
import java.lang.*;

public class KConcat {

    public static class Pair {
        ArrayList<Integer> list;
        int k;

        Pair(ArrayList<Integer> list, int k) {
            this.list = list;
            this.k = k;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        ArrayList<Pair> lists = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            String[] elements = br.readLine().split(" ");
            int k = Integer.parseInt(elements[1]);
            String[] lst = br.readLine().split(" ");
            for (int j = 0; j < lst.length; j++) {
                list.add(Integer.parseInt(lst[j]));
            }

            lists.add(new Pair(list, k));
        }
        for (Pair p : lists) {
            int sum = arSum(p.list);
            int n = p.list.size();
            if(p.k==1){
                System.out.println(kadaneAlgo(p.list));
                continue;
            }
            if(sum<=0){
                for (int i = 0; i < n; i++) {
                    p.list.add(p.list.get(i));
                }
                System.out.println(kadaneAlgo(p.list));
            } else {
                int res = sum*(p.k-2);
                for (int i = 0; i < n; i++) {
                    p.list.add(p.list.get(i));
                }
                System.out.println(kadaneAlgo(p.list)+res);
            }
        }
    }

    public static int arSum(ArrayList<Integer> a) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i);
        }
        return sum;
    }

    public static int kadaneAlgo(ArrayList<Integer> a) {
        int msum = 0;
        int csum = 0;

        for (int i = 0; i < a.size(); i++) {
            csum = csum + a.get(i);
            if (csum > msum) {
                msum = csum;
            }
            if (csum < 0) {
                csum = 0;
            }
        }

        return msum;
    }
}
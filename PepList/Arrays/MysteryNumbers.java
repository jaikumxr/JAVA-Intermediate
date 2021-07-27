import java.io.*;
import java.util.*;

public class MysteryNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int S = Integer.parseInt(line[1]);
            String M = br.readLine();

            int out_ = maximumCount(N, S, M);
            System.out.println(out_);
        }
    }

    static int maximumCount(int N, int S, String M) {
        int res = Integer.MAX_VALUE;
        int twos = 0;
        int sixes = 0;
        int[] count = new int[10];

        String nstr = Integer.toString(N);

        char[] mArr = M.toCharArray();
        for (int i = 0; i < S; i++) {
            count[(int) M.charAt(i) - 48] += 1;
        }

        count[5] += count[2];
        count[2] = count[5];
        count[6] += count[9];
        count[9] = count[6];



        for (int i = 0; i < nstr.length(); i++) {

        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}



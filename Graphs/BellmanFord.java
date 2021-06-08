import java.io.*;
import java.util.*;

public class BellmanFord {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[][] graph = new int[m][3];

        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            graph[i][0] = Integer.parseInt(st[0]) - 1;
            graph[i][1] = Integer.parseInt(st[1]) - 1;
            graph[i][2] = Integer.parseInt(st[2]);
        }
        
        int[] path = new int[n];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[0] = 0;
        
        for (int i = 0; i < n-1; i++) {
            for (int j = 1; j < m; j++) {
                int u = graph[j][0];
                int v = graph[j][1];
                int wt = graph[j][2];

                if(path[0]==Integer.MAX_VALUE){
                    continue;
                }

                if(path[u]+wt < path[v]){
                    path[v] = path[u]+wt;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if(path[i]!=Integer.MAX_VALUE){
                System.out.print(path[i]+" ");
            } else {
                System.out.print("1000000000 ");
            }
        }


    }
}

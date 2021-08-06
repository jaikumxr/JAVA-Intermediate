import java.util.*;
import java.io.*;

public class HackerEarth {

    public static int segment(int x, List<Integer> space){
        if(space.size()==1){
            return space.get(0);
        }
        int res = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i<x; i++){
            mini = Math.min(mini, space.get(i));
            q.add(space.get(i));
        }
        res = mini;
        for(int i = x; i<space.size(); i++){
            q.add(space.get(i));
            int rem = q.remove();
            if(rem == mini){
                ArrayDeque<Integer> q2 = new ArrayDeque<>();
                int mini2  = Integer.MAX_VALUE;
                while(q.size()>0){
                    int rem2=  q.remove();
                    mini2 = Math.min(mini2, rem2);
                    q2.add(rem2);
                }
                mini = mini2;
                res = Math.max(res, mini);
                q = q2;
            } else {
                mini = Math.min(mini, space.get(i));
                res = Math.max(res, mini);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        
    }
}

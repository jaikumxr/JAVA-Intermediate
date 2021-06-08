import java.io.*;
import java.util.*;

public class BunnyWorkers {
    public static String solution(long x, long y) {
        long initial = calInitial(x+y);
        initial+=x-1;
        return initial+"";
    }

    public static long calInitial(long sum){
        long res = 1;
        long p = 1;
        for (long i = 1; i < sum-1; i++) {
            res+= p;
            p++;
        }
        return res;
    }

}

import java.util.*;
import java.io.*;

public class Door {

//Juspay intern interview ques

    public static ArrayList<Integer> solve(int n){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 1; i*i<=n; i++){
            res.add(i*i);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> ans = solve(n);
        for(int i : ans){
            System.out.print(i+ " ");
        }
    }
}
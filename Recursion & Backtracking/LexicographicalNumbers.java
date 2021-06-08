import java.io.*;
import java.util.*;

public class LexicographicalNumbers {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            lexi(i, n);
        }

	}

    public static void lexi(int i , int n) {
        if(i>n){
            return;
        }
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            lexi(j, n);
        }
    }
	
}
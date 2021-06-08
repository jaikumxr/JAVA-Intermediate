import java.io.*;
import java.util.*;

public class JosephusProblem {

	public static int solution(int n, int k) {
	    if(n==1){
	        return 0;
	    }
	    int sofnm1 = solution(n-1, k);
		int ans = (sofnm1+k)%n;
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		System.out.println(solution(n, k));
	}

}
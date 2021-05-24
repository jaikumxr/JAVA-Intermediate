import java.io.*;
import java.util.*;

public class AbbreviationBacktracking {

    public static void solution(String str, String asf,int count, int pos){
        if(pos==str.length()){
            if(count==0){
                System.out.println(asf);
            } else {
                System.out.println(asf+count);
            }
            return;
        } 
        solution(str, asf+count+str.charAt(pos), 0, pos+1);
        solution(str, asf, count++, pos+1);

    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str,"",0,0);
    }
    
    
}
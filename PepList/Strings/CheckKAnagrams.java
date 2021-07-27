
// { Driver Code Starts
import java.util.*;
import java.lang.*;

class CheckKAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();
            int k = sc.nextInt();
            GfG g = new GfG();
            if (g.areKAnagrams(str1, str2, k) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends

/* Complete the function below */
class GfGxd {
    boolean areKAnagrams(String s1, String s2, int k) {
        boolean res = true;
        HashMap<Character, Integer> h1 = new HashMap<>();
        HashMap<Character, Integer> h2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if(h1.containsKey(ch)){
                h1.put(ch, h1.get(ch)+1);
            } else {
                h1.put(ch, 1);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if(h2.containsKey(ch)){
                h2.put(ch, h2.get(ch)+1);
            } else {
                h2.put(ch, 1);
            }
        }

        return res;
    }
}
public class Salute {
    public static int solution(String s) {
        int right = 0;
        int count = 0;
        for (int i = 0; i < s.length() ;i++) {
            if(s.charAt(i)=='>'){
                right++;
            } else if(s.charAt(i)=='<'){
                count+=right*2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution("<<>><"));
    }
}
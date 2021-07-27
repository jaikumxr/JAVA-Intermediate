import java.util.HashMap;

public class FirstSol {

    int solution(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) {
                continue;
            }
            if (hm.containsKey(arr[i])) {
                hm.replace(arr[i], hm.get(arr[i]) + i);
            } else {
                hm.put(arr[i], i);
            }
        }

        int node = -1;
        int weight = 0;
        for (int i : hm.keySet()) {
            if(hm.get(i)>weight){
                node = i;
                weight = hm.get(i);
            }
        }
        return node;
    }

    public static void main(String[] args) {

    }
}

import java.io.*;
import java.util.*;

public class LargestSumCycle {


    public static int solution(int arr[])
    {
        ArrayList<Integer> sum = new ArrayList<>();
        for(int i = 0; i < arr.length; i ++)
        {
            ArrayList<Integer> path = new ArrayList<>();    
            int j = i;
            int tempSum = 0;
            while(arr[j]<arr.length && arr[j]!=i && arr[j]!=-1 && !path.contains(j))
            {   
                path.add(j);
                tempSum+=j;
                j=arr[j];
                if(arr[j]==i)
                {
                    tempSum+=j;
                    break;
                }
            }
            if(j<arr.length && i == arr[j])
                sum.add(tempSum);
        }
            if(sum.isEmpty())
                return -1;
            return Collections.max(sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] stArr = br.readLine().split(" ");
        int[] arr = new int[stArr.length];
        for (int i = 0; i < stArr.length; i++) {
            arr[i] = Integer.parseInt(stArr[i]);
        }
        System.out.println(solution(arr));
    }
}

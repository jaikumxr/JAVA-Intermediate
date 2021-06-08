import java.io.*;
import java.util.*;

public class GoldMine2 {
	static int max = 0;

    public static int travelAndCollect(int[][] arr, int i, int j) {
        if(j<0 || i<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==0){
            return 0;
        }
        int gold = arr[i][j];
        arr[i][j] = 0;
        gold += travelAndCollect(arr, i+1, j);
        gold += travelAndCollect(arr, i-1, j);
        gold += travelAndCollect(arr, i, j+1);
        gold += travelAndCollect(arr, i, j-1);
        return gold;
    }

	public static void getMaxGold(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int gold = travelAndCollect(arr, i, j);
                if(gold>max){
                    max = gold;
                }
            }
        }
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		getMaxGold(arr);
		System.out.println(max);
	}
		
}
import java.io.*;
import java.util.*;

//Program to solve N QUeens problem using Backtracking - Branch and Bound algorithm

public class NQueens {

    public static void solve(boolean[][] board, int row, boolean[] cols, boolean[] nd, boolean[]rd, String asf) {

        if(row==board.length){
            System.out.println(asf+".");
        }
        
        for (int i = 0; i < board.length; i++) {
            if(cols[i]==false && nd[row+i]==false && rd[row-i+board.length-1]==false){
                nd[row+i] = true;
                board[row][i] = true;
                rd[row-i+board.length-1] = true;
                cols[i] = true;
                solve(board, row+1, cols, nd, rd , asf+row+"-"+i+", " );
                nd[row+i] = false;
                board[row][i] = false;
                rd[row-i+board.length-1] = false;
                cols[i] = false;
            }
        }
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        boolean[][] board = new boolean[n][n];
        boolean[] cols = new boolean[n];
        boolean[] nd = new boolean[2 * n - 1];
        boolean[] rd = new boolean[2 * n - 1];

        solve(board, 0, cols, nd, rd, "");



    }
    
    
}
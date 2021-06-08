import java.io.*;
import java.util.*;

public class Sudoku {
    public static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static Boolean isValid(int[][] board, int i, int j, int k) {
        Boolean res = false;
        int ifloor = i/3;
        int jfloor = j/3;
        int i1 = ifloor*3;
        int j1 = jfloor*3;
        for (int l = 0; l < board.length; l++) {
            if(board[i][l]==k){
                return false;
            }
            if(board[l][j]==k){
                return false;
            }
        }

        for (int l = 0; l < 3; l++) {
            for (int ll = 0; ll < 3; ll++) {
                if(board[l+i1][ll+j1]==k){
                    return false;
                }
            }
        }

        return true;
    }

    public static void solveSudoku(int[][] board, int i, int j) {
        int nj = 0;
        int ni = 0;

        if(j == 8){
            ni = i+1;
            nj = 0;
        } else {
            ni = i;
            nj = j+1;
        }
        if(i==9){
            display(board);
            return;
        }

        if(board[i][j]==0){
            for (int z = 1; z <= 9; z++) {
                if(isValid(board, i, j, z)==true){
                    board[i][j] = z;
                    solveSudoku(board, ni, nj);
                    board[i][j] = 0;
                }
            }
        } else {
            solveSudoku(board, ni, nj);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        solveSudoku(arr, 0, 0);
    }
}

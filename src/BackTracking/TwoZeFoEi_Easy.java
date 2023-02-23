package BackTracking;

import java.io.*;
import java.util.*;

public class TwoZeFoEi_Easy {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] board;
    static int max_value = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j++)
                max_value = Math.max(max_value, board[i][j] = Integer.parseInt(st.nextToken()));
        }

        Board_Move(0, board);

        bw.write(Integer.toString(max_value));
        bw.flush();
        bw.close();

    }
    static void Board_Move(int count, int[][] board){
        if(count == 5)
            return;

        int [][] temp = new int[n][n];
        if(Up_Down(temp, board))
            Board_Move(count + 1, temp);
        temp = new int[n][n];
        if(Up_Down(temp, Reverse(board)))
            Board_Move(count + 1, Reverse(temp));

        temp = new int[n][n];
        if(Left_Right( temp, board))
            Board_Move(count + 1, temp);
        temp = new int[n][n];
        if(Left_Right(temp, Reverse(board)))
            Board_Move(count + 1,   Reverse(temp));

    }
    static int[][] Reverse(int[][] temp){
        int[][] rtemp = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                rtemp[i][j] = temp[n - 1 - i][n - 1 - j];

        return rtemp;

    }
    static boolean Up_Down( int[][] temp, int[][] board){
        boolean did_change = false;
        boolean[] used;
        int count;
        for (int i = 0 ; i< n ; i++){
            count = 0;
            used = new boolean[n];
            for (int j = 0 ; j < n ; j++) {
                if(board[j][i] != 0){
                    if(count > 0 && !used[count - 1] && temp[count - 1][i] == board[j][i]) {
                        max_value = Math.max(max_value, temp[count - 1][i] *= 2);
                        used[count - 1] = true;
                        did_change = true;
                    }
                    else {
                        if(j != count)
                            did_change = true;
                        temp[count++][i] = board[j][i];
                    }
                }
            }
        }

        return did_change;

    }
    static boolean Left_Right( int[][] temp, int[][] board){
        boolean did_change = false;
        boolean[] used;
        int count;
        for (int i = 0 ; i< n ; i++){
            count = 0;
            used = new boolean[n];
            for (int j = 0 ; j < n ; j++) {
                if(board[i][j] != 0){
                    if(count > 0 && !used[count - 1] && temp[i][count - 1] == board[i][j]) {
                        max_value = Math.max(max_value, temp[i][count - 1] *= 2);
                        did_change = true;
                        used[count - 1] = true;
                    }
                    else {
                        if(j != count)
                            did_change = true;
                        temp[i][count++] = board[i][j];
                    }
                }
            }
        }

        return did_change;
    }


}
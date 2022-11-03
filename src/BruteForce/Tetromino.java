package BruteForce;

import java.io.*;
import java.util.*;

public class Tetromino {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static String[][] table;
    static boolean[][] visited;
    static int n, m;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        table = new String[n][];
        visited = new boolean[n][m];
        int result = 0;

        for (int i = 0 ; i < n; i ++)
            table[i] = br.readLine().split(" ");

        for (int i = 0 ; i < n ; i ++){
            for (int j = 0 ;j < m ; j ++) {
                result = Math.max(result, Mfinger(i, j));
                result = Math.max(result, Tetro(i, j, 0));
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }

    static int Tetro(int i, int j, int depth){
        int result = 0;
        if(visited[i][j])
            return 0;
        if(depth == 3)
            return Integer.parseInt(table[i][j]);
        else{
            visited[i][j] = true;
            if(i > 0)
                result = Math.max(result, Tetro(i - 1, j, depth + 1));
            if(i < n - 1)
                result = Math.max(result, Tetro(i + 1, j, depth + 1));
            if(j > 0)
                result = Math.max(result, Tetro(i, j -1, depth + 1));
            if(j < m - 1)
                result = Math.max(result, Tetro(i, j +1, depth + 1));
            visited[i][j] = false;

            return result + Integer.parseInt(table[i][j]);
        }
    }
    static int Mfinger(int i, int j){
        int a = 0, b = 0 , c = 0, d = 0;
        if(i > 0)
            a = Integer.parseInt(table[i - 1][j]);
        if(i < n - 1)
            b = Integer.parseInt(table[i + 1][j]);
        if(j > 0)
            c = Integer.parseInt(table[i][j - 1]);
        if(j < m - 1)
            d = Integer.parseInt(table[i][j + 1]);

        return Integer.parseInt(table[i][j]) + Math.max(Math.max((a + b + c), (a + b + d)), Math.max((b + c + d), (a + c + d)));
    }

}




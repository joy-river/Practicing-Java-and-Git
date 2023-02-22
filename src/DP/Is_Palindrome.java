package DP;

import java.io.*;
import java.util.*;

public class Is_Palindrome {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] input;
    static int [][] memo;
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        input = new int[n + 1];
        memo = new int[n + 1][n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n ; i++)
            input[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            bw.write((Is_Pal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) == -1 ? "0" : "1")  + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int Is_Pal(int i , int j){
        if(i >= j)
            return 1;

        if(memo[i][j] == 0) {
            if (input[i] == input[j])
                return memo[i][j] = Is_Pal(i + 1, j - 1);
            else
                return memo[i][j] = -1;
        }
        else
            return memo[i][j];
    }

}

package DP;

import java.io.*;
import java.util.*;

public class Matrix_Multiply_Order {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int [][] dp;
    static int [] Matrix;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][n + 1];
        Matrix = new int[n + 1];
        for (int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            Matrix[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0 ; i <= n ; i ++)
            for (int j = 0; j <= n ; j++)
                dp[i][j] = Integer.MAX_VALUE;

        Matrix[n] = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(Mult_Order(0, n)));

        bw.flush();
        bw.close();
    }
    static int Mult_Order(int i , int j){
        if(dp[i][j] < Integer.MAX_VALUE)
            return dp[i][j];
        else{
            if(j - i == 2)
                return dp[i][j] = Matrix[i] * Matrix[i + 1] * Matrix[j];
            else if (j - i < 2)
                return dp[i][j] = 0;
            else {
                for (int s = 1; s < j - i ; s++)
                    dp[i][j] = Math.min(dp[i][j] , Mult_Order(i, i + s) + Mult_Order(i + s , j) + Matrix[i] * Matrix[i + s] * Matrix[j]);
                return dp[i][j];
            }
        }
    }


}
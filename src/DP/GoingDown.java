package DP;

import java.io.*;
import java.util.*;

public class GoingDown {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int max, min;
        String [][] input = new String[n][];
        int [][][] dp = new int[n + 1][3][2];

        for (int i = n - 1 ; i >= 0 ; i--)
            input[i] = br.readLine().split(" ");

        Arrays.fill(dp[0][0],Integer.parseInt(input[0][0]));
        Arrays.fill(dp[0][1],Integer.parseInt(input[0][1]));
        Arrays.fill(dp[0][2],Integer.parseInt(input[0][2]));

        for (int i = 1; i < n; i++){
            dp[i][0][0] = Integer.parseInt(input[i][0]) + Math.max(dp[i - 1][0][0], dp[i - 1][1][0]);
            dp[i][1][0] = Integer.parseInt(input[i][1]) + Math.max(dp[i - 1][2][0], Math.max(dp[i - 1][0][0], dp[i - 1][1][0]));
            dp[i][2][0] = Integer.parseInt(input[i][2]) + Math.max(dp[i - 1][1][0], dp[i - 1][2][0]);
            dp[i][0][1] = Integer.parseInt(input[i][0]) + Math.min(dp[i - 1][0][1], dp[i - 1][1][1]);
            dp[i][1][1] = Integer.parseInt(input[i][1]) + Math.min(dp[i - 1][2][1], Math.min(dp[i - 1][0][1], dp[i - 1][1][1]));
            dp[i][2][1] = Integer.parseInt(input[i][2]) + Math.min(dp[i - 1][1][1], dp[i - 1][2][1]);
        }
        max = Math.max(dp[n - 1][2][0], Math.max(dp[n - 1][0][0], dp[n - 1][1][0]));
        min = Math.min(dp[n - 1][2][1], Math.min(dp[n - 1][0][1], dp[n - 1][1][1]));

        bw.write(max + " " + min);
        bw.flush();
        bw.close();
    }

}








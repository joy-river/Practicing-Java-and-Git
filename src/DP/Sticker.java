package DP;

import java.io.*;

public class Sticker {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        String[][] sticker = new String[2][];


        for (int i = 0 ; i < t; i ++){

            int n = Integer.parseInt(br.readLine());
            int [][] dp = new int[2][n + 1];
            sticker[0] = br.readLine().split(" ");
            sticker[1] = br.readLine().split(" ");

            dp[0][0] = Integer.parseInt(sticker[0][0]);
            dp[1][0] = Integer.parseInt(sticker[1][0]);

            if(n > 1) {
                dp[0][1] = Integer.parseInt(sticker[0][1]) + dp[1][0];
                dp[1][1] = Integer.parseInt(sticker[1][1]) + dp[0][0];

                for (int j = 2; j < n; j++) {
                    dp[0][j] = Math.max(dp[1][j - 1], Math.max(dp[0][j - 2], dp[1][j - 2])) + Integer.parseInt(sticker[0][j]);
                    dp[1][j] = Math.max(dp[0][j - 1], Math.max(dp[0][j - 2], dp[1][j - 2])) + Integer.parseInt(sticker[1][j]);
                }
                bw.write(Math.max(dp[0][n - 1], dp[1][n - 1]) + "\n");
            }
            else
                bw.write(Math.max(dp[0][0], dp[1][0]) +"\n");

        }

        bw.flush();
        bw.close();
    }

}








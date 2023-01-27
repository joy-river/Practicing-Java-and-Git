package DP;

import java.io.*;


public class StairNumber {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long mod = 1000000000;
    static long [][][] dp = new long[101][10][1 << 10];
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][10][1 << 10];
        long result = 0;
        if(n < 10)
            bw.write("0");
        else{
            for (int i = 1 ; i < 10; i++)
                result += (Stair(1, i, 1 << i)) % mod;
            bw.write(Long.toString(result % mod));
        }


        bw.flush();
        bw.close();
    }
    static long Stair(int i , int j, int k){
        if(dp[i][j][k] > 0)
            return dp[i][j][k];
        if(i == n){
            if(k == (1 << 10) - 1)
                return 1;
        }
        else {
            if (j != 0)
                dp[i][j][k] += Stair(i + 1, j - 1, k | (1 << j - 1));
            if (j != 9)
                dp[i][j][k] += Stair(i + 1, j + 1, k | (1 << j + 1));
        }
        return dp[i][j][k] % mod;
    }
}






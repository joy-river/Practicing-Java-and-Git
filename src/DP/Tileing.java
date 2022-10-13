package DP;

import java.io.*;

public class Tileing {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    final static int mod = 10007;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        if(n < 3)
            bw.write(Integer.toString(n));
        else {
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++)
                dp[i] = (dp[i - 1] + dp[i - 2]) % mod;

            bw.write(Integer.toString(dp[n] % mod));
        }
        bw.flush();
        bw.close();

    }
}



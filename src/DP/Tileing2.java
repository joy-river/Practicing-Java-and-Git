package DP;

import java.io.*;

public class Tileing2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int [] dp = new int [n + 1];
        if(n < 3)
            bw.write(Integer.toString(2 * n  -1));
        else{
            dp[1] = 1;
            dp[2] = 3;
            for (int i = 3 ; i <= n;i++)
                dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
            bw.write(Integer.toString(dp[n]));
        }




        bw.flush();
        bw.close();
    }




}




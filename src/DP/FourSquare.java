package DP;

import java.io.*;
import java.util.stream.IntStream;

public class FourSquare {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] dp = IntStream.range(0, n + 1).map(i -> 5).toArray();

        for (int i = 1; i <= (int)Math.sqrt(n); i++)
            dp[i * i] = 1;

        for (int i = 1; i < n + 1; i++) {
            if(2 * i < n + 1)
                dp[2 * i] = Math.min(dp[2 * i], 2 * dp[i]);
            for (int j = 1; j <= (int)Math.sqrt(i); j++)
                if(i + j * j < n + 1)
                    dp[i + j * j] = Math.min(dp[i] + 1 , dp[i + j * j]);
        }






        bw.write(Integer.toString(dp[n]));
        bw.flush();
        bw.close();
    }


}







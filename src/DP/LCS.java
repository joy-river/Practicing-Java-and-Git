package DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LCS {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] a = br.readLine().split("");
        String[] b = br.readLine().split("");
        int[] dp  = new int[a.length + 1];
        int max = 0;

        for (int i = 0 ; i < a.length ; i++){
            dp[i] = 1;
            for (int j = 0 ; j < i; j ++)
                if(a[i].equals(b[j]))
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            max = Math.max(dp[i], max);
        }


        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }

}

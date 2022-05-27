package DP;

import java.io.*;
import java.util.StringTokenizer;

public class LIS {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int [n] ;
        int[] dp = new int[n + 1];
        int max = 1;
        for (int i = 0 ; i < n ; i ++)
            arr[i] = Integer.parseInt(st.nextToken());
        for (int i = 0 ; i < n + 1; i++)
            dp[i] = 1;


        for (int i = 0 ; i< n ; i ++)
            for (int j = 0 ; j < i; j ++) {
                if (arr[i] > arr[j])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                max = Math.max(dp[i], max);
            }

        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }

}

package DP;

import java.io.*;

public class OneTwoThreee {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int temp;
        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(br.readLine());
            if (dp[temp] != 0)
                bw.write(dp[temp] + "\n");
            else {
                bw.write(find(dp, temp) + "\n");
            }

        }


        bw.flush();
        bw.close();

    }

    static int find(int[] dp, int temp) {
        if (dp[temp] != 0)
            return dp[temp];
        else
            return dp[temp] = find(dp, temp - 3) + find(dp, temp - 2) + find(dp, temp - 1);
    }


}

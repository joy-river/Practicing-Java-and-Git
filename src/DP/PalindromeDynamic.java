package DP;

import java.io.*;

public class PalindromeDynamic {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] input;
    static int[][] pal;

    public static void main(String[] args) throws IOException {
        input = br.readLine().split("");
        int n = input.length;
        pal = new int[n][n];

        int [] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1 ; i < n ; i ++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++)
                if (Is_Pal(j, i) == 1)
                    dp[i] = Math.min(dp[i], j == 0 ? 1 : dp[j - 1] + 1);

        }



        bw.write(Integer.toString(dp[n - 1]));
        bw.flush();
        bw.close();
    }


    static int Is_Pal(int start, int end){
        if(pal[start][end] != 0)
            return pal[start][end];

        if(input[start].equals(input[end]))
            if(end - start <= 1)
                return pal[start][end] = 1;
            else if(Is_Pal(start + 1, end - 1) == 1)
                return pal[start][end] = 1;

        return pal[start][end] = -1;
    }

}




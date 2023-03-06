package DP;

import java.io.*;

public class DDR {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] step;
    static int result = 500000;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        step = br.readLine().split(" ");
        int n = step.length;
        dp = new int[n + 1][5][5];
        for (int i = 0 ; i <= n ; i++)
            for(int j = 0 ; j < 5 ; j++)
                for(int s = 0 ; s < 5 ; s++)
                    dp[i][j][s] = 500000;

        dp[0][0][0] = 0;
        int temp;

        for (int i = 0 ; i < n; i++){
            temp = Integer.parseInt(step[i]);
            for (int j = 0 ; j < 5; j ++)
                for(int s = 0 ; s < 5 ; s++){
                    dp[i + 1][temp][s] = Math.min(dp[i + 1][temp][s], dp[i][j][s] + Move_cost(j, temp));
                    dp[i + 1][j][temp] = Math.min(dp[i + 1][j][temp], dp[i][j][s] + Move_cost(s, temp));
                }
        }

        for (int i = 0 ; i < 5 ; i++)
            for (int j = 0 ; j < 5 ; j++)
                result = Math.min(result, dp[n][i][j]);

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }

    static int Move_cost(int from, int to){
        if(to == 0)
            return 0;
        if(from == 0)
            return 2;
        if(from == to)
            return 1;
        if(Math.abs(from - to) == 2)
            return 4;
        else
            return 3;
    }


}



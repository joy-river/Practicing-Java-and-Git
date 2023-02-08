package DP;

import java.io.*;


public class TravelingSalesmanProblem_TSP {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, Max = 987654321, Result;
    static String[][] input;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        input = new String[n][];
        dp = new int [n][1 << n];

        for (int i = 0 ; i < n ; i ++)
            input[i] = br.readLine().split(" ");

        Result = TSP( 0, 0);

        bw.write(Integer.toString(Result));
        bw.flush();
        bw.close();
    }

    static int TSP (int i, int k){
        int Min = Max;
        if(dp[i][k] > 0)
            return dp[i][k];

        if(i == 0){
            if(k == (1 << n) - 1)
                return 0;
            else if (k != 0)
                return Max;
        }

        for (int j = 0 ; j < n; j++)
            if(!input[i][j].equals("0") && ((k & 1 << j) == 0))
                Min = Math.min(Min, TSP(j, k | 1 << j) + Integer.parseInt(input[i][j]));


        return dp[i][k] = Min;

    }

}
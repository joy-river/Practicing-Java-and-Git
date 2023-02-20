package DP;

import java.io.*;

public class LCS2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] a = br.readLine().split("");
        String[] b = br.readLine().split("");
        int[][] dp  = new int[a.length + 1][b.length + 1];
        int max = 0;
        StringBuilder sb = new StringBuilder();
        index max_index = new index(" ".charAt(0), 0 , 0);
        index[][] recent = new index[a.length + 1][b.length + 1];

        for (int i = 1 ; i <= a.length; i++)
            for (int j = 1; j <= b.length; j++) {

                if (a[i - 1].equals(b[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    recent[i][j] = new index(a[i - 1].charAt(0), i - 1, j - 1);
                }
                else {
                    if(dp[i - 1][j] > dp[i][j - 1]) {
                        dp[i][j] = dp[i - 1][j];
                        recent[i][j] = recent[i - 1][j];
                    }
                    else{
                        dp[i][j] = dp[i][j - 1];
                        recent[i][j] = recent[i][j - 1];
                    }
                }
                if(max < dp[i][j]) {
                    max =  dp[i][j];
                    max_index = recent[i][j];
                }
            }

        for(int i = 0 ; i < max ; i++){
            sb.append(max_index.ch);
            max_index = recent[max_index.x][max_index.y];
        }

        bw.write(max + "\n" + sb.reverse());
        bw.flush();
        bw.close();
    }

    static class index {
        char ch;
        int x, y;

        public index(char ch, int x, int y) {
            this.ch = ch;
            this.x = x;
            this.y = y;
        }
    }

}



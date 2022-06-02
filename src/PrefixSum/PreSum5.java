package PrefixSum;

import java.io.*;
import java.util.StringTokenizer;


public class PreSum5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [][]table = new int[n + 1][n + 1];
        int [][] sum = new int[n + 1][n + 1];
        for (int i = 0 ; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= n ; j++)
                table[i][j] = Integer.parseInt(st.nextToken());
        }
        sum[1][1] = table[1][1];
        for (int i = 2; i < n + 1; i++) {
            sum[1][i] = sum[1][i - 1] + table[1][i];
            sum[i][1] = sum[i - 1][1] + table[i][1];
        }
        for (int i = 2; i < n + 1; i++){
            for (int j = 2; j < n + 1; j ++){
                sum[i][j] = sum[i - 1][j] + sum[i][j-1] + table[i][j];
            }
        }





        bw.flush();
        bw.close();
    }

}


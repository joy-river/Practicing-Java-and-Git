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
        int [] cord = new int [4];
        int [][] sum = new int[n + 1][n + 1];

        for (int i = 1 ; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n ; j++)
                sum[i][j] = sum[i][j-1] + (Integer.parseInt(st.nextToken()));
        }
        for (int i = 1 ; i <= n; i++)
            for (int j = 1 ; j <= n ;j++)
                sum[i][j] += sum[i - 1][j];
        for (int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 4; j ++)
                cord[j] = Integer.parseInt(st.nextToken());
            bw.write(sum[cord[2]][cord[3]] - sum[cord[0] - 1][cord[3]] - sum[cord[2]][cord[1] - 1] + sum[cord[0] - 1][cord[1] - 1] + "\n");
        }



        bw.flush();
        bw.close();
    }

}




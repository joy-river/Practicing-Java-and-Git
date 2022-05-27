package DP;

import java.io.*;

public class Ezstairnumber {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int div = 1_000_000_000;
    static int n;
    static long count =0 ;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        long[][] d = new long[n][10];
        for (int i = 0 ; i < 10 ; i++)
            d[0][i] = 1;

        for (int i = 0; i < n - 1; i ++){
            for (int j = 0 ; j < 10 ; j++){
                if (j == 0)
                    d[i + 1][j + 1] += d[i][j] % div;
                else if(j == 9)
                    d[i + 1][j - 1] += d[i][j] % div;
                else{
                    d[i + 1][j + 1] += d[i][j] % div;
                    d[i + 1][j - 1] += d[i][j] % div;
                }
            }
        }
        for (long i : d[n-1])
            count += i;

        bw.write(Long.toString((count - d[n - 1][0]) % div));
        bw.flush();
        bw.close();
    }

}

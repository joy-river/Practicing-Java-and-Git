package DP;

import java.io.*;

public class TastingWine {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int [n + 1];
        int[] d = new int[n + 1];
        int[] dmax = new int [n + 1];
        int max = 0;
        int count = 0;
        for (int i = 0 ; i < n ; i ++)
            wine[i] = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n ; i ++){
            if(wine[i] != 0 && count < 2){
                d[i] = wine[i];
                max = Math.max(max, d[i]);
                dmax[i] = d[i];
                for (int j = i + 1; j < n; j++) {
                    if (j <= i + 2)
                        d[j] = d[i] + wine[j];
                    else
                        d[j] = Math.max(dmax[j-2], dmax[j - 3] + wine[j - 1]) + wine[j];
                    max = Math.max(max, d[j]);
                    dmax[j] = Math.max(dmax[j - 1], d[j]);

                }
                count++;
            }

        }
        bw.write(Integer.toString(n == 1 ? wine[0] : max));
        bw.flush();
        bw.close();
    }

}

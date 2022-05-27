package DP;

import java.io.*;

public class makeone {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int []d = new int [n + 1];

        for (int i = 2 ; i < n + 1 ; i ++){
            d[i] = d[i-1] + 1;
            if (i % 2 == 0)
                d[i] = Math.min(d[i] - 1, d[i / 2]) + 1;
            if(i % 3 == 0)
                d[i] = Math.min(d[i] - 1, d[i / 3]) + 1;
        }
        bw.write(Integer.toString(d[n]));
        bw.flush();
        bw.close();
    }
}

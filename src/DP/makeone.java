package DP;

import java.io.*;

public class makeone {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int []d = new int [n + 1];


        bw.write(Integer.toString(d[n]));
        bw.flush();
        bw.close();
    }
}

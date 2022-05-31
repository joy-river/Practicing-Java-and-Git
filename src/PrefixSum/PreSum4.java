package PrefixSum;

import java.io.*;
import java.util.StringTokenizer;

public class PreSum4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a , b;
        int[] num = new int [n];
        int[] sum = new int [n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i ++)
            num[i] = Integer.parseInt(st.nextToken());
        for (int i = 1 ; i <= n ; i ++)
            sum[i] = sum[i - 1] + num[i - 1];
        for (int i = 0 ; i < m ; i ++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            bw.write(sum[b] - sum[a - 1] + "\n");
        }

        bw.flush();
        bw.close();
    }

}

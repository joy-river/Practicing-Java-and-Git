package PrefixSum;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumArr {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] num = new int[n + 1];
        int [] sum = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= n ; i ++)
            num[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= k; i++)
            sum[i] = sum[i - 1] + num[i];
        for (int i = k + 1 ; i <= n; i++)
            sum[i] = sum[i - 1] + num[i] - num[i - k];



        bw.write(Integer.toString(Arrays.stream(sum, k, n + 1).max().getAsInt()));
        bw.flush();
        bw.close();
    }

}

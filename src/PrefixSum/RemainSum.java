package PrefixSum;

import java.io.*;
import java.util.StringTokenizer;


public class RemainSum {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long [] sum = new long [n + 1];
        long [] countarr = new long [(int) m + 1];
        long count = 0;

        st = new StringTokenizer(br.readLine());
        countarr[(int)(sum[0] = Long.parseLong(st.nextToken()) % m)]++;
        for (int i = 1 ; i < n ; i ++)
            countarr[(int)((sum[i] = (sum[i - 1] + Long.parseLong(st.nextToken()))) % m)]++;

        for (long l : countarr)
            if (l > 1)
                count += l * (l - 1) / 2;


        bw.write(Long.toString(count + countarr[0]));
        bw.flush();
        bw.close();
    }

}


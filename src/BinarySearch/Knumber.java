package BinarySearch;

import java.io.*;

public class Knumber {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long output;
    static long n;

    public static void main(String[] args) throws IOException {
        n = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());
        knum(1, n * n ,k);
        bw.write(Long.toString(output));
        bw.flush();
        bw.close();
    }
    static void knum (long start, long end,long k){
        long mid = (start + end) / 2;
        long count = 1;
        if( start > end)
            output = valid(start) ? start : end;
        else {
            for (int i = 1; i <= n; i++)
                count += Math.min(n, mid / i);

            if (count <= k)
                knum(mid + 1, end, k);
            else
                knum(start, mid - 1, k);
        }
    }

    static boolean valid(long num){
        for (int i = 1; i <= n ; i ++)
            if(num % i == 0 && num / i <= n)
                return true;
        return false;
    }

}



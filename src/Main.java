import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long output;
    static long n;
    public static void main(String[] args) throws IOException {
         n = Long.parseLong(br.readLine());
       long k = Long.parseLong(br.readLine());

        knum(1, 2 * n - 1, k);
        bw.write(Long.toString(output));
       bw.flush();
       bw.close();
    }
    static void knum (long start, long end, long k){
        long mid = (start + end) / 2;

    }
    static long count(long start, long end){
        long count = 0;
        if(end >= n) {
            count +=
            end
        }
        start = Math.abs(start - n);

        for (int i = 0 ; i < )
    }
}



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
        knum(n * n ,k);
        bw.write(Long.toString(output));
       bw.flush();
       bw.close();
    }
    static void knum (long num,long k){
        long mid = num / 2;


    }
    static long count(long i) {

    }
}



import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final long mod = 1000000007;

    public static void main(String[] args) throws IOException {
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long n , s;
        long sum = 0;

        for (int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            n = Long.parseLong(st.nextToken());
            s = Long.parseLong(st.nextToken());
            AtomicLong x = new AtomicLong();
            AtomicLong y = new AtomicLong();
            Euc(n, mod, x , y);
            sum = (sum + (s * x.get()) % mod) % mod;
        }

        bw.write(Long.toString(sum));
        bw.flush();
        bw.close();
    }


    static long Euc(long a, long b, AtomicLong s, AtomicLong t) {
        if(a == 0){
            s.set(0);
            t.set(1);
            return b;
        }
        AtomicLong s1 = new AtomicLong();
        AtomicLong t1 = new AtomicLong();
        long gcd = Euc(b % a, a, s1, t1);
        s.set(t1.get() - (b / a) * s1.get());
        t.set(s1.get());

        if (s.get() <= 0) {
            s.addAndGet(b);
            t.addAndGet( -1 * a);
        }

        return gcd;
    }

}







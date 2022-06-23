import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Long mod = 1000000007L;
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        Long n = Long.parseLong(input[0]);
        Long r = Long.parseLong(input[1]);


        bw.flush();
        bw.close();
    }
    static long A (long n) {
        Long result = 1L;
        while(n != 1){
            result *= n--;
            result %= mod;
        }
        return result;
    }
    static long B (long n, long r){
        long result = 1L;
        while(r != 0){
            result *= r;
            result %= mod;
            result *= (n - r);
            result %= mod;
            r--;
        }
        return result;
    }
}

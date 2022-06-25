import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Long mod = 1000000007L;
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        Long a = A(Long.parseLong(input[0])) % mod;
        Long b = B(Long.parseLong(input[0]), Long.parseLong(input[1])) % mod;

        bw.write(Long.toString(a * mult(mod -2, b, 1L) % mod));

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
        long result = A(n - r);
        result *= A(r);
        return result % mod;
    }
    static Long mult (Long n ,Long num, Long result){
        Long temp;
        if (n != 1){
            temp = mult(n / 2, num, result);
            result = n % 2 == 0 ? (temp * temp % mod) : ((temp * temp % mod) * num) % mod;
            return result;
        }
        else
            return num;
    }
}

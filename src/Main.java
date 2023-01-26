import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long mod = 1000000000;
    static long [][][] dp = new long[101][10][1 << 10];
    static long count = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        if(n < 10)
            bw.write(0);
        else{
            for (int i = 1 ; i < 10; i++) {
                dp[1][i][1 << i] = 1;
                Stair(1, i, 1 << i);
            }
            bw.write(Long.toString(count));
        }


        bw.flush();
        bw.close();
    }
    static void Stair(int i , int j, int k){
        int a,b,c;
            if(i == n) {
                if (k == (1 << 10) - 1)
                    count ++;// dp[i][j][k] % mod;
            }
            else {
                a = i + 1;
                if (j != 0) {
                    b = j - 1;
                    c = k | (1 << b);
                    dp[a][b][c] ++;//= (dp[i][j][k] % mod);
                    Stair(a, b, c);
                }
                if (j != 9) {
                    b = j + 1;
                    c = k | (1 << b);
                    dp[a][b][c] ++;//= (dp[i][j][k] % mod);
                    Stair(a, b, c);
                }
            }
    }
}





import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
       int n = Integer.parseInt(br.readLine());
       StringTokenizer st;
       int[] input = new int[4];
       int[] ts = new int[2];
       for (int i = 0 ; i < n ; i ++){
           st = new StringTokenizer(br.readLine());
           for (int j = 0; j < 4; j++)
               input[j] = Integer.parseInt(st.nextToken());
           if(input[3] - input[2] % gcd(input[0], input[1]) != 0)
               bw.write(-1 + "\n");
           else
               xgcd(input[0], -input[1], ts);

       }

        bw.flush();
        bw.close();

    }


    static int gcd(int a, int b){
        if(b == 0)
            return a;

        return gcd(b, a % b);
    }
    static int xgcd(int a, int b, int[] ts) throws IOException {
        if(b == 0){
            ts[0] = 1; ts[1] = 0;
            return a;
        }
        int gcd = xgcd(b, a % b, ts);
        int temp = ts[1];
        ts[1] = ts[0] - (a / b) * ts[1];
        ts[0] = temp;

        if(ts[0] <= 0){
            ts[0] += b;
            ts[1] -= a;
        }

        return gcd;

    }

}








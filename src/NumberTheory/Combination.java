package NumberTheory;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Combination {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;
        BigInteger result = BigInteger.ONE, divide = BigInteger.ONE;
        while(m != 0){
            result = result.multiply(BigInteger.valueOf(n - count++));
            divide = divide.multiply(BigInteger.valueOf(m--));

        }
        bw.write(result.divide(divide).toString());
        bw.flush();
        bw.close();
    }


}







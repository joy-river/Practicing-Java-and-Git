package Hashing;

import java.io.*;

public class Hashing {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final long M = 1234567891L;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] st = br.readLine().split("");
        long hashsum = 0;
        for (int i = 0 ; i < n ; i ++) {
            hashsum += ((long)st[i].charAt(0) - 96) * hash((long) i, 31L, 0L);
            hashsum %= M;
        }
        bw.write(Long.toString(hashsum));
        bw.flush();
        bw.close();
    }
    static Long hash (Long b , Long num, Long result){
        Long temp;
        if (b > 1){
            temp = hash(b / 2,  num, result);
            result = b % 2 == 0 ? (temp * temp % M) : ((temp * temp % M) * num) % M;
            return result;
        }
        else
            return (long) Math.pow(num, b);
    }
}



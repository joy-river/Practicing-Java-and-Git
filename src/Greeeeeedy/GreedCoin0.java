package Greeeeeedy;

import java.io.*;
import java.util.StringTokenizer;


public class GreedCoin0 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;
        int [] value = new int [n];

        for (int i = 0 ; i < n; i ++)
            value[i] = Integer.parseInt(br.readLine());
        while (k > 0){
            for (int i = n - 1 ; i >= 0 ; i --)
                if(k >= value[i]) {
                    count += k / value[i];
                    k -= (k / value[i]) * value[i];
                    break;
                }
        }

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }

}


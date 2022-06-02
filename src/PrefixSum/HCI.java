package PrefixSum;

import java.io.*;
import java.util.StringTokenizer;


public class HCI {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        String[] arr = br.readLine().split("");
        int n = Integer.parseInt(br.readLine());
        String alpha;
        int [][] sum = new int [arr.length + 1][26];
        int a,b;
        int index;

        sum[0][arr[0].charAt(0) - 97]++;
        for (int i = 1 ; i < arr.length ; i ++){
            for (int j = 0 ; j < 26; j ++)
                sum[i][j] = sum[i - 1][j];
            sum[i][arr[i].charAt(0) - 97]++;
        }


        for (int i = 0; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            alpha = st.nextToken();
            index = alpha.charAt(0) - 97;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            bw.write(sum[b][index] - (a == 0 ? 0 : sum[a - 1][index]) + "\n");

        }
        bw.flush();
        bw.close();
    }

}




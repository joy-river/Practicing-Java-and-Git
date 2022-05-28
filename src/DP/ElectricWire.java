package DP;

import java.io.*;
import java.util.StringTokenizer;

public class ElectricWire {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] wire = new int [501];
        int[] d = new int[501];
        int dmax = 0;
        int count = 0;
        for (int i = 0; i <n ; i++){
            st = new StringTokenizer(br.readLine());
            wire[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < 500 && count < n; i++){
            d[i] = 1;
            if(wire[i] != 0){
                for (int j = 1; j < i ; j++) {
                    if(wire[j] != 0)
                        if (wire[i] > wire[j])
                            d[i] = Math.max(d[j] + 1, d[i]);
                    dmax = Math.max(d[i], dmax);
                }
                count++;
            }
        }


        bw.write(Integer.toString(n - dmax));
        bw.flush();
        bw.close();
    }

}

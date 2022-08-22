package BruteForce;

import java.io.*;
import java.util.*;

public class RemoteControi {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count;
    public static void main(String[] args) throws IOException {

        int chan = Integer.parseInt(br.readLine());
        int beeg = (int) Math.log10(chan);
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] able = new boolean[10];

        count = chan > 100 ? chan - 100 : 100 - chan;
        for (int i = 0 ; i < n ; i ++)
            able[Integer.parseInt(st.nextToken())] = true;


        bw.flush();
        bw.close();
    }

    static void bigger(boolean[] able, int num){
        if(able[num]){
            if(able[num + 1]){

            }
        }
    }

    static void smaller() {

    }

}




import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static String[] card;
    static String[] score;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        card = br.readLine().split("");
        score = br.readLine().split(" ");
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine()), l, r;

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken()) - 1;
            r = Integer.parseInt(st.nextToken()) - 1;



        }

        bw.flush();
        bw.close();
    }

}







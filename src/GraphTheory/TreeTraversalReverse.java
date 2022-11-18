package GraphTheory;

import java.io.*;
import java.util.*;

public class TreeTraversalReverse {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static String[] in;
    static String[] post;
    static HashMap<String, Integer> inor;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        in = br.readLine().split(" ");
        post = br.readLine().split(" ");

        inor = new HashMap<>();
        for (int i = 0 ; i< n ; i ++)
            inor.put(in[i], i);

        MakeTree( 0 , n, n -1);


        bw.flush();
        bw.close();
    }
    static void MakeTree(int start, int end, int next) throws IOException {
        int  left = 0, right = 0;

        String temp = post[next];
        bw.write(temp + " ");

        left = inor.get(temp);
        right = end - left - 1;

        if(left > start)
            MakeTree( start, left, next - 1 - right);

        if(right > 0)
            MakeTree(left + 1, end, next - 1);

    }

}






package BinarySearch;

import java.io.*;
import java.util.*;

public class DrawingZ {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int r, c;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        zcout( n, 0, (int) (Math.pow(2, n)),0, (int) (Math.pow(2, n)), 0);

        bw.flush();
        bw.close();
    }
    static void zcout (int n, int rows,int rowe, int cols, int cole, long count) throws IOException {
        int pow =(int) Math.pow(2, n - 1);
        if(n == 0) {
            bw.write(Long.toString(count));
            return;
        }
        if ((rows + rowe) / 2 > r) // up
            if ((cols + cole) / 2 > c)
                zcout(n - 1, rows, rowe - pow, cols, cole - pow, count);
            else
                zcout(n - 1, rows, rowe - pow, cols + pow, cole , count + pow * pow);
        else                        // bottom
            if((cols + cole) / 2 > c)
                zcout(n - 1, rows + pow, rowe, cols , cole - pow ,count + 2 * pow  * pow);
            else
                zcout(n - 1, rows + pow, rowe, cols + pow, cole, count + 3 * pow * pow);

    }

}





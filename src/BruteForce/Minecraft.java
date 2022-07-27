package BruteForce;

import java.io.*;
import java.util.*;

public class Minecraft {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int [] land = new int [257];
        time[] a = new time[257];
        int temp , min = 256, max = 0, save = 0;
        out output;

        for (int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j< m ;j ++) {
                land[temp = Integer.parseInt(st.nextToken())]++;
                max = Math.max(max, temp);
                min = Math.min(min,temp);
                save += temp;
            }
        }

        a[min] = new time(0, n * m - land[min], 0, save - (min * (n * m)));
        output = new out(2 * a[min].right, min);
        for (int i = min + 1 ;i <=max ;i++){
            a[i] = new time(a[i-1].lc + land[i - 1], a[i - 1].rc - land[i], a[i - 1].left + a[i - 1].lc +land[i - 1], a[i - 1].right - a[i - 1].rc);
            if(a[i].right + b >= a[i].left)
                output = a[i].left + 2 * a[i].right <= output.out ? new out(a[i].left + 2 * a[i].right, i) : output;
        }


        bw.write(output.out + " " + output.i);
        bw.flush();
        bw.close();
    }
    static class time {
        public time(int lc, int rc, int left, int right) {
            this.lc = lc;
            this.rc = rc;
            this.left = left;
            this.right = right;
        }
        int lc;
        int rc;
        int left;
        int right;
    }
    static class out{
        public out (int out, int i){
            this.out = out;
            this.i = i;
        }
        int out;
        int i;
    }

}



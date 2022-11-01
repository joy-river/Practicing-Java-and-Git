package BruteForce;

import java.io.*;
import java.util.*;

public class RemoteControi {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count;
    public static void main(String[] args) throws IOException {

        int chan = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        if(n != 0) st = new StringTokenizer(br.readLine());
        boolean[] able = new boolean[10];

        int next = 0;

        count = Math.abs(chan - 100);

        for (int i = 0 ; i < n ; i ++)
            able[Integer.parseInt(st.nextToken())] = true;
        if(n != 10) {
            while (true) {
                if (chan - next >= 0)
                    if (valid(Integer.toString(chan - next), able)) {
                        chan -= next;
                        break;
                    }

                if (valid(Integer.toString(chan + next), able)) {
                    chan += next;
                    break;
                }
                next++;
            }

            bw.write(Integer.toString(Math.min(count, (int) (next + (chan == 0 ? 1 : (Math.log10(chan) + 1))))));
        }
        else
            bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }

    static boolean valid(String chan, boolean[] able){
        String[] digit = chan.split("");
        for (int i = 0; i < digit.length; i++)
            if(able[Integer.parseInt(digit[i])])
                return false;
        return true;
    }
}




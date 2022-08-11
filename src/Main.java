import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count;
    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        int chan = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] able = new boolean[10];
        count = chan > 100 ? chan - 100 : 100 - chan;
        for (int i = 0 ; i < n ; i ++)
            able[Integer.parseInt(st.nextToken())] = true;





        bw.flush();
        bw.close();
    }

    static void bigger(){

    }


}




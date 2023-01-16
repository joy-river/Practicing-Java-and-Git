import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] list = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++)
            list[i] = Integer.parseInt(st.nextToken());





        bw.flush();
        bw.close();
    }




}




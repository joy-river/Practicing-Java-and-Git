import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer> wifi = new ArrayList<>();
    static int n;
    public static void main(String[] args) throws IOException {
       StringTokenizer st = new StringTokenizer(br.readLine());
       int k = Integer.parseInt(st.nextToken());
       n = Integer.parseInt(st.nextToken());
       for (int i = 0 ; i < k ; i ++)
           wifi.add(Integer.parseInt(br.readLine()));
       Collections.sort(wifi);
        setWifi(0, wifi.get(k));
        bw.flush();
        bw.close();
    }

    static void setWifi(int start, int end) throws IOException {

    }

}



import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n ; i++)



        bw.flush();
        bw.close();

    }
}
class node{
    public node(int num, ArrayList<Integer> link) {
        this.num = num;
        this.link = link;
    }

    int num;
    ArrayList<Integer> link;
}


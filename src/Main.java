import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Jewel> Jlist = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            Jlist.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }


        bw.flush();
        bw.close();
    }

}
class Jewel {
    int m, v;

    public Jewel(int m, int v) {
        this.m = m;
        this.v = v;
    }
}
class Baag{
    int carry;
    boolean full;

    public Baag(int carry, boolean full) {
        this.carry = carry;
        this.full = full;
    }
}




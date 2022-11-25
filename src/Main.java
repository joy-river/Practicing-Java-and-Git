import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean [] visited = new boolean[200001];


        bw.flush();
        bw.close();
    }

}
class Pos{
    int Pos;

    public Pos(int pos, int time) {
        Pos = pos;
        this.time = time;
    }

    int time;
}







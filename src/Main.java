import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int a, b;
        PriorityQueue<FindRoot> nodes = new PriorityQueue<>(Comparator.comparingInt(o -> o.num));

        for (int i = 1 ; i < n ;i ++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            nodes.add(new FindRoot(b, a));
        }

        while(!nodes.isEmpty()){
            bw.write(nodes.poll().parent + "\n");
        }
        bw.flush();
        bw.close();
    }

}
class FindRoot{
    public FindRoot(int num, int parent) {
        this.num = num;
        this.parent = parent;
    }

    int num;
    int link;
}







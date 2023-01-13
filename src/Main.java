import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long result = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Jewel> Jlist = new PriorityQueue<>(Comparator.comparingInt(o -> o.m));
        PriorityQueue<Integer> Blist = new PriorityQueue<>();

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            Jlist.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0 ; i < k ; i++)
           Blist.add(Integer.parseInt(br.readLine()));

        Pick(Jlist, Blist);

        bw.write(Long.toString(result));
        bw.flush();
        bw.close();
    }


    static void Pick (PriorityQueue<Jewel> Jlist, PriorityQueue<Integer> Blist){
        int btemp;
        long sum = 0;
        PriorityQueue<Integer> next = new PriorityQueue<>(Comparator.reverseOrder());

        while(!Blist.isEmpty()) {
            btemp = Blist.poll();
            while(!Jlist.isEmpty() && Jlist.peek().m <= btemp)
                next.add(Jlist.poll().v);
            if(!next.isEmpty())
                sum += next.poll();
        }
        result =  sum;
    }

}
class Jewel {
    int m, v;

    public Jewel(int m, int v) {
        this.m = m;
        this.v = v;
    }
}



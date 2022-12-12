package GraphTheory;

import java.io.*;
import java.util.*;

public class HideAndSeek2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int pos, time, mintime = Integer.MAX_VALUE, count = 0;
        boolean [] visited = new boolean[200001];
        PriorityQueue<Pos2> next = new PriorityQueue<>((o1, o2) -> {
            if(o1.time == o2.time)
                return Integer.compare(o1.Pos, o2.Pos);
            else
                return Integer.compare(o1.time, o2.time);
        });

        visited[n] = true;
        next.add(new Pos2(n, 0));

        while(!next.isEmpty()){
            pos = next.peek().Pos;
            time = next.poll().time;
            visited[pos] = true;
            if(time > mintime)
                break;
            if(pos == k){
                count++;
                mintime = time;
                continue;
            }

            if(pos < k)
                if(!visited[pos * 2])
                    next.add(new Pos2(pos * 2, time + 1));
            if(pos > 0)
                if(!visited[pos - 1])
                    next.add(new Pos2(pos - 1, time + 1));
            if(pos < 100000)
                if(!visited[pos + 1])
                    next.add(new Pos2(pos + 1, time + 1));
        }

        bw.write(mintime + "\n" + count);
        bw.flush();
        bw.close();
    }

}
class Pos2 {
    int Pos;
    int time;

    public Pos2(int pos, int time) {
        this.Pos = pos;
        this.time = time;
    }


}







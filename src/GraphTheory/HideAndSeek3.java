package GraphTheory;

import java.io.*;
import java.util.*;

public class HideAndSeek3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int pos, time;
        boolean [] visited = new boolean[200001];
        PriorityQueue<Pos> next = new PriorityQueue<>((o1, o2) -> {
            if(o1.time == o2.time)
                return Integer.compare(o1.Pos, o2.Pos);
            else
                return Integer.compare(o1.time, o2.time);
        });

        visited[n] = true;
        next.add(new Pos(n, 1));

        while(!next.isEmpty()){
            pos = next.peek().Pos;
            time = next.poll().time;

            if(pos == k){
                bw.write(Integer.toString(time - 1));
                break;
            }

            if(pos < k)
                if(!visited[pos * 2]){
                    visited[pos * 2] = true;
                    next.add(new Pos(pos * 2, time));
                }
            if(pos > 0)
                if(!visited[pos -1]){
                    visited[pos - 1] = true;
                    next.add(new Pos(pos - 1, time + 1));
                }
            if(pos < 100000)
                if(!visited[pos + 1]){
                    visited[pos + 1] = true;
                    next.add(new Pos(pos + 1, time + 1));
                }

        }

        bw.flush();
        bw.close();
    }

}
class Pos{
    int Pos;
    int time;

    public Pos(int pos, int time) {
        this.Pos = pos;
        this.time = time;
    }


}







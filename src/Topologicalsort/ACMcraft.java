package Topologicalsort;

import java.io.*;
import java.util.*;

public class ACMcraft {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int n, k, w, a, b, time;
        build temp;

        for (int i= 0 ; i < t ; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            time = 0;
            String[] delay = br.readLine().split(" ");
            build [] list = new build[n + 1];

            for (int j = 1 ; j <= n ; j ++)
                list[j] = new build(j, 0, new ArrayList<>());

            PriorityQueue<Const> now = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
            for (int j = 0 ; j < k ;j ++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                list[b].count++;
                list[a].link.add(b);
            }
            w = Integer.parseInt(br.readLine());

            for(int j = 1 ; j <= n; j++)
                if(list[j].count == 0)
                    now.add(new Const(list[j], Integer.parseInt(delay[list[j].num - 1])));

            while(!now.isEmpty()){
                temp = now.peek().num;
                time = now.poll().time;
                if(temp.num == w)
                    break;
                for(int v : temp.link) {
                    if(--list[v].count == 0)
                        now.add(new Const(list[v], time + Integer.parseInt(delay[list[v].num - 1])));
                }
            }
            bw.write(time + "\n");
        }

        bw.flush();
        bw.close();
    }
}
class build {
    public build(int num, int count, ArrayList<Integer> link) {
        this.num = num;
        this.count = count;
        this.link = link;
    }
    int num;
    int count;
    ArrayList<Integer> link;

}
class Const {
    build num;

    public Const(build num, int time) {
        this.num = num;
        this.time = time;
    }

    int time;
}







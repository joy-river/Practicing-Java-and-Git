import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int a, b, temp;
        Bus poll;
        Bus[] list = new Bus[n + 1];
        int [] dij = new int[n + 1];
        PriorityQueue<Bus> next = new PriorityQueue<>(Comparator.comparingInt(o -> dij[o.num]));
        int [][] cost = new int [n + 1][n + 1];
        Arrays.fill(dij, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            list[i] = new Bus(i, false, new ArrayList<>());
            Arrays.fill(cost[i], Integer.MAX_VALUE);
            cost[i][i] = 0;
        }


        for (int i = 0 ; i < m; i ++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            temp = Integer.parseInt(st.nextToken());
            cost[a][b] = Math.min(cost[a][b], temp);
            list[a].link.add(list[b]);
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        dij[a] = 0;
        next.add(list[a]);

        while(!next.isEmpty()){
            poll = next.poll();
            if(!poll.visited) {
                poll.visited = true;
                for (int i = 0; i < poll.link.size(); i++) {
                    dij[poll.link.get(i).num] = Math.min(dij[poll.link.get(i).num], dij[poll.num] + cost[poll.num][poll.link.get(i).num]);
                    next.add(poll.link.get(i));
                }

            }
        }

        bw.write(Integer.toString(dij[b]));
        bw.flush();
        bw.close();
    }

}
class Bus {
    int num;
    boolean visited;
    ArrayList<Bus> link;

    public Bus(int num, boolean visited, ArrayList<Bus> link) {
        this.num = num;
        this.visited = visited;
        this.link = link;
    }
}









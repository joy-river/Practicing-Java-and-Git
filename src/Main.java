import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Integer> result = new ArrayList<>();
        int a, b, temp;
        Bus poll;
        Bus[] list = new Bus[n + 1];
        int [] dij = new int[n + 1];
        PriorityQueue<Bus> next = new PriorityQueue<>(Comparator.comparingInt(o -> dij[o.num]));
        int [][] cost = new int [n + 1][n + 1];
        Arrays.fill(dij, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            list[i] = new Bus(i,0, 0,false);
            Arrays.fill(cost[i], Integer.MAX_VALUE);
            cost[i][i] = 0;
        }


        for (int i = 0 ; i < m; i ++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            temp = Integer.parseInt(st.nextToken());
            cost[a][b] = Math.min(cost[a][b], temp);
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
                for (int i = 1; i <= n; i++) {
                    if(cost[poll.num][i] < Integer.MAX_VALUE && i != poll.num) {
                        dij[i] = Math.min(dij[i], dij[poll.num] + cost[poll.num][i]);
                        list[i].count = poll.count + 1;
                        list[i].parent = poll.num;
                        next.add(list[i]);
                    }
                }
            }
        }

        bw.write(dij[b] +"\n" + (list[b].count + 1) + "\n");

        temp = b;
        while(temp != a){
            result.add(temp);
            temp = list[temp].parent;
        }

        result.add(a);
        for (int i = result.size() - 1 ; i >= 0 ; i--)
            bw.write(result.get(i) + " ");

        bw.flush();
        bw.close();
    }

}
class Bus {
    int num;
    int count;
    int parent;
    boolean visited;

    public Bus(int num, int count, int parent, boolean visited) {
        this.num = num;
        this.count = count;
        this.parent = parent;
        this.visited = visited;
    }
}









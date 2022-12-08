package GraphTheory;

import java.io.*;
import java.util.*;

public class MinimumCost2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Integer> result = new ArrayList<>();
        int a, b, temp;
        Bus[] list = new Bus[n + 1];
        int [] dij = new int[n + 1];
        PriorityQueue<Bus> next = new PriorityQueue<>(Comparator.comparingInt(o -> dij[o.num]));
        Arrays.fill(dij, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++)
            list[i] = new Bus(i, 0,false, new HashMap<>());

        for (int i = 0 ; i < m; i ++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            temp = Integer.parseInt(st.nextToken());
            if(!list[a].link.containsKey(b))
                list[a].link.put(b, temp);
            else if(list[a].link.get(b) > temp)
                list[a].link.put(b, temp);
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        dij[a] = 0;
        next.add(list[a]);

        while(!next.isEmpty()){
            list[0] = next.poll();
            if(!list[0].visited) {
                list[0].visited = true;
                for (Integer key : list[0].link.keySet()) {
                    if(dij[key] > dij[list[0].num] + list[0].link.get(key))
                        list[key].parent = list[0].num;
                    dij[key] = Math.min(dij[key], dij[list[0].num] + list[0].link.get(key));
                    next.add(list[key]);
                }
            }
        }


        temp = b;
        while(temp != a){
            result.add(temp);
            temp = list[temp].parent;
        }
        result.add(a);

        bw.write(dij[b] +"\n" + result.size() + "\n");
        for (int i = result.size() - 1 ; i >= 0 ; i--)
            bw.write(result.get(i) + " ");

        bw.flush();
        bw.close();


    }

}
class Bus {
    int num;
    int parent;
    boolean visited;
    HashMap<Integer, Integer> link;

    public Bus(int num,int parent, boolean visited, HashMap<Integer, Integer> link) {
        this.num = num;
        this.parent = parent;
        this.visited = visited;
        this.link = link;
    }
}









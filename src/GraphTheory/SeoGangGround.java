package GraphTheory;

import java.io.*;
import java.util.*;

public class SeoGangGround {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, r;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int a, b, c, result = 0;
        Item[] place = new Item[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n ; i++)
            place[i] = new Item(i, Integer.parseInt(st.nextToken()), new HashMap<>());
        for (int i = 0; i < r; i ++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            place[a].link.put(b, c);
            place[b].link.put(a, c);
        }

        for (int i = 1; i <= n ; i++)
            result = Math.max(result, Get_Item(place, i));

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }
    static int Get_Item(Item[] place, int root){
        boolean[] added = new boolean[n + 1];
        added[place[root].num] = true;
        int sum = place[root].num_item;
        Dist temp;
        PriorityQueue<Dist> next = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        next.add(new Dist(0, place[root]));

        while(!next.isEmpty()){
            temp = next.poll();
            if(temp.dist <= m){
                if(!added[temp.item.num]){
                    sum += temp.item.num_item;
                    added[temp.item.num] = true;
                }
                for(Integer a : temp.item.link.keySet())
                    next.add(new Dist(temp.dist + temp.item.link.get(a), place[a]));
            }
            else break;
        }

        return sum;
    }

}
class Dist {
    int dist;
    Item item;
    public Dist(int dist,  Item item) {
        this.dist = dist;
        this.item = item;
    }
}
class Item {
    int num;
    int num_item;
    HashMap<Integer, Integer> link;

    public Item(int num, int num_item, HashMap<Integer, Integer> link) {
        this.num = num;
        this.num_item = num_item;
        this.link = link;
    }
}








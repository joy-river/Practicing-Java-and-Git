package GraphTheory;

import java.io.*;
import java.util.*;

public class SeperatingCityPlan {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] plist;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        PriorityQueue<City_Edge> elist = new PriorityQueue<>(Comparator.comparingInt(o -> o.c));
        plist = new int[v + 1];
        City_Edge temp;
        int ap, bp, sum = 0, count = 0;

        for (int i = 1 ; i <= v; i ++)
            plist[i] = i;

        for (int i = 0 ; i < e ; i ++){
            st = new StringTokenizer(br.readLine());
            elist.add(new City_Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }


        while(count < v - 2 && !elist.isEmpty()){
            temp = elist.poll();
            ap = find_cycle(temp.a);
            bp = find_cycle(temp.b);
            if(ap != bp) {
                if(ap < bp)
                    plist[bp] = ap;
                else
                    plist[ap] = bp;
                sum += temp.c;
                count++;
            }
        }


        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();
    }
    static int find_cycle(int temp){

        if(plist[temp] == temp)
            return temp;
        else
            return plist[temp] = find_cycle(plist[temp]);
    }

}
class City_Edge {
    int a, b, c;

    public City_Edge(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}





package GraphTheory;

import java.io.*;
import java.util.*;

public class MinimumSpanningTree {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static vertex[] vlist;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        PriorityQueue<EDge> elist = new PriorityQueue<>(Comparator.comparingInt(o -> o.c));
        vlist = new vertex[v + 1];
        EDge temp;
        int ap, bp;

        for (int i = 1 ; i <= v; i ++)
            vlist[i] = new vertex(i, i);
        int sum = 0;

        for (int i = 0 ; i < e ; i ++){
            st = new StringTokenizer(br.readLine());
            elist.add(new EDge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }


        while(!elist.isEmpty()){
            temp = elist.poll();
            ap = find_cycle(vlist[temp.a]);
            bp = find_cycle(vlist[temp.b]);
            if(ap != bp) {
                vlist[bp].parent = ap;
                sum += temp.c;
            }
        }


        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();
    }

    static int find_cycle(vertex temp){
        vertex next = temp;

        while(!next.equals(vlist[next.parent]))
            next = vlist[next.parent];


        return next.num;
    }

}
class EDge {
    int a, b, c;

    public EDge(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
class vertex{
    int num;
    int parent;

    public vertex(int num, int parent) {
        this.num = num;
        this.parent = parent;
    }
}




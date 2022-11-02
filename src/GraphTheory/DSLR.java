package GraphTheory;

import java.io.*;
import java.util.*;

public class DSLR {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n ; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Bfs(a, b);
        }

        bw.flush();
        bw.close();
    }
    static void Bfs(int a, int b) throws IOException {

        Queue<dslr> bs = new LinkedList<>();
        bs.add(new dslr(null, 0, a));
        boolean[] visited = new boolean[10000];
        StringBuilder sb = new StringBuilder();
        int d, s, l ,r;
        dslr temp;

        while (!bs.isEmpty()) {
            int num = bs.peek().num;
            if(num == b)
                break;
            d = d(num);
            s = s(num);
            l = l(num);
            r = r(num);
            if(!visited[d]){
                visited[d] = true;
                bs.add(new dslr(bs.peek(), 1, d));
            }
            if(!visited[s]){
                visited[s] = true;
                bs.add(new dslr(bs.peek(), 2, s));
            }
            if(!visited[l]){
                visited[l] = true;
                bs.add(new dslr(bs.peek(), 3, l));
            }
            if(!visited[r]){
                visited[r] = true;
                bs.add(new dslr(bs.peek(), 4, r));
            }
            bs.poll();
        }
        temp = bs.poll();
        while(temp.op != 0){
            switch (temp.op){
                case 1 : sb.append("D"); break;
                case 2 : sb.append("S"); break;
                case 3 : sb.append("L"); break;
                case 4 : sb.append("R"); break;
            }
            temp = temp.parent;
        }
        bw.write(sb.reverse() + "\n");

    }

    static int d(int num){
        return (2 * num) % 10000;
    }
    static int s(int num){
        return num == 0 ? 9999 : num - 1;
    }
    static int l(int num){
        int temp;

        if(num >= 1000){
            temp = num / 1000;
            num = (num % 1000) * 10 + temp;
        }
        else
            num *= 10;

        return num;
    }
    static int r(int num){
        int temp;

        temp = num % 10;
        num = (num / 10) + temp * 1000;

        return num;
    }
}
class dslr{
    public dslr(dslr parent, int op, int num) {
        this.parent = parent;
        this.op = op;
        this.num = num;
    }
    dslr parent;
    int op;
    int num;
}



import java.io.*;
import java.util.*;

public class Main {
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
            sum = 0;
            String[] delay = br.readLine().split(" ");
            build [] list = new build[n + 1];
            list[0] = new build( 0,-1, null);
            for (int j = 1 ; j <= n ; j ++)
                list[j] = new build(i, 0, new ArrayList<>());
            PriorityQueue<build> next = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));

            for (int j = 0 ; j < k ;j ++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                list[b].count++;
                list[a].link.add(b);
            }
            w = Integer.parseInt(br.readLine());
            Collections.addAll(next, list);
            next.poll();

            while(!next.isEmpty()){
                temp = next.poll();
                if(temp.num == w)
                    break;
                for(int v : temp.link)
                    list[v].count --;


            }


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







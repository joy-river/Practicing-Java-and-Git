package GraphTheory;

import java.io.*;
import java.util.*;

public class SnakeAndLadder {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ladder = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());

        dice[] list = new dice[101];
        dice temp;
        boolean[] visited = new boolean[101];
        PriorityQueue<dice> bfs = new PriorityQueue<>((Comparator.comparingInt(o -> o.count)));


        for (int i = 100; i > 0; i--)
            list[i] = new dice(i, 0, null);


        for (int i = 0 ; i < ladder + snake; i ++){
            st = new StringTokenizer(br.readLine());
            list[Integer.parseInt(st.nextToken())].link = list[Integer.parseInt(st.nextToken())];
        }

        bfs.add(list[1]);

        while(!bfs.isEmpty()){
            temp = bfs.poll();
            if(temp.num == 100) {
                bw.write(Integer.toString(temp.count));
                break;
            }
            if(temp.link != null){
                visited[temp.link.num] = true;
                temp.link.count = temp.count;
                bfs.add(temp.link);
            }
            else{
                for (int i = 1; i <= 6; i ++){
                    if(temp.num + i <= 100)
                        if(!visited[temp.num + i]){
                            visited[temp.num + i] = true;
                            list[temp.num + i].count = temp.count + 1;
                            bfs.add(list[temp.num + i]);
                        }
                }
            }
        }


        bw.flush();
        bw.close();
    }

}
class dice{
    int num;
    int count;
    dice link;


    public dice(int num, int count, dice link) {
        this.num = num;
        this.count = count;
        this.link = link;
    }
}




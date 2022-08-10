package Queue;

import java.io.*;
import java.util.*;

public class BaeChuPlant {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Queue<bae> chu;
        Queue<bae> pile;
        int x, y, k, count, a;

        StringTokenizer st;
        for (int i = 0 ; i < n ; i++){
            chu = new LinkedList<>();
            pile = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            count = 0;

            for (int j = 0 ; j < k ; j++) {
                st = new StringTokenizer(br.readLine());
                chu.add(new bae(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            while(!chu.isEmpty()){
                count++;
                pile.clear();
                pile.add(chu.poll());
                while(!pile.isEmpty()) {
                    a = chu.size();
                    for (int t = 0; t < a; t++) {
                        if (pile.peek().x == chu.peek().x || pile.peek().y == chu.peek().y) {
                            if (Math.abs(pile.peek().x - chu.peek().x) == 1)
                                pile.add(chu.poll());
                            else if (Math.abs(pile.peek().y - chu.peek().y) == 1)
                                pile.add(chu.poll());
                            else
                                chu.add(chu.poll());
                        }
                        else
                            chu.add(chu.poll());
                    }
                    pile.poll();
                }
            }
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }


}
class bae{
    public bae(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x;
    int y;

}



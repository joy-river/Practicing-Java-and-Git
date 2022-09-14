package DFSandBFS;

import java.io.*;
import java.util.*;

public class Virus {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        com[] com = new com[n + 1];
        Queue<com> worm = new LinkedList<>();
        int a, b;
        com temp;

        for (int i = 1 ; i <= n; i++)
            com[i] = new com(false, new LinkedList<>());

        for (int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            com[a].link.add(com[b]);
            com[b].link.add(com[a]);
        }
        worm.addAll(com[1].link);
        com[1].check = true;
        b = 0;
        while(!worm.isEmpty()){
            a = worm.size();
            for (int i = 0 ; i < a; i ++){
                if(worm.peek().check)
                    worm.poll();
                else{
                    b++;
                    worm.addAll(worm.peek().link);
                    worm.poll().check = true;
                }
            }
        }

        bw.write(Integer.toString(b));
        bw.flush();
        bw.close();
    }

}
class com {
    boolean check;

    public com(boolean check, Queue<com> link) {
        this.check = check;
        this.link = link;
    }

    Queue<com> link;

}







package Topologicalsort;

import java.io.*;
import java.util.*;


public class MakeLine {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a, b;

        int [] Deg = new int[n + 1];
        Queue<Integer>[] link = new Queue[n + 1];
        HashSet<Integer> Full = new HashSet<>();

        for (int i = 1; i <= n ; i++) {
            link[i] = new LinkedList<>();
            Full.add(i);
        }

        for (int i = 0 ; i < m; i ++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            link[a].add(b);
            Deg[b]++;
            Full.remove(b);
        }
        PriorityQueue<Integer> next = new PriorityQueue<>(Full);

        while(!next.isEmpty()){
            a = next.poll();
            bw.write(a + " ");
            while(!link[a].isEmpty()) {
                if (--Deg[b = link[a].poll()] == 0)
                    next.add(b);
            }
        }

        bw.flush();
        bw.close();


    }



}



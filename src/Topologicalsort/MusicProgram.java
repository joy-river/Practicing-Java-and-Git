package Topologicalsort;

import java.io.*;
import java.util.*;


public class MusicProgram {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] In_Degree = new int[n + 1];
        Queue<Integer>[] link = new Queue[n + 1];
        HashSet<Integer> full_set = new HashSet<>();

        for (int i = 1; i <= n ; i++) {
            link[i] = new LinkedList<>();
            full_set.add(i);
        }

        int u, a, b;

        for (int i = 0; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            for (int j = 0; j < u - 1 ; j++){
                a = b;
                b = Integer.parseInt(st.nextToken());

                In_Degree[b]++;
                link[a].add(b);
                full_set.remove(b);
            }
        }
        PriorityQueue<Integer> next = new PriorityQueue<>(full_set);

        while(!next.isEmpty()){
            a = next.poll();
            full_set.add(a);
            sb.append(a + "\n");

            while(!link[a].isEmpty()){
                b = link[a].poll();
                if(--In_Degree[b] == 0)
                    next.add(b);
            }

        }

        bw.write(full_set.size() != n ? "0" :  sb.toString());
        bw.flush();
        bw.close();


    }

}



package Topologicalsort;

import java.io.*;
import java.util.*;


public class ExerciseBook {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int a, b, temp;

        HashSet<Integer> full = new HashSet<>();
        for (int i = 1 ; i <= n; i++)
            full.add(i);
        Queue<Integer>[] link = new Queue[n + 1];
        int [] In_Degree = new int[n + 1];
        for (int i = 1 ; i <= n ; i ++)
            link[i] = new LinkedList<>();


        for (int i = 0 ; i < m ; i ++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            link[a].add(b);
            In_Degree[b]++;
            full.remove(b);
        }
        PriorityQueue<Integer> next = new PriorityQueue<>(full);

        while(!next.isEmpty()){
            temp = next.poll();
            while(!link[temp].isEmpty()){
                a = link[temp].poll();
                if(--In_Degree[a] == 0)
                    next.add(a);
            }
            sb.append(temp).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


}









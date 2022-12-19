package Recursive;

import java.io.*;
import java.util.*;

public class NandM9 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; i++)
            list.add(Integer.parseInt(st.nextToken()));

        Collections.sort(list);

        print(new StringBuilder(), list, 0, new boolean[n], new HashSet<>());

        bw.flush();
        bw.close();
    }

    static void print(StringBuilder sb, ArrayList<Integer> list, int count, boolean[] visited, HashSet<String> dupe) throws IOException {
        if(count == m - 1) {
            for (int i = 0 ; i < n; i++)
                if(!visited[i])
                    if(!dupe.contains(sb.toString() + list.get(i))){
                        bw.write(sb.toString() + list.get(i) + "\n");
                        dupe.add(sb.toString() + list.get(i));
                    }
        }
        else {
            for (int i = 0 ; i < n; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    print(new StringBuilder(sb).append(list.get(i)).append(" "), list, count + 1, visited, dupe);
                    visited[i] = false;
                }
            }
        }
    }

}









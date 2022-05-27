package DP;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class InTriangle {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int max;
        ArrayList<Integer>[] tri = new ArrayList[n];
        StringTokenizer st;
        for (int i = 0 ; i < n ; i ++){
            tri[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < i + 1 ; j++)
                tri[i].add(Integer.parseInt(st.nextToken()));
        }
        max = tri[0].get(0);
        for (int i = 1 ; i < n ; i ++){
            for (int j = 0; j < tri[i].size(); j++){
                if(j == 0)
                    tri[i].add(j,tri[i-1].get(j) + tri[i].get(j));
                else if (j == tri[i].size() - 1)
                    tri[i].add(j,tri[i-1].get(j - 1) + tri[i].get(j));
                else
                    tri[i].add(j,Math.max(tri[i-1].get(j-1) , tri[i-1].get(j)) + tri[i].get(j));
                if(tri[i].get(j) > max)
                    max = tri[i].get(j);
                tri[i].remove(j+1);
            }
            tri[i - 1].clear();
        }

        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }
}

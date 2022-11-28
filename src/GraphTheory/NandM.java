package GraphTheory;

import java.io.*;
import java.util.*;

public class NandM {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] input = br.readLine().split(" ");
        ArrayList<nm> list = new ArrayList<>();

        for (int i = 0 ; i < n ; i ++)
            list.add(new nm(Integer.parseInt(input[i]), false));

        list.sort(Comparator.comparingInt(o -> o.num));

        dfs(list, 0, "", m);

        bw.flush();
        bw.close();
    }

    static void dfs(ArrayList<nm> list, int depth, String result, int m) throws IOException {
        if(depth == m){
            bw.write(result + "\n");
        }
        else{
            for (nm a : list)
                if(!a.visited){
                    a.visited = true;
                    dfs(list, depth + 1, result + a.num + " ", m);
                    a.visited = false;
                }
        }
    }

}
class nm{
    int num;
    boolean visited;

    public nm(int num, boolean visited) {
        this.num = num;
        this.visited = visited;
    }
}









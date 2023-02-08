import DFSandBFS.UnionFind;

import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        String[][] input = new String[n][];
        StringTokenizer st;
        ArrayList<Line> lines = new ArrayList<>();

        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            lines.add(new Line(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }



        bw.flush();
        bw.close();
    }

    static boolean Meet (Line a, Line b){
        return (a.x1 - a.x2)*(b.y1 - b.y2) - (a.y1 - a.y2)*(b.x1 - b.x2) == 0;
    }

}

class Line{
    int x1, y1;
    int x2, y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
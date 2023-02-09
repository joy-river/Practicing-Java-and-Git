package Geometry;

import java.io.*;
import java.util.*;


public class SegmentGroup {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] Group;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int Group_Count = n, Group_Max = 1;
        Group = new int[n][2];
        StringTokenizer st;
        Line[] lines = new Line[n];
        int i_Group, j_Group;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Group[i][0] = i;
            Group[i][1] = 1;
            lines[i] = new Line(new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())), new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            ;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Find_Group(i) != Find_Group(j)) {
                    if (Meet(lines[i], lines[j])) {
                        Group_Count--;
                        i_Group = Find_Group(i);
                        j_Group = Find_Group(j);
                        Group[j_Group][0] = i_Group;
                        Group_Max = Math.max(Group_Max, Group[i_Group][1] += Group[j_Group][1]);
                    }
                }
            }
        }

        bw.write(Group_Count + "\n" + Group_Max);
        bw.flush();
        bw.close();
    }

    static int Find_Group(int i) {
        if (Group[i][0] == i)
            return i;
        else
            return Group[i][0] = Find_Group(Group[i][0]);

    }

    static boolean Meet(Line a, Line b) {
        int a_cross = CCW(a.p1, a.p2, b.p1) * CCW(a.p1, a.p2, b.p2);
        int b_cross = CCW(b.p1, b.p2, a.p1) * CCW(b.p1, b.p2, a.p2);
        Dot temp;

        if(a_cross == 0 &&  b_cross == 0) {
            if(Dot_Com(a.p2, a.p1)) {
                temp = a.p1;
                a.p1 = a.p2;
                a.p2 = temp;
            }
            if(Dot_Com(b.p2, b.p1)) {
                temp = b.p1;
                b.p1 = b.p2;
                b.p2 = temp;
            }

            return Dot_Com(b.p1, a.p2) && Dot_Com(a.p1, b.p2);
        }
        else return a_cross <= 0 && b_cross <= 0;
    }

    static boolean Dot_Com(Dot p1, Dot p2){
        if(p1.x == p2.x)
            return p1.y <= p2.y;
        else
            return p1.x <= p2.x;

    }

    static int CCW(Dot p1, Dot p2, Dot p3){
        long Cross = ((long) p1.x * p2.y + (long) p2.x * p3.y + (long) p3.x * p1.y) - ((long) p1.y * p2.x + (long) p2.y * p3.x + (long) p3.y * p1.x);

        return Long.compare(Cross, 0L);
    }


}

class Dot{
    int x, y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class Line{
    Dot p1;
    Dot p2;
    public Line(Dot p1, Dot p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}
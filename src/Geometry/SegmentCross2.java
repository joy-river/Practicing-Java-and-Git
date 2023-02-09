package Geometry;

import java.io.*;
import java.util.*;


public class SegmentCross2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        SegCross2_Line[] input = new SegCross2_Line[2];

        for (int i = 0 ; i < 2 ; i ++) {
            st = new StringTokenizer(br.readLine());
            input[i] = new SegCross2_Line(new SegCross2_Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())), new SegCross2_Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }



        bw.write(Meet(input[0], input[1]) ? "1" : "0");
        bw.flush();
        bw.close();
    }


    static boolean Meet(SegCross2_Line a, SegCross2_Line b) {
        int a_cross = CCW(a.p1, a.p2, b.p1) * CCW(a.p1, a.p2, b.p2);
        int b_cross = CCW(b.p1, b.p2, a.p1) * CCW(b.p1, b.p2, a.p2);
        SegCross2_Dot temp;

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

    static boolean Dot_Com(SegCross2_Dot p1, SegCross2_Dot p2){
        if(p1.x == p2.x)
            return p1.y <= p2.y;
        else
            return p1.x <= p2.x;

    }

    static int CCW(SegCross2_Dot p1, SegCross2_Dot p2, SegCross2_Dot p3){
        long Cross = ((long) p1.x * p2.y + (long) p2.x * p3.y + (long) p3.x * p1.y) - ((long) p1.y * p2.x + (long) p2.y * p3.x + (long) p3.y * p1.x);

        return Long.compare(Cross, 0L);
    }


}

class SegCross2_Dot{
    int x, y;

    public SegCross2_Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class SegCross2_Line{
    SegCross2_Dot p1;
    SegCross2_Dot p2;
    public SegCross2_Line(SegCross2_Dot p1, SegCross2_Dot p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}
package Geometry;

import java.io.*;
import java.util.*;


public class SegmentCross1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        SegCross1_Line[] input = new SegCross1_Line[2];

        for (int i = 0 ; i < 2 ; i ++) {
            st = new StringTokenizer(br.readLine());
            input[i] = new SegCross1_Line(new SegCross1_Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())), new SegCross1_Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }



        bw.write(Meet(input[0], input[1]) ? "1" : "0");
        bw.flush();
        bw.close();
    }


    static boolean Meet(SegCross1_Line a, SegCross1_Line b) {
        int a_cross = CCW(a.p1, a.p2, b.p1) * CCW(a.p1, a.p2, b.p2);
        int b_cross = CCW(b.p1, b.p2, a.p1) * CCW(b.p1, b.p2, a.p2);
        SegCross1_Dot temp;

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

    static boolean Dot_Com(SegCross1_Dot p1, SegCross1_Dot p2){
        if(p1.x == p2.x)
            return p1.y <= p2.y;
        else
            return p1.x <= p2.x;

    }

    static int CCW(SegCross1_Dot p1, SegCross1_Dot p2, SegCross1_Dot p3){
        long Cross = ((long) p1.x * p2.y + (long) p2.x * p3.y + (long) p3.x * p1.y) - ((long) p1.y * p2.x + (long) p2.y * p3.x + (long) p3.y * p1.x);

        return Long.compare(Cross, 0L);
    }


}

class SegCross1_Dot{
    int x, y;

    public SegCross1_Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class SegCross1_Line{
    SegCross1_Dot p1;
    SegCross1_Dot p2;
    public SegCross1_Line(SegCross1_Dot p1, SegCross1_Dot p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}
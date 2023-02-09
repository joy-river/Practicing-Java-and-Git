import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean Covered = false;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        SegCross3_Line[] input = new SegCross3_Line[2];
        boolean Cross;

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            input[i] = new SegCross3_Line(new SegCross3_Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())), new SegCross3_Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Cross = Meet(input[0], input[1]);
        bw.write(Cross ? "1" : "0");
        if (Cross)
            Cross_Point(input[0], input[1]);

        bw.flush();
        bw.close();
    }

    static void Cross_Point(SegCross3_Line a, SegCross3_Line b) throws IOException {
        SegCross3_Dot p1 = a.p1, p2 = a.p2, p3 = b.p1, p4 = b.p2;

        double A = p2.y - p1.y, B = p1.x - p2.x, E = (A * p1.x) + (B * p1.y);
        double C = p4.y - p3.y, D = p3.x - p4.x, F = (C * p3.x) + (D * p3.y);
        double DE = (A * D) - (B * C);

        if(DE == 0) {
            if (OnePointCover(a, b))
                bw.write("\n" + ((E * D) - (B * F)) + " " + ((A * F) - (E * C)));
        }
        else
         bw.write("\n" + ((E * D) - (B * F)) / DE + " " + ((A * F) - (E * C)) / DE);
    }

    static boolean OnePointCover (SegCross3_Line a, SegCross3_Line b){
        if(a.p1.compare(b.p1)){
            if(slope(a.p1, b.p2) != slope(a.p1, a.p2))
                return true;
            else if(Dot_Com(a.p1, b.p2) != Dot_Com(a.p1, a.p2))
                return true;
        }
        if(a.p1.compare(b.p2)){
            if(slope(a.p1, b.p1) != slope(a.p1, a.p2))
                return true;
            else if(Dot_Com(a.p1, b.p1) != Dot_Com(a.p1, a.p2));
                return true;
        }
        if(a.p2.compare(b.p1)){
            if(slope(a.p2, b.p2) != slope(a.p2, a.p1))
                return true;
            else if(Dot_Com(a.p2, b.p2) != Dot_Com(a.p2, a.p1));
                return true;
        }
        if(a.p2.compare(b.p2)){
            if(slope(a.p2, b.p1) != slope(a.p2, a.p1))
                return true;
            else if (Dot_Com(a.p2, b.p1) != Dot_Com(a.p2, a.p1));
        }
        return false;
    }

    static double slope (SegCross3_Dot a, SegCross3_Dot b){
        return (double)(a.y - b.y) / (a.x - b.x);
    }


    static boolean Meet(SegCross3_Line a, SegCross3_Line b) {
        int a_cross = CCW(a.p1, a.p2, b.p1) * CCW(a.p1, a.p2, b.p2);
        int b_cross = CCW(b.p1, b.p2, a.p1) * CCW(b.p1, b.p2, a.p2);
        SegCross3_Dot temp;

        if(a_cross == 0 && b_cross == 0) {
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
        else
            return a_cross <= 0 && b_cross <= 0;
    }

    static boolean Dot_Com(SegCross3_Dot p1, SegCross3_Dot p2){
        if(p1.x == p2.x)
            return p1.y <= p2.y;
        else
            return p1.x <= p2.x;

    }


    static int CCW(SegCross3_Dot p1, SegCross3_Dot p2, SegCross3_Dot p3){
        long Cross = (long)(p2.x - p1.x) * (long)(p3.y - p1.y) - (long) (p2.y - p1.y) * (long)(p3.x- p1.x);

        return Long.compare(Cross, 0L);
    }


}

class SegCross3_Dot {
    int x, y;

    public SegCross3_Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }



    public boolean compare(SegCross3_Dot p1) {
        return this.x == p1.x && this.y == p1.y;
    }
}

class SegCross3_Line{
    SegCross3_Dot p1;
    SegCross3_Dot p2;
    public SegCross3_Line(SegCross3_Dot p1, SegCross3_Dot p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}
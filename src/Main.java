import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static double sum;
    static int n;
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        double a, b, xsum = 0, ysum = 0;
        for (int i = 0; i < t; i ++){
            ArrayList<vec> list = new ArrayList<>();
            n = Integer.parseInt(br.readLine());
            sum = Double.MAX_VALUE;
            xsum = 0;
            ysum = 0;
            for (int j = 0 ; j < n ; j++){
                st = new StringTokenizer(br.readLine());
                a = Double.parseDouble(st.nextToken());
                b = Double.parseDouble(st.nextToken());
                xsum += a;
                ysum += b;
                list.add(new vec(a, b));
            }

            brute(n / 2,0, xsum, ysum, list);

            bw.write(sum + "\n");

        }


        bw.flush();
        bw.close();
    }
    static void brute(int count, int index, double xsum, double ysum, ArrayList<vec> list){
        vec b;
        if(count == 0)
            sum = Math.min(sum, Math.sqrt(xsum * xsum + ysum * ysum));
        else{
            for (int j = index; j < n ; j++){
                b = list.get(index);
                brute(count - 1, index + 1,xsum - 2 * b.x, ysum - 2 * b.y, list);
            }
        }
    }

}
class vec {
    double x;
    double y;

    public vec(double x, double y) {
        this.x = x;
        this.y = y;
    }
}





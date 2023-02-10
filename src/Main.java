import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        double[]x = new double[n];
        double[]y = new double[n];
        double sum = 0;

        for (int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0 ; i < n - 1 ; i ++)
            sum +=  x[i]*y[i + 1] - x[1 + i]*y[i];
        sum += x[n - 1]*y[0] - x[0]* y[n - 1];


        bw.write(String.format("%.1f", Math.abs(sum) / 2));
        bw.flush();
        bw.close();
    }




}

class Poly_Vertex{
    double x, y;

    public Poly_Vertex(double x, double y) {
        this.x = x;
        this.y = y;
    }
}


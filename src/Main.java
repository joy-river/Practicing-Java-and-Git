import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static double sum;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i ++){
            ArrayList<vec> list = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            sum = Double.MAX_VALUE;
            for (int j = 0 ; j < n ; j++){
                st = new StringTokenizer(br.readLine());
                list.add(new vec(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            brute(n, new vec(0, 0) , list);

            bw.write(sum + "\n");


        }


        bw.flush();
        bw.close();
    }
    static void brute(int n, vec temp, ArrayList<vec> list){
        vec a, b;
        if(n == 0){
            sum = Math.min(sum, temp.getLength());
        }
        else{
            a = list.remove(0);
            for (int j = 0; j < list.size(); j++){
                b = list.remove(0);
                brute(n - 2, new vec(temp.x + (a.x - b.x), temp.y + (a.y - b.y)), list);
                brute(n - 2, new vec(temp.x + (b.x - a.x), temp.y + (b.y - a.y)), list);
                list.add(b);
            }
            list.add(a);
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

    public double getLength(){
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

}





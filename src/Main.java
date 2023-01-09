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
                list.add(new vec(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), false));
            }

            brute(n, new vec(0, 0, false) , list);



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
           for (int i = 0 ; i < list.size(); i++){
               if(!list.get(i).visited){
                   a = list.get(i);
                   a.visited = true;
                   for (int j = i + 1; j < list.size(); j++){
                       if(!list.get(j).visited){
                           b = list.get(j);
                           b.visited = true;
                           brute(n - 2, new vec(temp.x + (a.x - b.x), temp.y + (a.y - b.y), false), list);
                           brute(n - 2, new vec(temp.x + (b.x - a.x), temp.y + (b.y - a.y), false), list);
                           b.visited = false;
                       }
                   }
                   a.visited = false;
               }
           }
        }

    }
}
class vec {
    double x;
    double y;

    public vec(double x, double y, boolean visited) {
        this.x = x;
        this.y = y;
        this.visited = visited;
    }

    public double getLength(){
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
    boolean visited;

}





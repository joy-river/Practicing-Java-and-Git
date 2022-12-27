import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int n, k, w, a, b, sum;

        for (int i= 0 ; i < t ; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            sum = 0;
            String[] delay = br.readLine().split(" ");
            ArrayList<Integer> [] list = new ArrayList[n + 1];
            for (int j = 1 ; j <= n ; j ++)
                list[j] = new ArrayList<>();

            for (int j = 0; j < k; j++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                list[b].add(a);
            }
            w = Integer.parseInt(br.readLine());
            Queue<Integer> next = new LinkedList<>();
            next.add(w);

            while(!next.isEmpty()){
                sum += Integer.parseInt(delay[w]);
            }



        }

        bw.flush();
        bw.close();
    }
}








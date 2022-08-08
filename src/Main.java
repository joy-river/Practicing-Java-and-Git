import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        ArrayList<bae> chu;
        int x, y, k, count,a, b;
        StringTokenizer st;
        for (int i = 0 ; i < n ; i++){
            chu = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            count = 0;
            boolean [][] farm = new boolean[x + 1][y + 1];

            for (int j = 0 ; j < k ; j++) {
                st = new StringTokenizer(br.readLine());
                chu.add(new bae(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
                a = chu.get(j).x;
                b = chu.get(j).y;
                farm[a][b] = true;
            }
            chu.sort((o1, o2) -> {
                if(o1.x != o2.x)
                    return Integer.compare(o1.x, o2.x);
                else
                    return Integer.compare(o1.y, o2.y);
            });

            for (int j = 0 ; j < k ; j++) {
                a = chu.get(j).x;
                b = chu.get(j).y;

                if (a < x - 1){if(farm[a + 1][b]) continue;}
                if (b < y - 1) { if(farm[a][b + 1]) continue;}

                count++;
            }
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }


}
class bae{
    public bae(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x;
    int y;

}



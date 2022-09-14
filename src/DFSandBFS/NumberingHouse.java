package DFSandBFS;

import java.io.*;
import java.util.*;

public class NumberingHouse {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        String[][] home = new String[n][n];
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0; i < n; i++)
            home[i] = br.readLine().split("");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (home[i][j].equals("1"))
                    num.add(danji(i, j, home));
            }
        }

        bw.write(num.size() + "\n");
        Collections.sort(num);
        for (int i = 0  ; i < num.size();i ++)
            bw.write(num.get(i) + "\n");
        bw.flush();
        bw.close();
    }

    static int danji(int i, int j, String[][] home) {
        Queue<house> a = new LinkedList<>();
        int count = 0;
        a.add(new house(i, j));
        while (!a.isEmpty()) {
            i = a.peek().x;
            j = a.peek().y;
            if(home[i][j].equals("1")){
                count++;
                if (i > 0)
                    a.add(new house(i - 1, j));
                if (i < n - 1)
                    a.add(new house(i + 1, j));
                if (j > 0)
                    a.add(new house(i, j - 1));
                if (j < n - 1)
                    a.add(new house(i, j + 1));
                home[i][j] = "-1";
            }
            a.poll();
        }
        return count;
    }


}
class house {
    public house(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x;
    int y;
}








package DFSandBFS;

import java.io.*;
import java.util.*;

public class MazeSearch {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String [][] table = new String[n][m];
        Queue<Node> a = new LinkedList<>();
        int time = 0, temp, r, c;
        boolean reach = false;
        for (int i = 0; i < n; i++)
            table[i] = br.readLine().split("");
        a.add(new Node(0, 0));
        table[0][0] = "-1";
        while(!a.isEmpty()){
            time++;
            temp = a.size();
            for (int i = 0 ; i < temp; i++){
                r = a.peek().row;
                c = a.peek().col;
                if(r == n -1 && c == m - 1)
                    reach = true;
                else {
                    if (r > 0)
                        if(table[r - 1][c].equals("1")) {
                            a.add(new Node(r - 1, c));
                            table[r- 1][c] = "-1";
                        }
                    if (r < n - 1)
                        if(table[r + 1][c].equals("1")) {
                            a.add(new Node(r + 1, c));
                            table[r + 1][c] = "-1";
                        }
                    if (c > 0)
                        if(table[r][c - 1].equals("1")) {
                            a.add(new Node(r, c - 1));
                            table[r][c - 1] = "-1";
                        }
                    if (c < m - 1)
                        if( table[r][c + 1].equals("1")) {
                            a.add(new Node(r, c + 1));
                            table[r][c + 1] = "-1";
                        }
                }
                a.poll();
            }
            if(reach)
                break;
        }

        bw.write(Integer.toString(time));
        bw.flush();
        bw.close();
    }

}
class Node{
    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
    int row;
    int col;

}







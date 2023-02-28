package Simulation;

import java.io.*;
import java.util.*;

public class BallEscape3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, result = -1;
    static String[][] board;
    static boolean[][][][] visited;
    static int[] X_Move = {1, 0, -1, 0};
    static int[] Y_Move = {0, 1, 0, -1};
    static Ball_Index Red, Blue;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new String[n][m];
        visited = new boolean[n][m][n][m];
        Ball_Set temp = null;
        boolean R_hole, B_hole;
        PriorityQueue<Ball_Set> next = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));

        for (int i = 0; i < n; i++)
            board[i] = br.readLine().split("");

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (board[i][j].equals("R"))
                    Red = new Ball_Index(i, j);
                if (board[i][j].equals("B"))
                    Blue = new Ball_Index(i, j);
            }

        next.add(new Ball_Set(1, -1, null,  Red, Blue));

        while (result == -1 && !next.isEmpty()) {
            temp = next.poll();
            visited[temp.a.x][temp.a.y][temp.b.x][temp.b.y] = true;

            if(temp.count > 10)
                break;

            for (int i = 0; i < 4; i++) {
                Red = new Ball_Index(temp.a.x, temp.a.y);
                Blue = new Ball_Index(temp.b.x, temp.b.y);
                R_hole = false;
                B_hole = false;

                while (!board[Red.x + X_Move[i]][Red.y + Y_Move[i]].equals("#")) {
                    Red.x += X_Move[i];
                    Red.y += Y_Move[i];

                    if (board[Red.x][Red.y].equals("O")) {
                        R_hole = true;
                        break;
                    }
                }

                while (!board[Blue.x + X_Move[i]][Blue.y + Y_Move[i]].equals("#")) {
                    Blue.x += X_Move[i];
                    Blue.y += Y_Move[i];

                    if (board[Blue.x][Blue.y].equals("O")) {
                        B_hole = true;
                        break;
                    }
                }

                if (B_hole)
                    continue;
                else if (R_hole) {
                    result = temp.count;
                    Track(i);
                    break;
                }

                if (Red.compare(Blue)) {
                    if (i == 0)
                        if (temp.a.x > temp.b.x) Blue.x--;
                        else Red.x--;
                    if (i == 1)
                        if (temp.a.y > temp.b.y) Blue.y--;
                        else Red.y--;
                    if (i == 2)
                        if (temp.a.x > temp.b.x) Red.x++;
                        else Blue.x++;
                    if (i == 3)
                        if (temp.a.y > temp.b.y) Red.y++;
                        else Blue.y++;
                }

                if (!visited[Red.x][Red.y][Blue.x][Blue.y])
                    next.add(new Ball_Set(temp.count + 1, i, temp, new Ball_Index(Red.x, Red.y), new Ball_Index(Blue.x, Blue.y)));
            }

        }

        bw.write(result + "\n");

        while(result > 0){
            Track(temp.dir);
            temp = temp.Parent;
            result--;
        }
        bw.write(sb.reverse().toString());
        bw.flush();
        bw.close();

    }

    static void Track (int i){
        if(i == 0)
            sb.append("D");
        if(i == 1)
            sb.append("R");
        if(i == 2)
            sb.append("U");
        if(i == 3)
            sb.append("L");
    }

    static class Ball_Set {
        int count, dir;
        Ball_Set Parent;

        public Ball_Set(int count, int dir, Ball_Set parent, Ball_Index a, Ball_Index b) {
            this.count = count;
            this.dir = dir;
            this.Parent = parent;
            this.a = a;
            this.b = b;
        }

        Ball_Index a, b;


    }

    static class Ball_Index {
        int x, y;

        public Ball_Index(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean compare(Ball_Index a) {
            return (a.x == this.x && a.y == this.y);
        }

    }
}
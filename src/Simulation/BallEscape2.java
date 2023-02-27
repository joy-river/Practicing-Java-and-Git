package Simulation;

import java.io.*;
import java.util.*;

public class BallEscape2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, result = -1;
    static String[][] board;
    static Ball_Index Red, Blue, Hole;
    static Queue<Ball_Index> Move = new LinkedList<>();
    static ArrayList<Ball_Index> A_Move = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new String[n][m];
        Ball_Set temp, in = new Ball_Set(0, 0, null , null);
        PriorityQueue<Ball_Set> next = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));

        for (int i = 0 ; i < n ; i++)
            board[i] = br.readLine().split("");

        for (int i = 0 ; i < n ; i++)
            for (int j = 0 ; j < m ; j++){
                if(board[i][j].equals("O"))
                    Hole = new Ball_Index(i , j, "O");
                if(board[i][j].equals("R")) {
                    Red = new Ball_Index(i, j, "R");
                    board[i][j] = ".";
                }
                if(board[i][j].equals("B")) {
                    Blue = new Ball_Index(i, j, "B");
                    board[i][j] = ".";
                }
            }

        next.add(new Ball_Set(0, 0, Red, Blue));

        while(!next.isEmpty()){
            temp = next.poll();
            if(temp.count > 10)
                break;

            if(temp.a.compare(Hole)) {
                if(temp.b.compare(Hole))
                    continue;
                else{
                    result = temp.count;
                    break;
                }
            }
            if(temp.b.compare(Hole))
                continue;

            if(temp.dir != 2 && Move_Left(temp, in))
                next.add(new Ball_Set(in.count,in.dir, in.a, in.b));
            if(temp.dir != 1 && Move_Right(temp, in))
                next.add(new Ball_Set(in.count, in.dir,  in.a, in.b));
            if(temp.dir != 3 && Move_Down(temp, in))
                next.add(new Ball_Set(in.count ,in.dir, in.a, in.b));
            if(temp.dir != 4 && Move_Up(temp, in))
                next.add(new Ball_Set(in.count ,in.dir,  in.a, in.b));
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();

    }
    static boolean Move_Left(Ball_Set temp, Ball_Set in){
        if(temp.a.y < temp.b.y) {
            Move.add(temp.a);
            Move.add(temp.b);
        }
        else{
            Move.add(temp.b);
            Move.add(temp.a);
        }
        Ball_Index a;

        while(!Move.isEmpty()){
            a = Move.poll();
            for (int i = a.y - 1; i >= 0 ;i--){
                if(board[a.x][i].equals("#")) {
                    A_Move.add(new Ball_Index(a.x, i + 1, a.color));
                    break;
                }
                if(board[a.x][i].equals("O")){
                    A_Move.add(new Ball_Index(a.x, i, a.color));
                    break;
                }
                if(!A_Move.isEmpty())
                    if(A_Move.get(0).x == a.x && A_Move.get(0).y == i) {
                        A_Move.add(new Ball_Index(a.x, i + 1, a.color));
                        break;
                    }
            }
        }
        in.count = temp.count + 1;
        in.dir = 1;
        in.a = A_Move.get(0).color.equals("R") ? A_Move.get(0) : A_Move.get(1);
        in.b = A_Move.get(1).color.equals("B") ? A_Move.get(1) : A_Move.get(0);
        A_Move.clear();

        return !in.a.compare(temp.a) || !in.b.compare(temp.b);
    }

    static boolean Move_Right(Ball_Set temp, Ball_Set in){
        if(temp.a.y > temp.b.y) {
            Move.add(temp.a);
            Move.add(temp.b);
        }
        else{
            Move.add(temp.b);
            Move.add(temp.a);
        }
        Ball_Index a;

        while(!Move.isEmpty()){
            a = Move.poll();
            for (int i = a.y + 1; i < m ; i++){
                if(board[a.x][i].equals("#")) {
                    A_Move.add(new Ball_Index(a.x, i - 1, a.color));
                    break;
                }
                if(board[a.x][i].equals("O")){
                    A_Move.add(new Ball_Index(a.x, i, a.color));
                    break;
                }
                if(!A_Move.isEmpty())
                    if(A_Move.get(0).x == a.x && A_Move.get(0).y == i) {
                        A_Move.add(new Ball_Index(a.x, i - 1, a.color));
                        break;
                    }
            }
        }
        in.count = temp.count + 1;
        in.dir = 2;
        in.a = A_Move.get(0).color.equals("R") ? A_Move.get(0) : A_Move.get(1);
        in.b = A_Move.get(1).color.equals("B") ? A_Move.get(1) : A_Move.get(0);
        A_Move.clear();

        return !in.a.compare(temp.a) || !in.b.compare(temp.b);
    }

    static boolean Move_Up(Ball_Set temp, Ball_Set in){
        if(temp.a.x < temp.b.x) {
            Move.add(temp.a);
            Move.add(temp.b);
        }
        else{
            Move.add(temp.b);
            Move.add(temp.a);
        }
        Ball_Index a;

        while(!Move.isEmpty()){
            a = Move.poll();
            for (int i = a.x - 1; i >= 0 ;i--){
                if(board[i][a.y].equals("#")) {
                    A_Move.add(new Ball_Index(i + 1, a.y, a.color));
                    break;
                }
                if(board[i][a.y].equals("O")){
                    A_Move.add(new Ball_Index(i, a.y, a.color));
                    break;
                }
                if(!A_Move.isEmpty())
                    if(A_Move.get(0).x == i && A_Move.get(0).y == a.y) {
                        A_Move.add(new Ball_Index(i + 1, a.y, a.color));
                        break;
                    }
            }
        }

        in.count = temp.count + 1;
        in.dir = 3;
        in.a = A_Move.get(0).color.equals("R") ? A_Move.get(0) : A_Move.get(1);
        in.b = A_Move.get(1).color.equals("B") ? A_Move.get(1) : A_Move.get(0);
        A_Move.clear();

        return !in.a.compare(temp.a) || !in.b.compare(temp.b);
    }

    static boolean Move_Down(Ball_Set temp, Ball_Set in){
        if(temp.a.x > temp.b.x) {
            Move.add(temp.a);
            Move.add(temp.b);
        }
        else{
            Move.add(temp.b);
            Move.add(temp.a);
        }
        Ball_Index a;

        while(!Move.isEmpty()){
            a = Move.poll();
            for (int i = a.x + 1; i < n ;i++){
                if(board[i][a.y].equals("#")) {
                    A_Move.add(new Ball_Index(i - 1, a.y, a.color));
                    break;
                }
                if(board[i][a.y].equals("O")){
                    A_Move.add(new Ball_Index(i, a.y, a.color));
                    break;
                }
                if(!A_Move.isEmpty())
                    if(A_Move.get(0).x == i && A_Move.get(0).y == a.y) {
                        A_Move.add(new Ball_Index(i - 1, a.y, a.color));
                        break;
                    }
            }
        }

        in.count = temp.count + 1;
        in.dir = 4;
        in.a = A_Move.get(0).color.equals("R") ? A_Move.get(0) : A_Move.get(1);
        in.b = A_Move.get(1).color.equals("B") ? A_Move.get(1) : A_Move.get(0);
        A_Move.clear();

        return !in.a.compare(temp.a) || !in.b.compare(temp.b);
    }


    static class Ball_Set {
        int count, dir;
        Ball_Index a, b;

        public Ball_Set(int count, int dir, Ball_Index a, Ball_Index b) {
            this.count = count;
            this.dir = dir;
            this.a = a;
            this.b = b;
        }
    }
    static class Ball_Index {
        int x, y;
        String color;

        public Ball_Index(int x, int y, String color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public boolean compare(Ball_Index a){
            return (a.x == this.x && a.y == this.y);
        }
    }


}

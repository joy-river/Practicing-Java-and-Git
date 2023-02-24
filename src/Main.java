import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, result = 11;
    static String[][] board;
    static Ball_Index Red, Blue, Hole;
    static Queue<Ball_Index> Move = new LinkedList<>();
    static ArrayList<Ball_Index> A_Move = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new String[n][m];
        Ball_Set temp;
        PriorityQueue<Ball_Set> next = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));

        for (int i = 0 ; i < n ; i++)
            board[i] = br.readLine().split("");

        for (int i = 0 ; i < n ; i++)
            for (int j = 0 ; j < m ; j++){
                if(board[i][j].equals("O"))
                    Hole = new Ball_Index(i , j, "O");
                if(board[i][j].equals("R"))
                    Red = new Ball_Index(i, j, "R");
                if(board[i][j].equals("B"))
                    Blue = new Ball_Index(i, j , "B");
            }

        next.add(new Ball_Set(0, Red, Blue));

        while(!next.isEmpty()){
            temp = next.poll();

            if(temp.a.compare(Hole) && !temp.a.compare(Hole)){
                result = Math.min(result, temp.count);
                break;
            }

            next.add(Move_Left(temp));
           // next.add(Move_Right(temp));
           // next.add(Move_Up(temp));
            //next.add(Move_Down(temp));
        }

        bw.write(result < 11 ? Integer.toString(result) : "-1");
        bw.flush();
        bw.close();

    }
    static Ball_Set Move_Left(Ball_Set temp){
        Move.add(temp.a);
        Move.add(temp.b);
        Ball_Index a;

        while(!Move.isEmpty()){
            a = Move.poll();
            board[a.x][a.y] = ".";
            for (int i = a.y - 1; i >= 0 ;i--){
                if(board[a.x][i].equals("#")) {
                    A_Move.add(new Ball_Index(a.x, i + 1, a.color));
                    break;
                }
                if(board[a.x][i].equals("R") || board[a.x][i].equals("B")){
                   if(Move.isEmpty()) {
                       A_Move.add(new Ball_Index(a.x, i + 1, a.color));
                   }
                   else
                       Move.add(a);
                    break;
                }
                if(board[a.x][i].equals("O")){
                    A_Move.add(new Ball_Index(a.x, i, a.color));
                    break;
                }
            }
        }

        for (Ball_Index I : A_Move)
            board[I.x][I.y] = I.color;

        return new Ball_Set(temp.count + 1, A_Move.remove(0), A_Move.remove(0));
    }


    static class Ball_Set {
        int count;
        Ball_Index a, b;

        public Ball_Set(int count, Ball_Index a, Ball_Index b) {
            this.count = count;
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

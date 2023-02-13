package BackTracking;

import java.io.*;
import java.util.*;


public class Sudoku {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[][] input = new String[9][9];
    static ArrayList<Sudoku_Empty> empty = new ArrayList<>();
    static HashSet<Integer>[][] table = new HashSet[3][9];

    public static void main(String[] args) throws IOException {
        for (int i = 0 ; i < 3 ; i++)
            for (int j = 0 ; j < 9; j++)
                table[i][j] = new HashSet<>();

        for (int i = 0 ; i < 9 ; i++) {
            input[i] = br.readLine().split("");
            for (int j = 0 ; j < 9 ; j++){
                if(input[i][j].equals("0"))
                    empty.add(new Sudoku_Empty(i, j));
                else
                    Add(i, j , Integer.parseInt(input[i][j]));
            }
        }

        Sudoku(0);

    }

    static void Sudoku(int index) throws IOException {
        if(index >= empty.size()){
            for (int i = 0 ; i < 9 ; i++){
                for (int j = 0; j < 9 ; j++)
                    bw.write(input[i][j]);
                bw.write("\n");
            }
            bw.flush();
            bw.close();
            System.exit(0);
        }
        int x = empty.get(index).x;
        int y = empty.get(index).y;

        for (int i = 1 ; i < 10; i++)
            if(Sudoku_Check(x, y, i)){
                Add(x, y, i);
                Sudoku(index + 1);
                Remove(x, y, i);
            }


    }
    static boolean Sudoku_Check(int x, int y, int i){
        return !table[0][x].contains(i) && !table[1][y].contains(i) && !table[2][3 * (x /3) + y / 3].contains(i);
    }
    static void Add(int x, int y, int i){
        table[0][x].add(i);
        table[1][y].add(i);
        table[2][3 * (x / 3) + y / 3].add(i);
        input[x][y] = Integer.toString(i);
    }
    static void Remove(int x, int y, int i){
        table[0][x].remove(i);
        table[1][y].remove(i);
        table[2][3 * (x / 3) + y / 3].remove(i);
        input[x][y] = "0";
    }


}

class Sudoku_Empty{
    int x, y;

    public Sudoku_Empty(int x, int y) {
        this.x = x;
        this.y = y;
    }
}



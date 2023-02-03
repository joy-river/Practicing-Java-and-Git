package BackTracking;

import java.io.*;
import java.util.*;


public class Bishop {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int Pick_Count = 0;
    static HashSet<Integer> picked = new HashSet<>();
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        String[][] chess = new String[n][];
        list = new ArrayList[2 * n];
        int count = 0;


        for (int i = 0 ; i < 2 * n ; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < n ; i ++) {
            chess[i] = br.readLine().split(" ");
            for (int j = 0 ; j < n ; j++)
                if(chess[i][j].equals("1"))
                    list[i + j].add( i - j - n);
        }

        Fill_Chess(0, 0);
        count += Pick_Count;
        Pick_Count = 0;
        Fill_Chess(1, 0);
        Pick_Count += count;

        bw.write(Integer.toString(Pick_Count));
        bw.flush();
        bw.close();
    }

    static void Fill_Chess(int index, int count) throws IOException {
        Pick_Count = Math.max(Pick_Count, count);
        if(index >= list.length)
            return;

        if(count + list.length - index <= Pick_Count)
            return;

        int Called = 0;

        for (Integer a : list[index]){
            if(!picked.contains(a)){
                picked.add(a);
                Fill_Chess(index + 2, count + 1);
                picked.remove(a);
                Called++;
            }
        }

        if(Called == 0)
            Fill_Chess(index + 2, count);

    }

}








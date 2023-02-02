import java.io.*;
import java.security.Policy;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int Pick_Count = 0;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        String[][] chess = new String[n][];
        ArrayList<Bishop> Possible = new ArrayList<>();

        for (int i = 0; i < n ; i ++) {
            chess[i] = br.readLine().split(" ");
            for (int j = 0 ; j < n ; j++)
                if(chess[i][j].equals("1"))
                    Possible.add(new Bishop(i + j, i - j - n));
        }

            Fill_Chess(new HashSet<>(), Possible,0, 0);




        bw.write(Integer.toString(Pick_Count));
        bw.flush();
        bw.close();
    }

    static void Fill_Chess(HashSet<Integer> picked, ArrayList<Bishop> list,int index, int count){
        if(index == list.size())
            Pick_Count = Math.max(Pick_Count, count);
        else if (count + list.size() - index < Pick_Count)
            return;
        else {
            Bishop temp = list.get(index);
            if (!picked.contains(temp.DR) && !picked.contains(temp.UR)) {
                picked.add(temp.DR);
                picked.add(temp.UR);
                Fill_Chess(picked, list, index + 1, count + 1);
                picked.remove(temp.DR);
                picked.remove(temp.UR);
            }
             Fill_Chess(picked, list, index + 1, count);
        }

    }

}
class Bishop{
    int UR, DR;

    public Bishop(int UR, int DR) {
        this.UR = UR;
        this.DR = DR;
    }
}








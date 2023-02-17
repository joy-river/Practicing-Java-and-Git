import javax.crypto.Cipher;
import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String [][] Memo_Cost = new String[2][];
    static int [][] Dp_Cost;
    static int n, m, Min_Cost = Integer.MAX_VALUE, Max_Cost = 0;
    static Queue<Integer> Recent_Cost = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < 2 ; i++)
            Memo_Cost[i] = br.readLine().split(" ");
        for(String a : Memo_Cost[1])
            Max_Cost += Integer.parseInt(a);

        Dp_Cost = new int[Max_Cost + 1][n + 1];

        ShutDownApp();

        bw.write(Integer.toString(Min_Cost));
        bw.flush();
        bw.close();

    }

    static void ShutDownApp (){
        Recent_Cost.add(0);


        for(int i = 0; i <= Max_Cost; i++){
            for (int j = 1; j <= n; j++) {
                int i_Memory = Integer.parseInt(Memo_Cost[0][i - 1]);
                int i_Cost = Integer.parseInt(Memo_Cost[1][i - 1]);
                int q_Size = Recent_Cost.size();
                int cost;
            }



        }
    }


}



package TRAAAASH;

import java.io.*;

public class nqueeeeeeeeen {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] chess = new int [n];
        int [] count = {0};
        nqueen(chess,n,0,count);
        System.out.println(count[0]);
        bw.flush();
    }
    static void nqueen(int[]chess,int n, int dep, int[] count) throws IOException {
        if (dep == n) {
            count[0]++;
            return;
        }
        for (int i = 0 ; i < n ; i ++){
            chess[dep] = i;
            if(okay(chess, dep)){
                nqueen(chess, n , dep + 1, count);
            }
            chess[dep] = 0;
        }
    }
    static boolean okay(int[] chess, int dep){
        for (int i = 0 ; i < dep; i++){
            if(chess[i] == chess[dep])
                return false;
            if(Math.abs(chess[i] - chess[dep]) == Math.abs(dep - i))
                return false;
        }
        return true;
    }
}



package DFSandBFS;

import java.io.*;
import java.util.*;

public class HideandSeek {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(n >= k)
            bw.write(Integer.toString(n- k));
        else
            bw.write(Integer.toString(hide(n, k)));
        bw.flush();
        bw.close();
    }
    static int hide (int n, int k){
        Queue<Integer> a = new LinkedList<>();
        boolean [] save = new boolean[100001];
        int time = 1, result = -1, temp;
        if(n > 0) {a.add(n - 1); save[n-1] = true;}
        if(n < 100000) {a.add(n + 1); save[n + 1] = true;}
        if(2 * n <= 100000) {a.add(2 * n); save[2 * n] = true;}
        while(result == -1  && !a.isEmpty()){
            temp = a.size();
            for(int i = 0; i < temp; i ++){
                if(a.peek() == k) {
                    result = time;
                    break;
                }
                else{
                    if(a.peek() > 0 && !save[a.peek() - 1]) {a.add(a.peek() - 1); save[a.peek() - 1] = true;}
                    if(a.peek() < 100000 && !save[a.peek() + 1]){a.add(a.peek() + 1); save[a.peek() + 1] = true;}
                    if(a.peek() * 2 <= 100000 && !save[a.peek() * 2]){a.add(a.peek() * 2); save[a.peek() *2] = true;}
                    a.poll();
                }
            }
            time++;
        }
        return result;




    }
}






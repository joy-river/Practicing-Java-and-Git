package Queue;

import java.io.*;
import java.util.*;

public class Josephus {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Queue<Integer> que = new LinkedList<>();
        String[] nk = br.readLine().split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        int count = 1;

        for (int i = 1; i <= Integer.parseInt(nk[0]); i ++)
            que.add(i);
        while(!que.isEmpty()){
            if(count != Integer.parseInt(nk[1]))
                que.add(que.poll());
            else{
                arr.add(que.poll());
                count = 0;
            }
            count ++;
        }
        bw.write("<");
        for (int i = 0; i < arr.size() - 1; i++)
            bw.write(arr.get(i) + ", ");
        bw.write(arr.get(arr.size() - 1) +">");
        bw.flush();
        bw.close();
    }

}

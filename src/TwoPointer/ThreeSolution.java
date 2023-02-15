package TwoPointer;

import java.io.*;
import java.util.*;


public class ThreeSolution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Long> Ph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n ; i++)
            Ph.add(Long.parseLong(st.nextToken()));

        Collections.sort(Ph);
        int Head, Tail;
        long Min_Head = 0, Min_tail = 0, Min_First = 0;
        long Ph_Min = Long.MAX_VALUE;
        long Ph_temp;

        for (int i = 0 ; i < n - 2; i ++) {
            Head = i + 1;
            Tail = n - 1;
            while (Head < Tail) {
                Ph_temp = Ph.get(Head) + Ph.get(Tail) + Ph.get(i);
                if (Math.abs(Ph_temp) <= Ph_Min) {
                    Ph_Min = Math.abs(Ph_temp);
                    Min_Head = Ph.get(Head);
                    Min_tail = Ph.get(Tail);
                    Min_First = Ph.get(i);
                }
                if (Ph_temp < 0)
                    Head++;
                else
                    Tail--;
            }
        }


        bw.write(Min_First + " " + Min_Head  + " " + Min_tail);
        bw.flush();
        bw.close();


    }

}



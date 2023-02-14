package TwoPointer;

import java.io.*;
import java.util.*;


public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] Ph = new int[n];


        for (int i = 0; i < n ; i++)
            Ph[i] = Integer.parseInt(st.nextToken());

        int Head = 0, Tail = n - 1, Min_Head = 0, Min_tail = 0, Ph_Min = Integer.MAX_VALUE, Ph_temp;

        while(Head < Tail && Ph_Min != 0){
            Ph_temp = Ph[Head] + Ph[Tail];
            if(Math.abs(Ph_temp) <= Ph_Min){
                Ph_Min = Math.abs(Ph_temp);
                Min_Head = Ph[Head];
                Min_tail = Ph[Tail];
            }
            if(Ph_temp < 0)
                Head++;
            else
                Tail--;
        }


        bw.write(Min_Head +" " + Min_tail);
        bw.flush();
        bw.close();


    }



}



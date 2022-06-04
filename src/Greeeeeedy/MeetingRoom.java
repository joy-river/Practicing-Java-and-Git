package Greeeeeedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class MeetingRoom {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int count = 0, end = 0;
        int [][] time = new int [n][2];

        for (int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, (o1, o2) -> o1[1] == o2[1] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));

        for (int i = 0 ; i < n ; i++)
            if(time[i][0] >= end) {
                end = time[i][1];
                count++;
            }

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }

}


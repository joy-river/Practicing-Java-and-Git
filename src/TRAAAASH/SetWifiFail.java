package TRAAAASH;

import java.io.*;
import java.util.*;

public class SetWifiFail {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Long> wire = new ArrayList<>();
    static int m;
    static long output = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0 ; i < n ; i ++)
            wire.add(Long.parseLong(br.readLine()));

        Collections.sort(wire);
        output = setwifi(0, n- 1, m - 2);
        bw.write(Long.toString(output));
        bw.flush();
        bw.close();
    }

    static long setwifi(int start, int end, int m) throws IOException{
        if(m == 0)
            return wire.get(end) - wire.get(start);
        else {
            long mid =  ((wire.get(start) + wire.get(end)) / 2);
            int index = insert(start, end, mid, start, end);
            long left = 0;
            long right= 0;
            if(index - start >= m)
                left = setwifi(start, index, m - 1);
            if(end - index  >= m)
                right = setwifi(index, end, m - 1);

            return m == 1 ? Math.min(left,right) : Math.max(left,right);

        }
    }
    static int insert(int start, int end, long mid, int ostart, int oend){
        int index = (start + end) / 2;
        if(start == end|| start > end){
            if(index == ostart)
                return index + 1;
            else if (index == oend)
                return index - 1;
            else{
                if(mid > wire.get(index))
                    return mid - wire.get(index) < wire.get(index + 1) - mid ? index : index + 1;
                else
                    return wire.get(index) - mid < mid - wire.get(index -1) ? index: index - 1;
            }
        }
        else {
            if (mid > wire.get(index))
                return insert(index + 1 , end, mid , ostart, oend);
            else if (mid < wire.get(index))
                return insert(start, index - 1, mid, ostart, oend);
            else
                return index;
        }
    }

}




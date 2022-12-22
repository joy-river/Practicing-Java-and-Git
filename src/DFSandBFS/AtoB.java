package DFSandBFS;

import java.io.*;
import java.util.*;

public class AtoB {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        bw.write(Integer.toString(AtoB(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))));
        bw.flush();
        bw.close();
    }
    static int AtoB(int a, int b){
        ATOB temp;
        PriorityQueue<ATOB> next = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));
        next.add(new ATOB(a, 1));


        while(!next.isEmpty()){
            temp = next.poll();
            if(temp.num == b)
                return temp.count;
            else{
                if(2 * temp.num <= b) next.add(new ATOB(2 * temp.num, temp.count + 1));
                if(10 * temp.num + 1 <= b) next.add(new ATOB(10 * temp.num + 1, temp.count + 1));
            }
        }
        return -1;
    }
}
class ATOB {
    long num;

    public ATOB(long num, int count) {
        this.num = num;
        this.count = count;
    }

    int count;


}








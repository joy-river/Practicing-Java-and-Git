import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String temp;
        int input;
        StringTokenizer st;
        for (int i = 0 ; i < n ; i ++) {
            PriorityQueue<Integer> dual = new PriorityQueue<>();
            PriorityQueue<Integer> reverse = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());
            temp = st.nextToken();
            input = Integer.parseInt(st.nextToken());
            if(temp.equals("I")){dual.add(Integer.parseInt(st.nextToken())); reverse.add(input);}
            if(temp.equals("D")){
                if(!dual.isEmpty()){
                    if(input == 1){dual.poll()};
                    if(input == -1){dual.remove(dual.)}
                }
                    dual.remove(Integer.parseInt(st.nextToken()));}
        }



        bw.flush();
        bw.close();

    }

}

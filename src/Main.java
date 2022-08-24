import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> allset = new HashSet<>();
        StringTokenizer st;
        String input;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            input = st.nextToken();
            switch (input){
                case "all" : set.addAll(o1 ->  if(o1 < 1))
                case "add" : set.add(Integer.parseInt(st.nextToken())); break;
                case "remove" : set.remove(Integer.parseInt(st.nextToken())); break;
                case "check" : bw.write(set.contains(Integer.parseInt(st.nextToken())) ?  1 : 0); break;
                case "toggle" : set.contains(Integer.parseInt(st.nextToken()))? set.remove()
            }
        }

        bw.flush();
        bw.close();
    }



}




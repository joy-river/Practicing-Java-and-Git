import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> all = new HashSet<>();
        for (int i = 1 ; i < 21 ;i ++)
            all.add(i);
        StringTokenizer st;
        String input;
        int temp;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            input = st.nextToken();
            switch (input){
                case "all" : set.addAll(all); break;
                case "empty" : set.removeAll(all); break;
                case "add" : set.add(Integer.parseInt(st.nextToken())); break;
                case "remove" : set.remove(Integer.parseInt(st.nextToken())); break;
                case "check" : bw.write(set.contains(Integer.parseInt(st.nextToken()))  ?  1 +"\n" : 0 + "\n"); break;
                case "toggle" : if(set.contains(temp = Integer.parseInt(st.nextToken()))) set.remove(temp); else set.add(temp); break;
            }
        }

        bw.flush();
        bw.close();
    }



}




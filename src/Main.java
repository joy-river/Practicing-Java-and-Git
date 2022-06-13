import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Deque<Integer> deq = new LinkedList<>();
        int n = Integer.parseInt(br.readLine()), k;
        boolean rev, error;
        StringBuilder sb = new StringBuilder();
        String [] func, num;

        for (int i = 0 ; i < n ; i ++){
            rev = false;
            error = false;
            func = br.readLine().split("");
            k = Integer.parseInt(br.readLine());
            num = br.readLine().split("");
            while(k != 0)
                deq.add(Integer.parseInt(num[2 * k-- - 1]));
            for (String s : func) {
                if (s.equals("R"))
                    rev = !rev;
                else if (deq.isEmpty()) {
                    error = true;
                    break;
                }
                else if (rev) deq.removeLast();
                else deq.removeFirst();
            }
            if(error)
                sb.append("error" + "\n");
            else{
                sb.append("[");
                if(rev)
                    while(!deq.isEmpty()) sb.append(deq.pollLast() + ",");
                else
                    while(!deq.isEmpty()) sb.append(deq.pollFirst() + ",");
                sb.replace(sb.length() - 1, sb.length() - 1, "]" + "\n");
            }
        }



        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}

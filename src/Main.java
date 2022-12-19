import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static HashSet<String> dupe = new HashSet<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; i++)
            list.add(Integer.parseInt(st.nextToken()));

        Collections.sort(list);

        print(new StringBuilder(), list, 0, 0);

        bw.flush();
        bw.close();
    }

    static void print(StringBuilder sb, ArrayList<Integer> list, int index, int count) throws IOException {
        if(count == m - 1)
            while (index < n) {
                if(!dupe.contains(sb.toString() + list.get(index))) {
                    dupe.add(sb.toString() + list.get(index));
                    bw.write(sb.toString() + list.get(index) + "\n");
                }
                index++;
            }
        else while(index < n)
            print(new StringBuilder(sb).append(list.get(index)).append(" "), list, index++, count + 1);
    }

}








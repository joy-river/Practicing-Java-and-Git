import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<String> a = new ArrayList<>();
        LinkedHashSet<String> b = new LinkedHashSet<>();
        String temp;
        for (int i = 0 ; i < n;  i++)
            b.add(br.readLine());
        for (int i = 0 ; i < m ; i++){
            temp = br.readLine();
            if(temp.charAt(0) > 64)
                bw.write(b. + 1 + "\n");
            else
                bw.write(a.get(Integer.parseInt(temp) - 1) + "\n");
        }

        bw.flush();
        bw.close();
    }
}





import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, r;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int a, b, c;
        Item[] place = new Item[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n ; i++)
            place[i] = new Item(i, Integer.parseInt(st.nextToken()), new HashMap<>());
        for (int i = 0; i < r; i ++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            place[a].link.put(b, c);
            place[b].link.put(a, c);
        }


        bw.flush();
        bw.close();
    }
    static int Get_Item(int )

}
class Item {
    int num;
    int num_item;
    HashMap<Integer, Integer> link;

    public Item(int num, int num_item, HashMap<Integer, Integer> link) {
        this.num = num;
        this.num_item = num_item;
        this.link = link;
    }
}








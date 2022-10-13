import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static node[] man;

    public static void main(String[] args) throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int temp, count = 0;
            String[] party = new String[m];
            man = new node[n + 1];

            for (int i = 1 ; i <= n ; i++)
                man[i] = new node(i, new ArrayList<>(), i, false);

            st = new StringTokenizer(br.readLine());
            temp = Integer.parseInt(st.nextToken());

            if(temp == 0){
                bw.write(Integer.toString(m));
            }
            else {
                for (int i = 0; i < temp; i++)
                    man[Integer.parseInt(st.nextToken())].know = true;
                for (int i = 0; i <m; i++){
                    party[i] = br.readLine();
                    Union(party[i]);
                }
                for (int i = 0 ; i < m ; i++)
                    if(Know(party[i]))
                        count++;
                bw.write(Integer.toString(m - count));
            }


            bw.flush();
            bw.close();

    }
    static void Union (String input){
        StringTokenizer st = new StringTokenizer(input);
        ArrayList<node> union =  new ArrayList<>();
        int temp = Integer.parseInt(st.nextToken());
        for (int i = 0 ; i < temp; i++)
            union.add(man[Integer.parseInt(st.nextToken())]);
        for (int i = 0 ; i < temp; i++){
            if(!union.get(i).know){
                union.get(i).point.addAll(union);
                Find(union.get(i));
            }
        }
    }
    static void Find(node input){
        for (int i = 0 ; i < input.point.size(); i++){
            if(input.point.get(i).know){
                input.know = true;
                input.parent = input.point.get(i).parent;
                break;
            }
        }
        input.point.clear();
    }
    static boolean Know(String input){
        StringTokenizer st = new StringTokenizer(input);
        int temp  =  Integer.parseInt(st.nextToken());
        for (int i = 0  ;  i<  temp ; i++)
            if(man[Integer.parseInt(st.nextToken())].know)
                return true;
        return false;
    }
}
class node {
    public node(int self, ArrayList<node> point, int parent, boolean know) {
        this.self = self;
        this.point = point;
        this.parent = parent;
        this.know = know;
    }

    int self;
    ArrayList<node> point;
    int parent;
    boolean know;
}


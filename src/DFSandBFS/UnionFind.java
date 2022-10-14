package DFSandBFS;

import java.io.*;
import java.util.*;

public class UnionFind {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static NODE[] man;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int knew , temp, count = 0;
        Queue<NODE> find = new LinkedList<>();
        String[] party = new String[m];
        man = new NODE[n + 1];

        for (int i = 1 ; i <= n ; i++)
            man[i] = new NODE(i, new HashSet<>(), i, false);

        st = new StringTokenizer(br.readLine());
        temp = Integer.parseInt(st.nextToken());

        if(temp == 0){
            bw.write(Integer.toString(m));
        }
        else {
            for (int i = 0; i < temp; i++) {
                knew = Integer.parseInt(st.nextToken());
                man[knew].know = true;
                find.add(man[knew]);
            }
            for (int i = 0; i <m; i++){
                party[i] = br.readLine();
                Union(party[i]);
            }

            while(!find.isEmpty()){
                Find(find.peek());
                find.addAll(find.peek().point);
                find.poll().point.clear();
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
        ArrayList<NODE> union =  new ArrayList<>();
        int temp = Integer.parseInt(st.nextToken());
        for (int i = 0 ; i < temp; i++)
            union.add(man[Integer.parseInt(st.nextToken())]);
        for (int i = 0 ; i < temp; i++)
            union.get(i).point.addAll(union);
    }

    static void Find(NODE input){
        if(input.know){
            for (NODE j : input.point){
                if(!j.know){
                    j.know = true;
                    j.parent = input.parent;
                }
            }
        }
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
class NODE {
    public NODE(int self, HashSet<NODE> point, int parent, boolean know) {
        this.self = self;
        this.point = point;
        this.parent = parent;
        this.know = know;
    }

    int self;
    HashSet<NODE> point;
    int parent;
    boolean know;
}


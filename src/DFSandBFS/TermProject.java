package DFSandBFS;

import java.io.*;
import java.util.*;

public class TermProject {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n ; i ++)
            bw.write(Term_Project() + "\n");


        bw.flush();
        bw.close();
    }
    static HashSet<Integer> team;
    static HashSet<Integer> Not_team;
    static int [] link;

    static int Term_Project() throws IOException{
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        team = new HashSet<>();
        Not_team = new HashSet<>();
        link = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= n ; i++)
            link[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++)
            Is_Cycle(i);

        return Not_team.size();
    }

    static void Is_Cycle(int a){
        HashSet<Integer> Appeared = new HashSet<>();
        Queue<Integer> save = new LinkedList<>();

        while(!Appeared.contains(a)){
            if(team.contains(a) || Not_team.contains(a))
                break;
            Appeared.add(a);
            save.add(a);
            a = link[a];
        }

        while(!save.isEmpty()){
            if(save.peek() != a) {
                save.poll();
            }
            else{
                team.addAll(save);
                save.forEach(Appeared::remove);
                Not_team.addAll(Appeared);
                return;
            }
        }

        Not_team.addAll(Appeared);



    }



}
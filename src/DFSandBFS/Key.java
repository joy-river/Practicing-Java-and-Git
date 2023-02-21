package DFSandBFS;

import java.io.*;
import java.util.*;

public class Key {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n ; i++)
            bw.write(Stealing() + "\n");


        bw.flush();
        bw.close();
    }
    static int Stealing() throws IOException{
        StringTokenizer st= new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        String[][] Building = new String[h + 1][];
        boolean [][] visited = new boolean[h][w];
        Queue<Steal_Index> next = new LinkedList<>();
        int Get = 0, x, y;
        Steal_Index temp;

        for (int i = 0 ; i <= h ; i++)
            Building[i] = br.readLine().split("");

        HashSet<String> Keys = new HashSet<>(List.of(Building[h]));
        HashMap<String, Queue<Steal_Index>> Waiting = new HashMap<>();
        Entrance(Building, visited, next, h, w);

        while(!next.isEmpty()) {
            temp = next.poll();
            x = temp.x;
            y = temp.y;
            String tile = Building[x][y];

            if(tile.equals("$"))
                Get++;
            else if (tile.equals("*"))
                continue;
            else if (tile.equals("."));
            else if (tile.charAt(0) > 95) {
                Keys.add(tile);
                if(Waiting.containsKey(tile))
                    next.addAll(Waiting.get(tile));
            }
            else if(!Keys.contains(tile.toLowerCase())) {
                if(!Waiting.containsKey(tile.toLowerCase()))
                    Waiting.put(tile.toLowerCase(), new LinkedList<>());
                Waiting.get(tile.toLowerCase()).add(temp);
                continue;
            }


            if (x > 0 && !visited[x - 1][y]) {
                visited[x - 1][y] = true;
                if(!Building[x - 1][y].equals("*"))
                    next.add(new Steal_Index(x - 1, y));
            }
            if (y > 0 && !visited[x][y - 1]) {
                visited[x][y - 1] = true;
                if(!Building[x][y - 1].equals("*"))
                    next.add(new Steal_Index(x, y - 1));
            }
            if (x < h - 1 && !visited[x + 1][y]) {
                visited[x + 1][y] = true;
                if(!Building[x + 1][y].equals("*"))
                    next.add(new Steal_Index(x + 1, y));
            }
            if (y < w - 1 && !visited[x][y + 1]) {
                visited[x][y + 1] = true;
                if(!Building[x][y + 1].equals("*"))
                    next.add(new Steal_Index(x, y + 1));
            }
        }

        return Get;


    }
    static void Entrance (String[][] Building, boolean[][] visited, Queue<Steal_Index> next , int h, int w){
        for(int i = 0 ; i < h ; i ++){
            if(!visited[i][0] && !Building[i][0].equals("*")) {
                visited[i][0] = true;
                next.add(new Steal_Index(i, 0));
            }
            if(!visited[i][w - 1] && !Building[i][w - 1].equals("*")) {
                visited[i][w - 1] = true;
                next.add(new Steal_Index(i, w - 1));
            }
        }
        for (int i = 0 ; i < w; i ++){
            if(!visited[0][i] && !Building[0][i].equals("*")) {
                visited[0][i] = true;
                next.add(new Steal_Index(0, i));
            }
            if(!visited[h - 1][i] && !Building[h - 1][i].equals("*")) {
                visited[h - 1][i] = true;
                next.add(new Steal_Index(h - 1, i));
            }
        }
    }

    static class Steal_Index{
        int x, y;

        public Steal_Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
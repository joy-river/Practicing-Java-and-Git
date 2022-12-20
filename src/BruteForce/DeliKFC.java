package BruteForce;

import java.io.*;
import java.util.*;

public class DeliKFC {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int result = Integer.MAX_VALUE, n, m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        String[][] table = new String[n][];
        ArrayList<kfc> kfcs = new ArrayList<>();
        ArrayList<house> houses = new ArrayList<>();

        for (int i = 0; i < n; i ++)
            table[i] = br.readLine().split(" ");

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0; j < n; j++)
                if (table[i][j].equals("2"))
                    kfcs.add(new kfc(i, j));
                else if (table[i][j].equals("1"))
                    houses.add(new house(i, j));
        }

        for (int i = 0; i < kfcs.size() ; i++) {
            ArrayList<Integer> dist = new ArrayList<>();
            for (house house : houses)
                dist.add(Math.abs(house.x - kfcs.get(i).x) + Math.abs(house.y - kfcs.get(i).y));
            kfcdist(i, 1, kfcs, houses, dist);
        }



        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }
    static void kfcdist(int index, int count, ArrayList<kfc> kfcs, ArrayList<house> houses, ArrayList<Integer> dist){
        int sum = 0;
        int x, y;

        if(count == m){
            for (Integer dists : dist)
                sum += dists;
            result = Math.min(result, sum);
        }
        else{
            for (int i = index + 1; i < kfcs.size(); i++) {
                ArrayList<Integer> a = new ArrayList<>();
                x = kfcs.get(i).x;
                y = kfcs.get(i).y;
                for (int j = 0; j < houses.size(); j++)
                    a.add(Math.min(dist.get(j), Math.abs(houses.get(j).x - x) + Math.abs(houses.get(j).y - y)));
                kfcdist(i, count + 1, kfcs, houses, a);
            }
        }
    }
}
class kfc{
    int x;

    public kfc(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int y;
}

class house extends kfc {

    public house(int x, int y) {
        super(x, y);
    }


}







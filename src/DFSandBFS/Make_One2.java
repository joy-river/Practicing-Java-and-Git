package DFSandBFS;

import java.io.*;
import java.util.*;

public class Make_One2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Make_One> next = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));
        Make_One temp;
        ArrayList<Integer> result = new ArrayList<>();
        next.add(new Make_One(0, n, null));

        while(!next.isEmpty()){
            temp = next.poll();

            if(temp.num == 1){
                bw.write(temp.count + "\n");
                while(temp != null){
                    result.add(temp.num);
                    temp = temp.Parent;
                }
                break;
            }

            if(temp.num % 3 == 0)
                next.add(new Make_One(temp.count + 1, temp.num / 3, temp));
            if(temp.num % 2 == 0)
                next.add(new Make_One(temp.count + 1, temp.num / 2, temp));
            if(temp.num > 1)
                next.add(new Make_One(temp.count + 1, temp.num - 1, temp));

        }
        Collections.reverse(result);

        for (Integer a : result)
            bw.write(a + " ");

        bw.flush();
        bw.close();

    }

    static class Make_One{
        int count, num;
        Make_One Parent;

        public Make_One(int count, int num, Make_One parent) {
            this.count = count;
            this.num = num;
            Parent = parent;
        }
    }

}
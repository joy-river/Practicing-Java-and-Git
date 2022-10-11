package PriorityQueue;

import java.io.*;
import java.util.*;

public class DoubleEnd {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int temp, m;
        String DI;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            m = Integer.parseInt(br.readLine());
            TreeSet<node> test = new TreeSet<node>(((o1, o2) -> {
                if(o1.input == o2.input)
                    return Integer.compare(o1.overlap, o2.overlap);
                else
                    return Integer.compare(o1.input, o2.input);
            }));
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                DI = st.nextToken();
                temp = Integer.parseInt(st.nextToken());
                if (DI.equals("I"))
                    test.add(new node(temp, j));
                else {
                    if (!test.isEmpty()) {
                        if (temp == 1)
                            test.remove(test.last());

                        else
                            test.remove(test.first());
                    }
                }

            }

            if (test.isEmpty())
                bw.write("EMPTY\n");
            else
                bw.write(test.last().input + " " + test.first().input + "\n");

        }
        bw.flush();
        bw.close();

    }
}
class node{
    int input;

    public node(int input, int overlap) {
        this.input = input;
        this.overlap = overlap;
    }

    int overlap;
}

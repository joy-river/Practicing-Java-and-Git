package divandconq;

import java.io.*;
import java.util.StringTokenizer;

public class Histogram {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] input;
    static node[] seg;
    static long output = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n;
        while (true) {
            n = Integer.parseInt(st.nextToken());
            if (n == 0)
                break;
            else {
                input = new long[n];
                seg = new node[1 << ((int) Math.ceil(Math.log10(n) / Math.log10(2)) + 1)];
                for (int i = 0; i < n; i++)
                    input[i] = Long.parseLong(st.nextToken());
            }
            output = 0;
            inseg(1, 0, n - 1);
            hist(0, n - 1);
            bw.write(output + "\n");
            st = new StringTokenizer(br.readLine());
        }

        bw.flush();
        bw.close();
    }
    static node inseg (int index, int start, int end){
        if(start == end)
            seg[index] = new node(start, end, start, input[start]);
        else {
            node left = inseg(2 * index, start, (start + end) / 2);
            node right = inseg(2 * index + 1, (start + end) / 2 + 1, end );
            if(left.val > right.val)
                seg[index] = new node(start, end , right.origin, right.val);
            else
                seg[index] = new node(start, end, left.origin, left.val);
        }
        return seg[index];
    }

    static node find(int index, int start, int end){
        if(start > seg[index].end || end < seg[index].start) return new node(0 , 0 , 0, 1000000000000000000L);
        else if ( start <= seg[index].start && end >= seg[index].end)
            return seg[index];
        node left = find(index * 2, start, end);
        node right = find (index * 2 + 1, start, end);
        return left.val > right.val ? right : left ;
    }

    static void hist(int start, int end) {
        node min = find(1 , start, end);

        output = Math.max(min.val * (end - start + 1), output);
        if(start != min.origin) hist (start , min.origin -1);
        if(end != min.origin) hist (min.origin + 1, end);
    }
}

class node {
    int start;
    int end;
    int origin;
    public node(int start, int end, int origin, long val) {
        this.start = start;
        this.end = end;
        this.origin = origin;
        this.val = val;
    }
    long val;
}



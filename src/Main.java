import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        String[] num = br.readLine().split(" ");
        ArrayList<Integer> valid = new ArrayList<>();
        int [] nge = new int[n + 1];
        int last, pop, recent = 0, max = 0;

        for (int i = 0 ; i < n ; i ++)
            stack.push(Integer.parseInt(num[i]));

        for (last = n; last > 0; last --){
            pop = stack.pop();
            nge[last] = -1;
            if(pop <= max) {
                if (recent > pop) {
                    valid.add(nge[last] = recent);
                }
                else
                    for (int i = valid.size() - 1; i >= 0; i--)
                        if (valid.get(i) > pop) {
                            valid.add(nge[last] = valid.get(i));
                            break;
                        }
            }
            max = Math.max(recent = pop, max);
        }

        for (int i = 1; i <=n ; i++)
            bw.write(nge[i] + " ");
        bw.flush();
        bw.close();
    }

}



import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> dp = new ArrayList<>();
        HashSet<Integer> feet = new HashSet<>();
        dp.add(0);
        int temp = Integer.parseInt(st.nextToken());
        dp.add(2);
        feet.add(0);
        feet.add(temp);
        while((temp = Integer.parseInt(st.nextToken())) != 0) {
            if (feet.contains(temp))
                dp.add(dp.get(dp.size() - 1) + 1);
            else {
                if(feet.contains(0)){
                    dp.add(dp.get(dp.size() - 1) + 2);
                    feet.remove(0);
                }
                else if (feet.contains(temp == 4 ? 1 : temp + 1 )) {
                    dp.add(dp.get(dp.size() - 1) + 3);
                    feet.remove(temp == 4 ? 1 : temp + 1);
                } else if (feet.contains(temp == 1 ? 4 : temp - 1)) {
                    dp.add(dp.get(dp.size() - 1) + 3);
                    feet.remove(temp == 1 ? 4 : temp - 1);
                } else {
                    dp.add(dp.get(dp.size() - 1) + 4);
                    if (temp <= 2)
                        feet.remove(temp + 2);
                    else
                        feet.remove(temp - 2);
                }
                feet.add(temp);
            }
        }




        bw.write(Integer.toString(dp.get(dp.size() - 1)));
        bw.flush();
        bw.close();
    }


}



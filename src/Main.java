import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] wire = new int [n][2];
        for (int i = 0; i <n ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 2; j ++)
                wire[i][j] = Integer.parseInt(st.nextToken());
        }



        전봇대에서 교차하는게 업다 => 항상 증가ㅏㅏ 아니면 항상 감소하는 방향이어야만 한다.


        bw.write(Integer.toString(123));
        bw.flush();
        bw.close();
    }

}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int []mh = new int[n + 1];
        int temp, last = 1;

        for (int i = 0 ; i < n ; i ++){
            temp = Integer.parseInt(br.readLine());
            if(temp == 0) {
                bw.write(mh[1] + "\n");
                if(last > 1) {
                    mh[1] = mh[--last];
                    mh[last] = 0;
                    remove(mh, 1, mh[1]);
                }
            }
            else{
                mh[last] = temp;
                insert(mh, last++, temp);
            }
        }

        bw.flush();
        bw.close();
    }

    static void insert(int[] mh, int last, int num){
        if(last == 1)
            return;
        else{
            if(mh[last / 2] < num)
                swap(mh, last, last/2);
            insert(mh, last / 2, num);
        }
    }
    static void remove(int[] mh, int root, int num){
        //reverse insert..?
        if(root * 2 + 1 >= mh.length )
            return;
        else {
            ...///
        }

    }
    static void swap(int[] mh, int i , int j){
        int temp = mh[j];
        mh[j] = mh[i];
        mh[i] = temp;
    }

}



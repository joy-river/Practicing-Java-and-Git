import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
       int n = Integer.parseInt(br.readLine());

        EEA(10, -12);
        bw.flush();
        bw.close();

    }


    static int gcd(int a, int b){
        if(b == 0)
            return a;

        return gcd(b, a % b);
    }
    static void EEA(int a, int b) throws IOException {
        int r0=a, r1=b;
        int s0=1, s1=0;
        int t0=0, t1=1;
        int temp=0,q=0;

        while(r1 != 0){
            q=r0/r1;
            temp=r0;
            r0=r1;
            r1=temp-r1*q;
            temp=s0;
            s0=s1;
            s1=temp-s1*q;
            temp=t0;
            t0=t1;
            t1=temp-t1*q;
        }
        bw.write(s0 +  "\n" + t0);
    }
    ll exEuclid(ll a, ll b, ll &s, ll &t) {
        if (b == 0) {
            s = 1; t = 0;
            return a;
        }
        ll gcd = exEuclid(b, a%b, s, t);
        ll tmp = t;
        t = s - (a / b)*t;
        s = tmp;

        if (s <= 0) { //s를 양수로
            s += b;
            t -= a;
        }
        return gcd;
    }

}








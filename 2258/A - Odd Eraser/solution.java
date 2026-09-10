import java.io.*;
import java.util.*;
 
public class Main {
 
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int t = Integer.parseInt(br.readLine().trim());
 
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
 
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            long first = Long.parseLong(st.nextToken());
            long last = first;
 
            for (int i = 1; i < n; i++) {
                last = Long.parseLong(st.nextToken());
            }
 
            System.out.println(gcd(first, last));
        }
    }
}
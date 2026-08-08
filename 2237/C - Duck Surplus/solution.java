import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
 
        StringBuilder out = new StringBuilder();
 
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
 
            long[] a = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
 
            for (int i = 0; i < n - 1; i++) {
                while (a[i] > a[i + 1]) {
                    long left = a[i];
                    long right = a[i + 1];
                    a[i] = right;
                    a[i + 1] = left + right;
                }
            }
 
            long ans = 0;
            for (long x : a) ans = Math.max(ans, x);
 
            out.append(ans).append('
');
        }
 
        System.out.print(out);
    }
}
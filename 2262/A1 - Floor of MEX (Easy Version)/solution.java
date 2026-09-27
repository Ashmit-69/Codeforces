import java.io.*;
import java.util.*;
 
public class Main {
 
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
 
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
 
        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');
 
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
 
            int res = 0;
            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = read();
            }
 
            return res * sign;
        }
    }
 
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
 
        int t = fs.nextInt();
 
        while (t-- > 0) {
            int n = fs.nextInt();
 
            int[] a = new int[n + 1];
 
            // Difference array.
            int[] diff = new int[n + 1];
 
            for (int k = 1; k <= n; k++) {
                a[k] = fs.nextInt();
 
                long m = a[k];
 
                // Numbers y for which floor(y / k) == m:
                //
                // [m*k, (m+1)*k - 1]
                //
                // All these numbers are forbidden.
 
                long left = m * k;
                long right = (m + 1) * k - 1;
 
                // We only care about y in [0, n-1].
                if (left < n) {
                    int l = (int) left;
                    int r = (int) Math.min((long) n - 1, right);
 
                    diff[l]++;
 
                    if (r + 1 < n) {
                        diff[r + 1]--;
                    }
                }
            }
 
            // Collect all numbers which are never in a forbidden interval.
            ArrayList<Integer> ans = new ArrayList<>();
 
            int active = 0;
 
            for (int x = 0; x < n; x++) {
                active += diff[x];
 
                if (active == 0) {
                    ans.add(x);
                }
            }
 
            out.append(ans.size()).append('
');
 
            for (int x : ans) {
                out.append(x).append(' ');
            }
 
            out.append('
');
        }
 
        System.out.print(out);
    }
}
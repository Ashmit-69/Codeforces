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
 
    static boolean possible(
            int m, int n,
            int[] l, int[] r,
            int[] u, int[] v
    ) {
 
        int need = 1; // Next position required in the subsequence
 
        for (int i = 0; i < n && need <= m; i++) {
 
            int leftRank = need;
            int rightRank = m - need + 1;
 
            // Left rank must NOT be in [l[i], r[i]]
            boolean leftValid =
                    leftRank < l[i] || leftRank > r[i];
 
            // Right rank must NOT be in [u[i], v[i]]
            boolean rightValid =
                    rightRank < u[i] || rightRank > v[i];
 
            if (leftValid && rightValid) {
                // Use this element for the current subsequence position
                need++;
            }
        }
 
        return need == m + 1;
    }
 
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
 
        int t = fs.nextInt();
        StringBuilder out = new StringBuilder();
 
        while (t-- > 0) {
            int n = fs.nextInt();
 
            int[] l = new int[n];
            int[] r = new int[n];
            int[] u = new int[n];
            int[] v = new int[n];
 
            for (int i = 0; i < n; i++) {
                l[i] = fs.nextInt();
                r[i] = fs.nextInt();
                u[i] = fs.nextInt();
                v[i] = fs.nextInt();
            }
 
            int answer = 0;
 
            // Try larger lengths first
            for (int m = n; m >= 1; m--) {
                if (possible(m, n, l, r, u, v)) {
                    answer = m;
                    break;
                }
            }
 
            out.append(answer).append('
');
        }
 
        System.out.print(out);
    }
}
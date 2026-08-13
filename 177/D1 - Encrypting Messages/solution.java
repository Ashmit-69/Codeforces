import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
 
        int n = fs.nextInt();
        int m = fs.nextInt();
        int c = fs.nextInt();
 
        long[] a = new long[n];
        long[] b = new long[m];
 
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }
 
        for (int i = 0; i < m; i++) {
            b[i] = fs.nextInt();
        }
 
        /*
         * For position i, the contributing b indices are:
         *
         * max(0, i - (n - m)) <= k <= min(m - 1, i)
         *
         * We need the sum of this range.
         *
         * Prefix sum lets us calculate it in O(1).
         */
 
        long[] prefix = new long[m + 1];
 
        for (int i = 0; i < m; i++) {
            prefix[i + 1] = prefix[i] + b[i];
        }
 
        StringBuilder ans = new StringBuilder();
 
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - (n - m));
            int right = Math.min(m - 1, i);
 
            long contribution = prefix[right + 1] - prefix[left];
 
            long result = (a[i] + contribution) % c;
 
            if (i > 0) {
                ans.append(' ');
            }
            ans.append(result);
        }
 
        System.out.println(ans);
    }
 
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
 
        FastScanner(InputStream in) {
            this.in = in;
        }
 
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }
 
        int nextInt() throws IOException {
            int ch;
            do {
                ch = read();
            } while (ch <= ' ');
 
            int sign = 1;
            if (ch == '-') {
                sign = -1;
                ch = read();
            }
 
            int num = 0;
            while (ch > ' ') {
                num = num * 10 + (ch - '0');
                ch = read();
            }
 
            return num * sign;
        }
    }
}
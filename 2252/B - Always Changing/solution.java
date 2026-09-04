import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();
 
        int t = fs.nextInt();
 
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
 
            int total0 = 0, total1 = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') total0++;
                else total1++;
            }
 
            /*
             * The deleted characters must alternate.
             * Therefore:
             *
             * |deleted0 - deleted1| <= 1
             *
             * The remaining string must also alternate, so:
             *
             * |kept0 - kept1| <= 1
             *
             * Since:
             * total0 - total1 =
             * (deleted0 - deleted1) + (kept0 - kept1)
             *
             * If |total0 - total1| > 2, it is impossible.
             */
            int totalDiff = total0 - total1;
 
            if (Math.abs(totalDiff) > 2) {
                out.append(-1).append('
');
                continue;
            }
 
            /*
             * Longest alternating subsequences:
             *
             * a = starts with 0, ends with 0
             *     diff kept0-kept1 = +1
             *
             * b = starts with 0, ends with 1
             *     diff = 0
             *
             * c = starts with 1, ends with 0
             *     diff = 0
             *
             * d = starts with 1, ends with 1
             *     diff = -1
             */
 
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
 
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
 
                if (ch == '0') {
                    // Start a new subsequence "0"
                    int newA = Math.max(1, b > 0 ? b + 1 : 0);
 
                    // 1 ... 0
                    int newC = d > 0 ? d + 1 : 0;
 
                    a = Math.max(a, newA);
                    c = Math.max(c, newC);
 
                } else {
                    // 0 ... 1
                    int newB = a > 0 ? a + 1 : 0;
 
                    // Start a new subsequence "1"
                    int newD = Math.max(1, c > 0 ? c + 1 : 0);
 
                    b = Math.max(b, newB);
                    d = Math.max(d, newD);
                }
            }
 
            int maxKeep = 0;
 
            // kept difference = +1
            if (Math.abs(totalDiff - 1) <= 1) {
                maxKeep = Math.max(maxKeep, a);
            }
 
            // kept difference = 0
            if (Math.abs(totalDiff) <= 1) {
                maxKeep = Math.max(maxKeep, Math.max(b, c));
            }
 
            // kept difference = -1
            if (Math.abs(totalDiff + 1) <= 1) {
                maxKeep = Math.max(maxKeep, d);
            }
 
            if (maxKeep == 0) {
                out.append(-1).append('
');
            } else {
                out.append(n - maxKeep).append('
');
            }
        }
 
        System.out.print(out);
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
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
 
        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
 
            do {
                c = read();
            } while (c <= ' ');
 
            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
 
            return sb.toString();
        }
 
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
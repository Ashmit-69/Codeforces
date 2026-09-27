import java.io.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();
 
        int t = fs.nextInt();
 
        while (t-- > 0) {
            long x = fs.nextLong();
            long y = fs.nextLong();
            long k = fs.nextLong();
 
            long d = y - x;
            long ans = 0;
 
            /*
             * Required:
             * (y+i) % (x+i)
             *
             * Since y = x + d:
             * (x+i+d) % (x+i) = d % (x+i)
             *
             * If x+i > d:
             * d % (x+i) = d
             *
             * So only process while x+i <= d.
             */
 
            long cnt = 0;
 
            if (d >= x) {
                cnt = Math.min(k, d - x + 1);
            }
 
            // Explicitly calculate the cases where x+i <= d
            for (long i = 0; i < cnt; i++) {
                ans += d % (x + i);
            }
 
            // After that, every month contributes d
            ans += (k - cnt) * d;
 
            out.append(ans).append('
');
        }
 
        System.out.print(out);
    }
 
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;
 
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
 
        long nextLong() throws IOException {
            int c;
 
            do {
                c = read();
            } while (c <= ' ');
 
            long sign = 1;
 
            if (c == '-') {
                sign = -1;
                c = read();
            }
 
            long result = 0;
 
            while (c > ' ') {
                result = result * 10 + (c - '0');
                c = read();
            }
 
            return result * sign;
        }
 
        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}
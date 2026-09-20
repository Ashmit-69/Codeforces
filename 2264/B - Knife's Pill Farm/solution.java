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
 
        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');
 
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = read();
            }
 
            long res = 0;
            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = read();
            }
 
            return neg ? -res : res;
        }
 
        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
 
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
 
        int t = fs.nextInt();
 
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
 
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextLong();
            }
 
            // Max-heap: largest among the currently selected
            // smallest m-1 elements is on top.
            PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
 
            long sum = 0;
            long ans = Long.MIN_VALUE;
 
            for (int j = 0; j < n; j++) {
 
                // a[j] is considered as the last selected element.
                if (pq.size() == m - 1) {
                    long score = (long) m * a[j] - sum;
                    ans = Math.max(ans, score);
                }
 
                // Add a[j] for possible future last elements.
                if (m > 1) {
                    pq.add(a[j]);
                    sum += a[j];
 
                    // Keep only the m-1 smallest values.
                    if (pq.size() > m - 1) {
                        sum -= pq.poll();
                    }
                }
            }
 
            out.append(ans).append('
');
        }
 
        System.out.print(out);
    }
}
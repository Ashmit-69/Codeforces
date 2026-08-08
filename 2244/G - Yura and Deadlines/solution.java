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
            while ((c = read()) <= ' ') ;
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sign;
        }
 
        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
 
    static class BITMax {
        int n;
        long[] bit;
 
        BITMax(int n) {
            this.n = n;
            bit = new long[n + 2];
        }
 
        void update(int idx, long val) {
            while (idx <= n) {
                if (bit[idx] < val) bit[idx] = val;
                idx += idx & -idx;
            }
        }
 
        long query(int idx) {
            long res = 0;
            while (idx > 0) {
                if (res < bit[idx]) res = bit[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }
 
    static int lowerBound(long[] arr, long x) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr[m] < x)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }
 
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
 
        int T = fs.nextInt();
 
        while (T-- > 0) {
            int n = fs.nextInt();
 
            long[] a = new long[n + 1];
 
            ArrayList<Long>[] temp = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) temp[i] = new ArrayList<>();
 
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextLong();
                long key = i + a[i];
                for (int x = i; x <= n; x += x & -x)
                    temp[x].add(key);
            }
 
            long[][] vals = new long[n + 1][];
            BITMax[] trees = new BITMax[n + 1];
 
            for (int i = 1; i <= n; i++) {
                ArrayList<Long> list = temp[i];
                Collections.sort(list);
 
                int m = 0;
                for (long v : list) {
                    if (m == 0 || v != list.get(m - 1))
                        list.set(m++, v);
                }
 
                vals[i] = new long[m];
                for (int j = 0; j < m; j++)
                    vals[i][j] = list.get(j);
 
                trees[i] = new BITMax(m);
            }
 
            long ans = 0;
            long[] dp = new long[n + 1];
 
            for (int i = 1; i <= n; i++) {
 
                int limit = i - (int) a[i] - 1;
                long best = 0;
 
                for (int x = limit; x > 0; x -= x & -x) {
                    int pos = lowerBound(vals[x], i);
                    best = Math.max(best, trees[x].query(pos));
                }
 
                dp[i] = best + a[i];
                ans = Math.max(ans, dp[i]);
 
                long key = i + a[i];
 
                for (int x = i; x <= n; x += x & -x) {
                    int pos = lowerBound(vals[x], key) + 1;
                    trees[x].update(pos, dp[i]);
                }
            }
 
            out.append(ans).append('
');
        }
 
        System.out.print(out);
    }
}
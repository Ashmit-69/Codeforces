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
 
            int[] parent = new int[n + 1];
            int[] depth = new int[n + 1];
 
            // p[i] < i, so depth of i can be calculated immediately.
            for (int i = 2; i <= n; i++) {
                parent[i] = fs.nextInt();
                depth[i] = depth[parent[i]] + 1;
            }
 
            int m = fs.nextInt();
 
            int[] dams = new int[m];
 
            int shallowest = -1;
            int minDepth = Integer.MAX_VALUE;
 
            for (int i = 0; i < m; i++) {
                dams[i] = fs.nextInt();
 
                if (depth[dams[i]] < minDepth) {
                    minDepth = depth[dams[i]];
                    shallowest = dams[i];
                }
            }
 
            // Minimum possible number of cameras is m - 1.
            out.append(m - 1);
 
            // Put a camera on the parent edge of every dam
            // except the shallowest dam.
            for (int v : dams) {
                if (v != shallowest) {
                    out.append(' ').append(v);
                }
            }
 
            out.append('
');
        }
 
        System.out.print(out);
    }
}
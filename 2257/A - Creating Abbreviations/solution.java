import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();
 
        int t = fs.nextInt();
 
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
 
            boolean[] available = new boolean[26];
 
            // Store all first letters of initial words
            for (int i = 0; i < n; i++) {
                String word = fs.next();
                available[word.charAt(0) - 'a'] = true;
            }
 
            boolean possible = true;
 
            for (int i = 0; i < m; i++) {
                String abbreviation = fs.next();
 
                for (char c : abbreviation.toCharArray()) {
                    if (!available[c - 'A']) {
                        possible = false;
                    }
                }
            }
 
            out.append(possible ? "YES
" : "NO
");
        }
 
        System.out.print(out);
    }
 
    // Fast input reader
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
 
        FastScanner(InputStream is) {
            in = is;
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
            } while (c <= ' ' && c != -1);
 
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
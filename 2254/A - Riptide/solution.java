import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();
 
        int t = fs.nextInt();
 
        while (t-- > 0) {
            int[] x = {
                fs.nextInt(),
                fs.nextInt(),
                fs.nextInt()
            };
 
            int rounds = 0;
 
            while (true) {
                // If any two players have the same number of tokens
                if (x[0] == x[1] || x[1] == x[2] || x[0] == x[2]) {
                    break;
                }
 
                int minIndex = 0;
                int maxIndex = 0;
 
                for (int i = 1; i < 3; i++) {
                    if (x[i] < x[minIndex]) {
                        minIndex = i;
                    }
 
                    if (x[i] > x[maxIndex]) {
                        maxIndex = i;
                    }
                }
 
                // Player with maximum gives one token
                // to the player with minimum
                x[maxIndex]--;
                x[minIndex]++;
 
                rounds++;
            }
 
            out.append(rounds).append('
');
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
 
            int result = 0;
            while (c > ' ') {
                result = result * 10 + (c - '0');
                c = read();
            }
 
            return result * sign;
        }
    }
}